package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import skreens.AuthenticationScreen;

public class LoginSecondTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("d@gmail.com")
                .fillPassword("DariaM1991!")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }

    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991!").build())
                .submitLogin()
                .isAccountOpened()
                .logout();

    }

    @Test
    public void loginWrongEmail(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("dgmail.com").password("DariaM1991!").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }


}
