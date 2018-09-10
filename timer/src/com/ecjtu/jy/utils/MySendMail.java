package com.ecjtu.jy.utils;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MySendMail {
	 /** 发信人 */  
    public static String Sendfrom="smileboy.shi@foxmail.com";  
    /** 收信人 */  
    //private String to;  
    /** 主题 */  
    public static String subject="剪影-验证码";  
    /** 正文 */  
    private String body;  
      
      /**  
         * 发送邮件. 
         * @return boolean - 发送结果  
         */  
        public static boolean sendMail(String reciver,String checkId) {  
            
            try {  
                Properties props = new Properties();  
                props.put("username", "smileboy.shi@foxmail.com");   
                props.put("password", "twecojtwnfidfddg");   
                props.put("mail.transport.protocol", "smtp" );  
                props.put("mail.smtp.host", "smtp.qq.com");  
                //props.put("mail.smtp.port", "25" );  
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
                Session mailSession = Session.getDefaultInstance(props);  
                Message msg = new MimeMessage(mailSession);   
      
                msg.setFrom(new InternetAddress(Sendfrom));  
                msg.addRecipients(Message.RecipientType.TO, InternetAddress  
                        .parse(reciver));  
                msg.setSentDate(new Date());  
                msg.setSubject(subject);   
      
                msg.setText("剪影验证码:"+checkId+"\n"+"如非本人操作，请忽略此信息"+"该验证码有效时间为10分钟"+"\n"+"-------来自剪影"+"\n"+"本邮件为系统邮件请勿回复");  
                msg.saveChanges();  
                System.out.println("正在连接服务器。。。。");  
                Transport transport = mailSession.getTransport("smtp");  
                transport.connect(props.getProperty("mail.smtp.host"), props  
                        .getProperty("username"), props.getProperty("password"));   
                  
                System.out.println("正在发送邮件。。。。");  
                transport.sendMessage(msg, msg.getAllRecipients());  
                transport.close();   
                System.out.println("发送完毕。。。。");  
      
            } catch (Exception e) {  
                e.printStackTrace();  
                System.out.println(e);  
                return false;  
            }  
            return true;  
        }   
      
      
          
        
}

