package com.angular.serviceImpl;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.pojo.Users;
import com.angular.service.MailService;
import com.angular.service.OtpService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	OtpService otpService;

	@Override
	public Users sendMail(String email) {
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port", "25");    
        //get Session   
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {   
        	
            protected PasswordAuthentication getPasswordAuthentication() {    
                return new PasswordAuthentication("sathishmecse15@gmail.com"
                		            		,"sathishme@15");  
                }    
               });      

        String numbers = "0123456789"; 
        
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otps = new char[4]; 
        String otp="";
        for (int i = 0; i < 4; i++) 
        { 
            otps[i] =  numbers.charAt(rndm_method.nextInt(numbers.length())); 
            otp +=  otps[i] ;
        } 
        
         otpService.sendOtp(otp,email);
        try {    
         MimeMessage message = new MimeMessage(session);   
         message.setFrom(new InternetAddress("sathishmecse15@gmail.com"));
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
         message.setSubject("This is Test mail");    
         message.setText("please do not share this OTP:"+otp);  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);
        }
		return null;   
				
	}		
}
