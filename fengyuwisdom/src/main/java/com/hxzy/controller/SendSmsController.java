package com.hxzy.controller;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.core.http.HttpMethod;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.hxzy.config.SysConfig;
import com.hxzy.entity.Admin;
import com.hxzy.service.AdminService;
import com.hxzy.util.NumValidate;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import darabonba.core.RequestConfiguration;
import darabonba.core.client.ClientOverrideConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

@Controller
public class SendSmsController {
    @Autowired
    AdminService adminService;
    @RequestMapping(value = "/validatePhone",method = RequestMethod.POST)
    @ResponseBody
    public R queryPhone(String phone, HttpSession session){
        String regexp="^1[3|4|5|7|8]\\d{9}$";
        boolean matches = Pattern.matches(regexp, phone);
        if(!matches){
            R r = RUtil.fail();
            r.setMsg("请输入正确手机号");
            return r;
        }else {
            PageBean querylist = adminService.querylist();
            List<Admin> data = (List<Admin>)querylist.getData();
            for (int i = 0; i < data.size(); i++) {
                //如果存在用户的手机号
                if (data.get(i).getPhone()!=null&&data.get(i).getPhone().equals(phone)) {
                    session.setAttribute(SysConfig.CURRENTUSER,data.get(i));
                    return RUtil.ok(data.get(i));
                }
            }
            R r = RUtil.fail();
            r.setMsg("该手机号未注册");
            return RUtil.fail();
        }
    }

    @RequestMapping(value = "/sendSms",method = RequestMethod.POST)
    @ResponseBody
    public R sendSms(String phone){
        //配置credentials 认证信息，包括
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId("LTAI5tCfBr9mqxoPwdbGVp8b")
                .accessKeySecret("7Vv4wnmREWTin37CpzU6xpXhSEj8Fx")
                .build()
        );
        //配置产品client
        AsyncClient client=AsyncClient.builder()
                .region("cn-chengdu")
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();
        //api请求的参数设置
        String nonce_str = NumValidate.getNonce_str();
        SendSmsRequest sendSmsRequest=SendSmsRequest.builder()
                .signName("阿里云短信测试")
                .templateCode("SMS_154950909")
                .phoneNumbers(phone)
                .templateParam("{'code':'"+nonce_str+"'}")
                .requestConfiguration(RequestConfiguration.create().setHttpMethod(HttpMethod.GET))
                .build();
        //异步获取接口请求返回值
        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = null;
        try {
            resp = response.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        System.out.println(new Gson().toJson(resp));
        client.close();
        //将验证码返回
        System.out.println(nonce_str);
        return RUtil.ok(nonce_str);
    }
}
