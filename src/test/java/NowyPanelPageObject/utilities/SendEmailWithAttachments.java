package NowyPanelPageObject.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;
import java.io.FileFilter;

public class SendEmailWithAttachments {


    public static File lastFileModified(String dir) {
        File fl = new File(dir);
        File choice = null;
        if (fl.listFiles().length > 0) {
            File[] files = fl.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.isFile();
                }
            });
            long lastMod = Long.MIN_VALUE;

            for (File file : files) {
                if (file.lastModified() > lastMod) {
                    choice = file;
                    lastMod = file.lastModified();
                }
            }
        }
        return choice;

    }


    public static void sendEmailWithScreenOfError (String emailSubject, String screenName) {
        EmailAttachment emailAttachment = new EmailAttachment();
        String pathOfTheNewestScreen = lastFileModified("C:\\Users\\user\\IdeaProjects\\selenium\\src\\test\\java\\NowyPanelPageObject\\screens\\").getPath();
        emailAttachment.setPath(pathOfTheNewestScreen);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription("Picture Attachment");
        emailAttachment.setName(screenName);


        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.googlemail.com");
        email.setAuthenticator(new DefaultAuthenticator("testy@itaxi.pl", "TestyiTaxi"));

        email.setSSL(true);
        try {
            //Set From email address
            email.setFrom("testy@itaxi.pl");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //Set email Subject line

        email.setSubject(emailSubject);
        try {
            //Set Email Message
            email.setMsg("This is a screen of failure test");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            //Set Email To Address
            email.addTo("sylwia.kostka@itaxi.pl");
        } catch (EmailException e) {
            e.printStackTrace();
        }

        try {
            email.attach(emailAttachment);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {

            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

}

