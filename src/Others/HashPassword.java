/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.security.MessageDigest;

/**
 *
 * @author dinis
 */
public class HashPassword {

    public static String hash(String password, int saltNumber) {

        try {
            
            String saltValue = password + saltNumber;
            MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = msgDigest.digest(saltValue.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
