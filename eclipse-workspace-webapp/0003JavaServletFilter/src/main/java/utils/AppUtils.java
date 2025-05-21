package utils;  

import java.util.regex.Pattern;  

public class AppUtils {  
    public static final String nameRegex = "^[A-Za-z]+(?: [A-Za-z]+)*$";  
    public static final String emailRegex = "^[A-Za-z0-9-_.]+@[A-Za-z]+\\.[A-Za-z]{2,4}$";  
    public static final String contactRegex = "^[0-9]+$";  
    public static final String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#?.])(?!.*\\s)[A-Za-z\\d@#?.]{8,20}$";  

    public static boolean nameValidation(String name) {  
        return Pattern.compile(nameRegex).matcher(name).matches();  
    }  
    
    public static boolean emailValidation(String email) {  
        return Pattern.compile(emailRegex).matcher(email).matches();  
    }  

    public static boolean contactValidation(String contact) {  
        return Pattern.compile(contactRegex).matcher(contact).matches();  
    }  

    public static boolean passwordValidation(String password) {  
        return Pattern.compile(passwordRegex).matcher(password).matches();  
    }  
}