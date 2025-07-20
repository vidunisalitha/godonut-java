/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dinis
 */
public class Emailer {

    static Session newSession = null;
    static MimeMessage mimeMessage = null;

    //Setup server properties
    public void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }

    //send email
    private void fromInfo() throws NoSuchProviderException, MessagingException {
        String from = "gwdcafesystem@gmail.com";
        String pwd = "sngc vzpi sgnf rgkp";
        String host = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(host, from, pwd);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        transport.close();
        System.out.println("Sent SuccessFully");
    }

    public static MimeMessage sendOTP(int OTP, String email, String name) throws MessagingException {

        Emailer emailer = new Emailer();
        emailer.setupServerProperties();

        String recipiant = email;
        String subject = "OTP for changing the password";
        String body = "<html><body>"
                + "Hi, " + name + "<br><br>"
                + "We received your request for a single-use code to use for changing your<br>"
                + "password.<br><br>"
                + "Your Single-use code is: " + OTP + "<br><br>"
                + "Only enter this code to our official cafe management system. If you need<br>"
                + "further information, please contact our administrator.<br><br>"
                + "Thanks,<br>"
                + "Gonuts with Donuts.<br>"
                + "Cafe Management System"
                + "</body></html>";

        mimeMessage = new MimeMessage(newSession);
        try {

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipiant));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(body, "text/html");

            emailer.fromInfo();

            return mimeMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static MimeMessage sendLoginInfo(String email, String name, String role, String userId, String password) {

        Emailer emailer = new Emailer();
        emailer.setupServerProperties();

        String recipiant = email;
        String subject = "Login Credentials for the system";
        String body = "<html><body>"
                + "Hi " + name + ",<br><br>"
                + "Welcome to Gonuts with Donuts.<br><br>"
                + "You have registered as a " + role + " to our Cafe Management System.<br>"
                + "Now you can use our system to continue your work.<br><br>"
                + "Here are your login credentials:<br>"
                + "Username: " + userId + "<br>"
                + "Password: " + password + "<br><br>"
                + "Please note that this is an auto-generated password from our system.<br>"
                + "It's required to change your password after you first log in to the system.<br><br>"
                + "If you have further clarifications, please contact our administrator.<br><br>"
                + "Thank you,<br>"
                + "Cafe Management System,<br>"
                + "Gonuts with Donuts."
                + "</body></html>";

        mimeMessage = new MimeMessage(newSession);
        try {

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipiant));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(body, "text/html");

            emailer.fromInfo();

            return mimeMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static MimeMessage sendTaskNotifications(String task, String dueDate, String commnet, String email) {

        Emailer emailer = new Emailer();
        emailer.setupServerProperties();

        String recipiant = email;
        String subject = "Task Notification";
        String body = "<html><body>"
                + "<br><br>"
                + "This is to notify you about a task that you have not completed.<br><br>"
                + "The task is " + task + ".<br>"
                + "and it needed to be completed within " + dueDate + "<br><br>"
                + "Please complete that task.<br>"
                + "if not the management team will take actions against you<br>"
                + "Thank you,"
                + "Cafe Management System,<br>"
                + "Gonuts with Donuts."
                + "</body></html>";

        mimeMessage = new MimeMessage(newSession);
        try {

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipiant));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(body, "text/html");

            emailer.fromInfo();

            return mimeMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public static MimeMessage sendPwdChangedNotification(String date, String time, String userId, String email) {
        
        Emailer emailer = new Emailer();
        emailer.setupServerProperties();

        String recipiant = email;
        String subject = "Task Notification";
        String body = "<html><body>"
                + "<br><br>"
                +"Hi "+ userId+"<br><br>"
                + "Your password has been changed successfully<br><br>"
                + "Date "+date+".<br>"
                + "Time "+time+"<br><br>"
                + "Thank you,"
                + "Cafe Management System,<br>"
                + "Gonuts with Donuts."
                + "</body></html>";

        mimeMessage = new MimeMessage(newSession);
        try {

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipiant));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(body, "text/html");

            emailer.fromInfo();

            return mimeMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
