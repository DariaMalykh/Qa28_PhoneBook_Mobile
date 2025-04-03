package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import skreens.AuthenticationScreen;
import skreens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {

    @BeforeMethod
    public void preCondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("d@gmail.com").password("DariaM1991!").build()).submitLogin();

    }

    @Test
    public void deleteFirstContact(){
        new ContactListScreen(driver).deleteFirstContact();
    }
}
