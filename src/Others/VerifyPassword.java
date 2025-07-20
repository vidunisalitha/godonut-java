/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

/**
 *
 * @author dinis
 */
public class VerifyPassword {
    
    public static boolean verify(String originalPassword, int saltNumber, String storedHashedPassword){
    
        String hashPassword = HashPassword.hash(originalPassword, saltNumber);
        return hashPassword.equals(storedHashedPassword);
    
    }
    
}
