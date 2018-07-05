package com.baizhi.cmfz.util;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtils {
	
	public static String encryptions(String str){
		return DigestUtils.md5Hex(str);
	}
	
	public static String getRandomSalt(int count){
		char[] chs = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		
		Random random = new Random();
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < count; i++) {
			builder.append(chs[random.nextInt(chs.length)]);
		}
		return builder.toString();
	}
	
}
