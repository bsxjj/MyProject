package com.ecjtu.jy.utils;

public class FileUtil {
	public static String getFileName(String header) {
		
		String[] tempArr1 = header.split(";");
		/**
		 * tempArr1中  
		 * tA[0] ———— 表单数据    
		 * tA[1] ———— 对应的页面元素的名称
		 * tA[2] ———— 上传的文件的名称
		 * 且以键值对的形式存在"name=***"等
		 */
		//用=切割，得到”{fileName，****.后缀名}“
		//IE浏览器中将得到”{fileName，文件路径\****.后缀名}“
		String[] tempArr2 = tempArr1[2].split("=");
		
		//获得文件名，substring————从最后一个"\"后一个字符开始切割，”\\“表示转义”\“，并将”\“替换为空
		String Filename = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return Filename;
	}
	public static String imgNameWithEnd(String str){
		String [] strs = str.split(";");
		strs = strs[0].split("/");
		return strs[1];
	}
	
	
}
