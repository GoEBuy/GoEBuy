package com.goebuy.utils;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AttMailsendServiceImpl implements IMailsendService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMessage() {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom("yyyang@tju.edu.cn");
			helper.setTo("857659628@qq.com");
			helper.setSubject("带附件的邮件");
			//普通格式的
			//helper.setText("发送一个附件内容！<a href='http://www.baidu.com'>百度搜索</a>");
			//html格式的
			helper.setText("发送一个附件内容！<a href='http://www.baidu.com'>百度搜索</a>",true);
			//添加附件1
			ClassPathResource file1 = new ClassPathResource("config.properties");
			helper.addAttachment(file1.getFilename(),file1.getFile());
			//添加附件2
//			ClassPathResource file2 = new ClassPathResource("README.md");
//			helper.addAttachment(file2.getFilename(), file2.getFile());
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

}