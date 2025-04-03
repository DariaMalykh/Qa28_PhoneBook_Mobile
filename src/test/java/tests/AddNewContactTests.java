package tests;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import skreens.AuthenticationScreen;
import skreens.BaseScreen;
import skreens.ContactListScreen;

import java.util.ConcurrentModificationException;
import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    @BeforeMethod
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991!").build()).submitLogin();

    }

    @Test
    public void createNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Wow")
                .email("Wow"+ i + "@gmail.com")
                .phone("67895467"+i)
                .address("Haifa")
                .description("Best friend")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastName());


    }

    @Test
    public void createNewContactSuccessReq(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Simon")
                .lastName("Wow")
                .email("Wow"+ i + "@gmail.com")
                .phone("67895467"+i)
                .address("Haifa")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAddedByName(contact.getName(),contact.getLastName());

    }

    @Test
    public void createNewContactWithEmpttyName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Wow")
                .email("Wow@gmail.com")
                .phone("6789546787")
                .address("Haifa")
                .description("Empty name")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsText("{name=must not be blank}");
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver).logout();

    }


}
