package com.ecjtu.jy.utils;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.stream.FileImageOutputStream;

import sun.misc.BASE64Decoder;

public class MyUtil {
	 public final static String MD5(String s) {
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
	        try {
	            byte[] btInput = s.getBytes();
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要
	            mdInst.update(btInput);
	            // 获得密文
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 public static Timestamp getMyTime(){
		 Date date = new Date();//获得系统时间.
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String nowTime = sdf.format(date);//将时间格式转换成符合Timestamp要求的格式.
		 Timestamp dates =Timestamp.valueOf(nowTime);
		 return dates;
	 }
	 
	 public static String longTimeToStringStyle(Timestamp timestamp){
		 //Date date = new Date(timestamp);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String strTime = sdf.format(timestamp);
		 
		 return strTime;
		 
	 }
	 
	 /**
	  * 生成一个4位的验证码
	  * @return
	  */
	 public static String myRandom(){
		 Random r1=new Random();		 
		 int c1=r1.nextInt(10);
		 int c2=r1.nextInt(10);
		 int c3=r1.nextInt(10);
		 int c4=r1.nextInt(10);
		 String code=c1+""+c2+""+c3+""+c4;
		 return code;
	 }
	 
	 /**
	  * 使用BASE64Decoder对图片进行解压
	  * @param str base64压缩
	  * @param path 路径含图片名
	  * @throws IOException 异常
	  */
	 public static void saveImage(String str,String path) throws IOException{
		 
		 str = str.replaceAll(" ","+");//base64解密部分乱码问题（“+” 号，在urlecode编码中会被解码成空格）
		 BASE64Decoder decoder = new BASE64Decoder();
		 byte[] b = decoder.decodeBuffer(str);
         for(int i=0;i <b.length;++i)  
         {  
             if(b[i]<0)  
             {
                 b[i]+=256;  
             }  
         }  
         FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
		    imageOutput.write(b, 0, b.length); 
         //imageOutput.write(b);  
         imageOutput.flush();  
         imageOutput.close();   
		    
	 }
	 public static String getImgName(){
		 Date date = new Date();
		 DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		 String name = df.format(date);
		 return name;
	 }
	
	 
	 
}


















