package main.webapp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	 public static void main(String [] args)
	   {
	      // 收件人电子邮箱
	      String to = "490346029@qq.com";

	      // 发件人电子邮箱
	      String from = "1277472464@qq.com";

	      // 指定发送邮件的主机为 localhost
	      String host = "smtp.qq.com";  //QQ 邮件服务器

	      // 获取系统属性
	      Properties properties = System.getProperties();

	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);

	      properties.put("mail.smtp.auth", "true");
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
		    public PasswordAuthentication getPasswordAuthentication()
		    {
		     return new PasswordAuthentication("1277472464@qq.com", "baochao99"); //发件人邮件用户名、密码
		    }
		   });

	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);

	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));

	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: 头部头字段
	         message.setSubject("I am handsome !");

	         // 设置消息体
	         message.setText("This is actual message");

	         // 发送消息
	         Transport.send(message);
	         System.out.println("Sent message successfully....from w3cschool.cn");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
