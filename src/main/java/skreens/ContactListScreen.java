package skreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.util.List;

public class ContactListScreen extends BaseScreen{

    public ContactListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    AndroidElement activityTextView;

    @FindBy(xpath="//*[@content-desc='More options']")
    AndroidElement menuOptions;

    @FindBy(xpath="//*[@text='Logout']")
    AndroidElement logoutBtn;

    @FindBy(xpath="//*[@content-desc = 'add']")
    AndroidElement plusBtnBtn;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<AndroidElement> contactNameList;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<AndroidElement> contactList;

    @FindBy(id="android:id/button1")
    AndroidElement yesBtn;




    public boolean isActivityTitleDisplayed(String text){
        //return activityTextView.getText().contains("Contact list");
        return isShouldHave(activityTextView,text,8);
    }

    public AuthenticationScreen logout(){
        if(activityTextView.getText().equals("Contact list")) {
            menuOptions.click();
            logoutBtn.click();
        }
        return new AuthenticationScreen(driver);
    }
    public ContactListScreen isAccountOpened(){
        Assert.assertTrue(isActivityTitleDisplayed("Contact list"));
        return this;
    }

    public AddNewContactScreen openContactForm(){
        //if(activityTextView.getText().equals("Contact list"))
            plusBtnBtn.click();
        return new AddNewContactScreen(driver);
    }

    public ContactListScreen isContactAddedByName(String name,String lastName){
        //List<AndroidElement>list = driver.findElements(By.xpath("//*[@resource-id='com.sheygam.contactapp:id/rowName']"));
        isShouldHave(activityTextView,"Contact list",10);
        boolean isPresent = false;
        for(AndroidElement el:contactNameList) {
            if (el.getText().equals(name + " " + lastName)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }

    public ContactListScreen deleteFirstContact(){
        AndroidElement first = contactList.get(0);
        Rectangle rectangle = first.getRect();//узнать координаты элемента
        int xFrom = rectangle.getX()+rectangle.getWidth()/8;
        int y= rectangle.getY()+rectangle.getHeight()/2;
        int xTo = rectangle.getWidth()-xFrom;

        TouchAction<?>touchAction = new TouchAction<>(driver);//со знаком вопроса принимается типизация самого драйвера
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release().perform();//захват точки и перетягивание к другой точке






        return this;
    }







}
