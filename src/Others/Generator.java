/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author dinis
 */
public class Generator {
    
    public static String generatePassword(){
    
        String pwd = RandomStringUtils.randomAlphanumeric(6);
        return pwd;
        
    }
    
    public static int generateOTP(){
    
        Random r = new Random();
        int otp = r.nextInt(10000, 100000);
        
        return otp;
    
    }
    
    public static int generateSaltNumber(){
    
        Random r = new Random();
        int otp = r.nextInt(100, 1000);
        
        return otp;
    
    }
}
