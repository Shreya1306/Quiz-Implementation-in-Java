package quiz;

import java.io.IOException;

import javax.mail.MessagingException;

public class MainClassEmail {
	
	public static void main(String[] args) throws MessagingException, IOException {
		
		final String emailMsgTxt = "Test Message Contents";
		final String emailSubjectTxt = "A test from gmail from manav";
		final String emailFromAddress = "asthagrwl240@gmail.com";
		final String[] sendTo = { "asthagrwl240@gmail.com" };

		
		new Via_email().sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt,emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");

	}

}
