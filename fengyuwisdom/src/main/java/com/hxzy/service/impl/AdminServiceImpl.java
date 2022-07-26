package com.hxzy.service.impl;

import com.hxzy.config.SysConfig;
import com.hxzy.entity.Admin;
import com.hxzy.mapper.AdminMapper;
import com.hxzy.service.AdminService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;


@Service
public class AdminServiceImpl  implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public R login(Admin admin, HttpSession session) {
        //用户一定时间内，连续多次出错，应该锁定账户？
        //校验
        if (admin !=null && admin.getAccount() !=null){
            //2,校验验证码
            if (admin.getCaptcha().equals(session.getAttribute("code").toString())){
                //查询
                Admin admin1 = adminMapper.selectByName(admin.getAccount());
                if (admin1 !=null){
                    //校验密码
                    if (admin1.getPassword().equals(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()))){
                        //登录成功
                        session.setAttribute(SysConfig.CURRENTUSER,admin1);
                        //记录日志

                        return RUtil.ok(admin1);
                    }
                }
            }
        }

        return RUtil.fail();
    }
}
