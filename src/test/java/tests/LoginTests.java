package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import skreens.AuthenticationScreen;
import skreens.ContactListScreen;
import skreens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess() {
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("d@gmail.com")
                .fillPassword("DariaM1991!")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");

    }

    @Test
    public void loginSuccessModel(){
        boolean result = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991!").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);

    }

    @Test
    public void loginSuccessModel2(){
       Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991!").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));

    }

    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("dgmail.com").password("DariaM1991!").build())
        .submitLoginNegative()
        .isErrorMessageHasText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }



    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }
}
