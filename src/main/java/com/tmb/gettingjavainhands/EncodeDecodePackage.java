package com.tmb.gettingjavainhands;

import java.util.Base64;

import org.openqa.selenium.WebDriver;

public class EncodeDecodePackage {

	public static void main(String[] args) {
		String encodeToString = Base64.getEncoder().encodeToString("tmbkjgkk".getBytes());
		
		System.out.println(encodeToString);
		
		byte[] decode = Base64.getDecoder().decode(encodeToString);
		
		System.out.println(new String(decode));
		
		System.out.println(System.getProperty("os.name"));
		
		
	}

}
