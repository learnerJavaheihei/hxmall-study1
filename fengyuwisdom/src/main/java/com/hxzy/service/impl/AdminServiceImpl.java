package com.hxzy.service.impl;

import com.hxzy.config.SysConfig;
import com.hxzy.entity.Admin;
import com.hxzy.entity.AdminExample;
import com.hxzy.mapper.AdminMapper;
import com.hxzy.service.AdminService;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.List;


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
    //分页查询
    @Override
    public PageBean querylist() {
        List<Admin> list = adminMapper.selectByExample(new AdminExample());
        return new PageBean(0,"",list.size(),list);
    }
    //新增
    @Override
    public R sava(Admin admin) {
        if(admin !=null && admin.getName() !=null){
            //密码加密
            admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
            if(adminMapper.insert(admin) !=1){
                return RUtil.ok();
            }
        }
        return RUtil.fail();
    }

    //删除
    @Override
    public R delete(@Param("id") Integer id) {
        int i = adminMapper.deleteByPrimaryKey(id);
        return RUtil.ok();
    }

    //批量删除
    @Override
    public int deleteall(List<Integer> ids) {
        return adminMapper.deleteByPrimaryKeys(ids);
    }

    //修改
    @Override
    public int update(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }
    //修改中的查询
    @Override
    public Admin queryBySid(Admin admin) {
        return adminMapper.selectByPrimaryKey(admin);}

    //搜索
    @Override
    public PageBean queryByParam(String name, String no) {
        List<Admin> list = adminMapper.queryByParam(name, no);
        return new PageBean(0,"",list.size(),list);
    }

}
