package com.ecjtu.jy.utils;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MySendMail {
	 /** ������ */  
    public static String Sendfrom="smileboy.shi@foxmail.com";  
    /** ������ */  
    //private String to;  
    /** ���� */  
    public static String subject="��Ӱ-��֤��";  
    /** ���� */  
    private String body;  
      
      /**  
         * �����ʼ�. 
         * @return boolean - ���ͽ��  
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
      
                msg.setText("��Ӱ��֤��:"+checkId+"\n"+"��Ǳ��˲���������Դ���Ϣ"+"����֤����Чʱ��Ϊ10����"+"\n"+"-------���Լ�Ӱ"+"\n"+"���ʼ�Ϊϵͳ�ʼ�����ظ�");  
                msg.saveChanges();  
                System.out.println("�������ӷ�������������");  
                Transport transport = mailSession.getTransport("smtp");  
                transport.connect(props.getProperty("mail.smtp.host"), props  
                        .getProperty("username"), props.getProperty("password"));   
                  
                System.out.println("���ڷ����ʼ���������");  
                transport.sendMessage(msg, msg.getAllRecipients());  
                transport.close();   
                System.out.println("������ϡ�������");  
      
            } catch (Exception e) {  
                e.printStackTrace();  
                System.out.println(e);  
                return false;  
            }  
            return true;  
        }   
      
      
          
        
}

