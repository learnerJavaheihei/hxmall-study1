package com.hxzy.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface CaptchaService {
    void createImg(HttpSession session,HttpServletResponse response) throws IOException;
}
