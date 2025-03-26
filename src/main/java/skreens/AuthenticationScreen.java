package skreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "")
    AndroidElement emailEditText;

    @FindBy(xpath = "")
    AndroidElement passwordEditText;

    @FindBy(xpath = "")
    AndroidElement loginButton;

    public AuthenticationScreen fillEmail(String email){
        type(emailEditText,email);

        return this;
    }

    public AuthenticationScreen fillPassword(String password){
        type(passwordEditText,password);

        return this;
    }

    public ContactListScreen submitLogin(){
        loginButton.click();

        return new ContactListScreen(driver);
    }
}
