package com.cloud.pay.merchant;

import com.cloud.pay.merchant.util.MD5;

public class DigestTest {

	public static void main(String[] args) throws Exception {
		System.out.println(MD5.md5("11.50" + "|" + "0.00" , 
				"1"));
		System.out.println(MD5.md5("0" + "|" + "0" , 
				"8"));
		System.out.println(MD5.md5("0.00|0.00" , 
				"1"));
	}

}
