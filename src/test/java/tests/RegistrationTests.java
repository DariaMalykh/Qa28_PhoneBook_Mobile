package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import skreens.AuthenticationScreen;
import skreens.ContactListScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationSuccess(){
        int i = new Random().nextInt(1000)+1000;

        boolean result = new AuthenticationScreen(driver)
                .fillEmail("new"+i+"@gmail.com")
                .fillPassword("New12345$")
                .submitRegistration()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void registrationSuccessModel(){
        int i = new Random().nextInt(1000)+1000;

        Auth auth = Auth.builder().email("dod"+i+"@gmail.com").password("Dd12345$").build();

        boolean result = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistration()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void registrationWrongEmail(){
        int i = new Random().nextInt(1000)+1000;

         new AuthenticationScreen(driver)
                .fillEmail("new"+i+"gmail.com")
                .fillPassword("New12345$")
                .submitRegistrationNegative()
                .isErrorMessageHasText("must be a well-formed email address");
    }

    @Test
    public void registrationWrongPassword(){
        int i = new Random().nextInt(1000)+1000;

        new AuthenticationScreen(driver)
                .fillEmail("new"+i+"@gmail.com")
                .fillPassword("1234")
                .submitRegistrationNegative()
                .isErrorMessageHasText("At least 8 characters");
    }

    @Test
    public void registrationExistsUser(){
        Auth auth = Auth.builder().email("d@gmail.com").password("DariaM1991!").build();

        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(auth)
                .submitRegistrationNegative()
                .isErrorMessageHasText("User already exists");
    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver)
                .logout();
    }
}
