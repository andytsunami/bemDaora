package br.com.remembr.bemDaora.utils;

import org.jboss.crypto.CryptoUtil;

public class PasswordEncrypter {
	
	public static String encrypt(String password){
			return CryptoUtil.createPasswordHash("MD5", CryptoUtil.BASE64_ENCODING, null, null, password);
	}
}