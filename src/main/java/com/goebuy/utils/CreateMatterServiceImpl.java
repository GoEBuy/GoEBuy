
//package com.goebuy.utils;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
////import freemarker.template.Configuration;
////import freemarker.template.Template;
////import freemarker.template.TemplateException;
//
///**   
//*    
//@Component
//public class CreateMatterServiceImpl implements IMailsendService {
//
//	private JavaMailSender javaMailSender;
//	private Configuration configuration;
//	
//	/**(非 Javadoc)
//	 * <p>Title: sendMessage</p>
//	 * <p>Description(描述):使用后模板发送邮件 </p>
//	 * @see org.service.IMailsendService#sendMessage()
//	 */
//
//	@Override
//	public void sendMessage() {
//		MimeMessage message = javaMailSender.createMimeMessage();
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
//			helper.setFrom("jerry@mail.com");
//			helper.setTo("tina@mail.com");
//			helper.setSubject("使用模板进行发送邮件");
//			helper.setText(getText(),true);
//			//从模板里面读取
//			javaMailSender.send(message);
//		} catch (MessagingException e) {
//			// TODO 异常执行块！
//			e.printStackTrace();
//		}
//	}
//	
//	//读取模板
//	private String getText(){
//		String txt = "";
//		try {
//			Template template  = configuration.getTemplate("mail.ftl");
//			//通过map传递动态数据
//			Map map = new HashMap();
//			map.put("username","雄雄");
//			//解析模板文件
//			txt = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
//			} catch (IOException e) {
//			// TODO 异常执行块！
//			e.printStackTrace();
//		} catch (TemplateException e) {
//				// TODO 异常执行块！
//				e.printStackTrace();
//			}
//		
//		return txt;
//	}
//	
//
//	public JavaMailSender getJavaMailSender() {
//		return javaMailSender;
//	}
//
//	public void setJavaMailSender(JavaMailSender javaMailSender) {
//		this.javaMailSender = javaMailSender;
//	}
//
//	public Configuration getConfiguration() {
//		return configuration;
//	}
//
//	public void setConfiguration(Configuration configuration) {
//		this.configuration = configuration;
//	}
//
//}