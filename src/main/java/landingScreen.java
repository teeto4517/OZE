import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class landingScreen {

    public WebDriver driver;
    public WebDriverWait wait;

    public landingScreen (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(id = "com.daretoinnovate.oze:id/sign_up_button") WebElement signUpBtn;
    @FindBy(id = "com.daretoinnovate.oze:id/countryCodeHolder") WebElement countrySelector;
    @FindBy(id = "com.daretoinnovate.oze:id/textView_countryName") WebElement selectedCountry;
    @FindBy(id = "com.daretoinnovate.oze:id/editText_search") WebElement searchBar;
    @FindBy(id = "com.daretoinnovate.oze:id/phone_number") WebElement phoneNumberField;
    @FindBy(id = "com.daretoinnovate.oze:id/new_user_email") WebElement emailField;
    @FindBy(id = "com.daretoinnovate.oze:id/new_user_password") WebElement passwordField;
    @FindBy(id = "com.daretoinnovate.oze:id/new_user_password2") WebElement repeatPasswordField;
    @FindBy(id = "com.daretoinnovate.oze:id/btn_signup")WebElement nxtBtn;
    @FindBy(id = "com.daretoinnovate.oze:id/check_accept_terms")WebElement checkTerms;
    @FindBy(id = "com.daretoinnovate.oze:id/okay")WebElement Okay;
    @FindBy(id = "com.daretoinnovate.oze:id/verification_header")WebElement welcomeHeader;


    public void createUser (String phone, String email, String pwd, String country) {
        signUpBtn.click();
        countrySelector.click();
        searchBar.sendKeys(country);
        selectedCountry.click();
        phoneNumberField.sendKeys(phone);
        emailField.sendKeys(email);
        passwordField.sendKeys(pwd);
        repeatPasswordField.sendKeys(pwd);
        nxtBtn.click();

    }

    public void verifyUser () {
        checkTerms.click();
        Okay.click();
        wait.until(ExpectedConditions.visibilityOf(welcomeHeader));
    }


}
