package com.hxzy.service;

import com.hxzy.entity.Admin;
import com.hxzy.vo.R;


import javax.servlet.http.HttpSession;

public interface AdminService {
    R login(Admin admin, HttpSession session);
}
