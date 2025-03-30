package skreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id="")
    AndroidElement nameEditText;

    @FindBy(id="")
    AndroidElement lastNameEditText;

    @FindBy(id="")
    AndroidElement emailEditText;

    @FindBy(id="")
    AndroidElement phoneEditText;

    @FindBy(id="")
    AndroidElement addressEditText;

    @FindBy(id="")
    AndroidElement descriptionEditText;

    @FindBy(id="")
    AndroidElement createBtn;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(nameEditText,5);
        type(nameEditText,contact.getName());
        type(lastNameEditText, contact.getLastName());
        type(emailEditText,contact.getEmail());
        type(phoneEditText, contact.getPhone());
        type(addressEditText, contact.getAddress());
        type(descriptionEditText, contact.getDescription());
        return this;
    }

    public ContactListScreen submitContactForm(){
        createBtn.click();
        return new ContactListScreen(driver);
    }
}
