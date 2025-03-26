package skreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resourse-id = 'com.sheygam.contactapp:id/version_text']")
    AndroidElement versionTextView;

    @FindBy(xpath = "//*[@resourse-id = 'com.sheygam.contactapp:id/title_text']")
    AndroidElement tittleTextView;

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
}
