package com.ecjtu.jy.utils;

public class FileUtil {
	public static String getFileName(String header) {
		
		String[] tempArr1 = header.split(";");
		/**
		 * tempArr1��  
		 * tA[0] �������� ������    
		 * tA[1] �������� ��Ӧ��ҳ��Ԫ�ص�����
		 * tA[2] �������� �ϴ����ļ�������
		 * ���Լ�ֵ�Ե���ʽ����"name=***"��
		 */
		//��=�и�õ���{fileName��****.��׺��}��
		//IE������н��õ���{fileName���ļ�·��\****.��׺��}��
		String[] tempArr2 = tempArr1[2].split("=");
		
		//����ļ�����substring�������������һ��"\"��һ���ַ���ʼ�и��\\����ʾת�塱\����������\���滻Ϊ��
		String Filename = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return Filename;
	}
	public static String imgNameWithEnd(String str){
		String [] strs = str.split(";");
		strs = strs[0].split("/");
		return strs[1];
	}
	
	
}
