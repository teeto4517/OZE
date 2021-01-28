import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class signUpTest extends baseClass {
    baseClass base;
    landingScreen signUp;

    String email = "sarpongnanakwasi@gmail.com"; String password = "Password@1"; String Phone = "8063035492";
    String country ="Nigeria";

    public signUpTest() {
       base = PageFactory.initElements(driver, baseClass.class);
    }

    @Test
    public void signup () {
        signUp = base.initializeDriver();
        signUp.createUser(Phone,email,password,country);
        signUp.verifyUser();
    }
}
