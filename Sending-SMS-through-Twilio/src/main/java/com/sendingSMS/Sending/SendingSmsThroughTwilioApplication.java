package com.sendingSMS.Sending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SendingSmsThroughTwilioApplication {

	// Replace with your actual Twilio Account SID and Auth Token
	public static final String ACCOUNT_SID = "";;
	public static final String AUTH_TOKEN = "";;

	public static void main(String[] args) {
		SpringApplication.run(SendingSmsThroughTwilioApplication.class, args);

		// Initialize the Twilio client with your account credentials
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		// Create and send the SMS message
		Message message = Message.creator(
						new PhoneNumber("+"),  // To number
						new PhoneNumber("+"),  // From number (Twilio number)
						"This is Adhiraj sending message from twilio")  // Message body
				.create();

		// Print the SID of the sent message
		System.out.println(message.getSid());
	}
}
