package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import constants.Constants;

public class ReadingEmails {

	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	private String result;
	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	String basePath = s + File.separator;



	public Store authenticate( String userName, String password) throws MessagingException {
		properties = new Properties();
		properties.setProperty("mail.host", "imap.gmail.com");
		properties.setProperty("mail.port", "993");
		properties.setProperty("mail.transport.protocol", "imaps");
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		store = session.getStore("imaps");
		store.connect();
		return store;
	}

	public boolean hasAttachments(String subject) throws Exception {
		boolean flag = false;
//			store = authenticate();
		for (int j = 0; j < 10; j++) {
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			if(messages.length==0) {
				Thread.sleep(10000);
			}
			else {
				System.out.println("Number of mails = " + messages.length);
				for (int i = 0; i < messages.length; i++) { 
					Message message = messages[i]; 
					Address[] from = message.getFrom(); 
					System.out.println("Date : " + message.getSentDate()); 
					System.out.println("From : " + from[0]);
					System.out.println("Subject: " + message.getSubject());
					System.out.println("Content :"+message.getContent()); 
					if(message.getSubject().equals(subject)) {
						flag = true;
						message.setFlag(Flag.SEEN, true);
						System.out.println("--------------------------------");
						if (message.isMimeType("multipart/mixed")) {
							Multipart mp = (Multipart)message.getContent();
							if (mp.getCount() > 1)
								return true;
						}
						if(flag==true) {
							break;
						}
					}

				}
			}

			if(flag==true) {
				inbox.close(true);
				store.close(); 
				break;
			}

		}
		return flag;
	}

	
	public void openMail(String userName,String pass,String sender,String subject,String body) throws Exception {
		final String user=userName;
		final String password=pass; 

		InternetAddress [] to= InternetAddress.parse(sender);

		//1) get the session object     
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");    

		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(user,password);  
			}  
		});  

		//2) compose message     
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(user));  
			message.addRecipients(Message.RecipientType.TO,to);
			message.setSubject(subject);
			

			//3) create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart();  
			messageBodyPart1.setText(body);  

			//4) create new MimeBodyPart object and set DataHandler object to this object      
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  



			//5) create Multipart object and add MimeBodyPart objects to this object      
			Multipart multipart = new MimeMultipart();  
			multipart.addBodyPart(messageBodyPart1);  

			//6) set the multiplart object to the message object  
			message.setContent(multipart );  

			//7) send message  
			Transport.send(message);  
			Thread.sleep(5000);
			System.out.println("message sent....");  
		}catch (MessagingException ex) {ex.printStackTrace();}  
		
	}
	
	public String getMailBodyContent(String userName,String password,String subject) throws Exception {
		boolean flag = false;
		store = authenticate(userName, password);
		//		for (int j = 0; j < 10; j++) {
		inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_WRITE);
		Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
		if(messages.length==0) {
			Thread.sleep(10000);
		}
		else {
			//				System.out.println("Number of mails = " + messages.length);
			for (int i = messages.length-1; i >= 0 ; i--) { 
				Message message = messages[i]; 
				Address[] from = message.getFrom(); 
				//					System.out.println("Date : " + message.getSentDate()); 
				//					System.out.println("From : " + from[0]);
				//					System.out.println("Subject: " + message.getSubject());
				if(message.getSubject().contains(subject)) {
					flag = true;
					message.setFlag(Flag.SEEN, true);

					if (message.getContentType().contains("multipart")) {
						Multipart parts = (Multipart)message.getContent();
						MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
						result = getTextFromMimeMultipart(mimeMultipart);
						//							System.out.println(result);
						//							System.out.println("----------------------------------------------------------");
					}

					if(message.isMimeType("text/plain") || message.isMimeType("text/html")) {
						//							System.out.println("No Attachment Found");
						result = message.getContent().toString();					
						//							System.out.println(result);
						//							System.out.println("---------------------------------------------------------");
					}
				}
				if(flag==true) {
					inbox.close(true);
					break;
				}
			}
		}

		//			if(flag==true) {
		//				inbox.close(true);
		//				break;
		//			}
		//		}
		return result;
	}


	public String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
		String result = "";
		int count = mimeMultipart.getCount();	
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break;
			} else if (bodyPart.isMimeType("text/html")) {
				result = result + "\n" + bodyPart.getContent();
				break;
			} else if (bodyPart.getContent() instanceof MimeMultipart){
				result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
			}
		}
		return result;
	}

	public String getMailBody(String subject,String mailUniqueContent) throws Exception {
		boolean flag = false;
		//store = authenticate(userName,password);
		for (int j = 0; j < 10; j++) {
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			if(messages.length==0) {
				Thread.sleep(10000);
			}
			else {
				System.out.println("Number of mails = " + messages.length);
				for (int i = 0; i < messages.length; i++) { 
					Message message = messages[i]; 
					Address[] from = message.getFrom(); 
					System.out.println("Date : " + message.getSentDate()); 
					System.out.println("From : " + from[0]);
					System.out.println("Subject: " + message.getSubject());
					System.out.println("Content :"+message.getContent()); 
					if(message.getSubject().equals(subject)) {
						Object content = message.getContent();
						if(String.valueOf(content).contains(mailUniqueContent)) {
							flag = true;
							message.setFlag(Flag.SEEN, true);
							System.out.println("--------------------------------");
							return message.getContent().toString();
						}
					}
					if(flag==true) {
						break;
					}
				}

			}
			if(flag==true) {
				inbox.close(true);
				store.close(); 
				break;
			}
		}
		throw new Exception("no email found");
	}

	public String getVeociLoginCode() throws Exception{
		FileOperations fileOperations=new FileOperations();
		Constants constants=new Constants();
		//EncryptionDecryption encryptionDecryptionObj = new EncryptionDecryption();

		String gmailID = fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "gmailID");
		String gmailPass = fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "gmailPass");

		//String gmailPass = encryptionDecryptionObj.decryptPassword(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "gmailPass"));
		String emailContent = getMailBodyContent(gmailID, gmailPass, "Your Veoci Login Code");	

		emailContent = emailContent.substring(emailContent.indexOf("<strong>") + 8);
		return emailContent.substring(0, emailContent.indexOf("</strong>"));
	}

	//App Specific Method
	public void sendEmail(String senderEmail, String senderPassword, String toEmails, 
			String ccEmails, String bccEmails, String subject, String body, String testRunStatus ) throws MessagingException {
		final String user=senderEmail;
		final String password=senderPassword; 

		InternetAddress [] to= InternetAddress.parse(toEmails);
		InternetAddress [] cc = InternetAddress.parse(ccEmails);
		InternetAddress [] bcc = InternetAddress.parse(bccEmails);

		//1) get the session object     
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");    

		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(user,password);  
			}  
		});  

		//2) compose message     
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(user));  
			message.addRecipients(Message.RecipientType.TO,to);
			message.addRecipients(Message.RecipientType.CC, cc);
			message.addRecipients(Message.RecipientType.BCC, bcc);

			//				if (testStatusForEmail.equalsIgnoreCase("fail")) {
			//					message.setSubject("FAILED : " + subject);
			//				} else{
			//					message.setSubject("PASSED : " + subject);
			//				}
			
			if (testRunStatus.equalsIgnoreCase("fail")) {
				message.setSubject("TEST EXECUTION FAILED - " + subject);
			} else {
				message.setSubject("TEST EXECUTION PASSED - " + subject);
			}
			

			//3) create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart();  
			messageBodyPart1.setText(body);  

			//4) create new MimeBodyPart object and set DataHandler object to this object      
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

			String filename = basePath + File.separator +  "Zipped Report/Zipped Report.zip";//change accordingly  
			DataSource source = new FileDataSource(filename);  
			messageBodyPart2.setDataHandler(new DataHandler(source));  
			messageBodyPart2.setFileName("Test Automation Report.zip");  


			//5) create Multipart object and add MimeBodyPart objects to this object      
			Multipart multipart = new MimeMultipart();  
			multipart.addBodyPart(messageBodyPart1);  
			multipart.addBodyPart(messageBodyPart2);  

			//6) set the multiplart object to the message object  
			message.setContent(multipart );  

			//7) send message  
			Transport.send(message);  

			System.out.println("message sent....");  
		}catch (MessagingException ex) {ex.printStackTrace();}  
	}

}


