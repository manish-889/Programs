package com.util;

import java.util.regex.Pattern;

public class RegexUtil {

	public static final String nameRegex = "^[A-Za-z]+(?: [A-Za-z]+)*$";  
    public static final String emailRegex = "^[A-Za-z0-9-_.]+@[A-Za-z]+\\.[A-Za-z]{2,4}$";   
    public static final String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#?.])(?!.*\\s)[A-Za-z\\d@#?.]{8,20}$";  

	public static boolean nameCheck(String uname) {
		return Pattern.compile(nameRegex).matcher(uname).matches();
	}
	
	public static boolean emailCheck(String email) {
		return Pattern.compile(emailRegex).matcher(email).matches();
	}
	
	public static boolean passCheck(String pass) {
		return Pattern.compile(passwordRegex).matcher(pass).matches();
	}
	
	
}
