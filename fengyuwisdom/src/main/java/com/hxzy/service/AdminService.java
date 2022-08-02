package com.hxzy.service;

import com.hxzy.entity.Admin;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public interface AdminService {


    R login(Admin admin, HttpSession session);

    PageBean querylist();

    R sava(Admin admin);

    R delete(Integer id);

    PageBean queryByParam(String name, String no);

    Admin queryBySid(Admin admin);

    int update(Admin admin);


    int deleteall(List<Integer> ids);
}
