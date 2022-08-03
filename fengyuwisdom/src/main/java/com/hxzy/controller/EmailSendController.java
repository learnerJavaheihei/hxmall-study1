package com.hxzy.controller;

import com.hxzy.entity.Email;
import com.hxzy.util.RUtil;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/email")
public class EmailSendController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    SimpleMailMessage simpleMailMessage;
    @Autowired
    TaskExecutor taskExecutor;

    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    public R getUpload(@RequestBody MultipartFile file, HttpServletRequest request){
        if(file!=null){
            String realPath = request.getServletContext().getRealPath("/templates");
            File file1 = new File(realPath);
            if (!file1.exists()&&!file1.isDirectory()){
                file1.mkdirs();
            }
            try {
                String originalFilename = file.getOriginalFilename();
                File uploadFile = new File(realPath,originalFilename);
                file.transferTo(uploadFile);
                return RUtil.ok(uploadFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return RUtil.fail();
    }

    @RequestMapping(value = "/send.do",method = RequestMethod.POST)
    @ResponseBody
    public R sendAction(Email email) throws MessagingException {
        if(email.getEmail()!=null){
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        sendEmail(email);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            });
            return RUtil.ok();
        }
        return RUtil.fail();
    }

    public void sendEmail(Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(email.getEmail());
        messageHelper.setText(email.getContent());
        messageHelper.setFrom(simpleMailMessage.getFrom());
        messageHelper.setSubject(email.getTitle());
        FileSystemResource file = new FileSystemResource(new File(email.getFilepath()));
        messageHelper.addAttachment(email.getFilepath(),file);
        javaMailSender.send(message);
    }
}
