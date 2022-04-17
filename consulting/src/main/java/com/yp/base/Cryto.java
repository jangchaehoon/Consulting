package com.yp.base;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Cryto {
	
	//DB 암복호화
	public static void main(String[] args) {		
		System.out.println("=======================================================================================");
		System.out.println("복호화");
		
		StandardPBEStringEncryptor sPBEs = new StandardPBEStringEncryptor();
		sPBEs.setAlgorithm("PBEWithMD5AndDES");
		sPBEs.setPassword("genexon2021!");
		
		String smsUrl = "s8AC+ZiLUsLwX+WPpRk5gqz+dqJFa41MfydITLkBPY34ecZ9nyLplP8FQnRGG2nWfICIJV5qLq2tdNS9U3QKzVNqDMHseov6ecfVAagir+I0fk3zoAhYzSLH7zGdqSRvrlgjJZnyRrLUjtJM5wsyBVgBXhZdarU3";
		String smsUserName = "ZfvEzKOcme/27ySDi9Wo8YwS0OqxioDW";
		String smsPassword = "W5pO+9FSutyBeJv+QRCAj7KbjaumGAPrYkJ9Kzrsxxo=";
		
		smsUrl = sPBEs.decrypt(smsUrl);
		smsUserName = sPBEs.decrypt(smsUserName);
		smsPassword = sPBEs.decrypt(smsPassword);
		
		System.out.println(smsUrl);
		System.out.println(smsUserName);
		System.out.println(smsPassword);
		
		System.out.println("=======================================================================================");
		System.out.println("암호화");
		
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
		standardPBEStringEncryptor.setPassword("genexon2021!");
		
		String Url = "jdbc:oracle:thin:@114.203.84.230:3306:SMARTPLAN";
		String UserName = "DEV_ANYBIZ_HLL";
		String Password = "K4BcTyQyc27u5-fp";
		
		Url = standardPBEStringEncryptor.encrypt(Url);
		UserName = standardPBEStringEncryptor.encrypt(UserName);
		Password = standardPBEStringEncryptor.encrypt(Password);
		
		System.out.println("Url : " + Url);
		System.out.println("UserName : " + UserName);
		System.out.println("Password : " + Password);
		
		System.out.println("=======================================================================================");
		
		System.out.println("=======================================================================================");
		System.out.println("���� - ��ȣȭ �ϴ� �κ�");
		
		StandardPBEStringEncryptor standardPBEStringEncryptor2 = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor2.setAlgorithm("PBEWithMD5AndDES");
		standardPBEStringEncryptor2.setPassword("ypConsulting648!");
		
		String Url2 = "jdbc:mariadb://34.64.112.25:3306/DEV_CONSULTING?autoReconnect=true&characterEncoding=utf8&useUnicode=true";
		String UserName2 = "DEV_CONSULTING";
		String Password2 = "R?b@9@Pay$G2RdZA";
		
		Url2 = standardPBEStringEncryptor2.encrypt(Url2);
		UserName2 = standardPBEStringEncryptor2.encrypt(UserName2);
		Password2 = standardPBEStringEncryptor2.encrypt(Password2);
		
		System.out.println("Url : " + Url2);
		System.out.println("UserName : " + UserName2);
		System.out.println("Password : " + Password2);
		
		System.out.println("=======================================================================================");
		
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		System.out.println(spe.encode("asdf2"));
	}
}
