package br.com.edson.acessoBD;

import java.io.Serializable;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.internal.MailerRegularBuilderImpl;

public class TesteMail implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Email email = EmailBuilder.startingBlank()
			    .from("Edson", "nosdejs32@gmail.com")
			    .to("jose", "edsonjs_80@hotmail.com")
			    .withSubject("My Bakery is finally open!")
			    .withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!")
			    .buildEmail();

			MailerBuilder
			  .withSMTPServer("gmail", 25, "Edson Souza", "canibalVegetariano@*")
			  .buildMailer()
			  .sendMail(email);
		
		
		        

	}

}
