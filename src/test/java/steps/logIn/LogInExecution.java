package steps.logIn;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import ui.elements.login.LoginElements;

import static com.codeborne.selenide.Condition.visible;

public class LogInExecution extends LoginElements {

    @Given("Login page")
    public void openLoginPage() {
        Selenide.open("http://spring-backoffice-st.betconstruct.int/");
    }

    @Given("The {string} is logged in")
    public void login(String arg) {
        openLoginPage();
        goToLoginPageBtn.click();
        username.sendKeys(arg);
        password.sendKeys(validUser.get(arg));
        logInButton.click();
        secondaryButton.click();
        bcIconLoader.shouldBe(visible);
    }

    @Given("I am an authenticated user")
    public void login() {
        openLoginPage();
        goToLoginPageBtn.click();
        username.sendKeys("davit.badalyan@mailinator.com");
        password.sendKeys(validUser.get("davit.badalyan@mailinator.com"));
        logInButton.click();
        secondaryButton.click();
        bcIconLoader.shouldBe(visible);
    }

    @And("I enter {string} in the password field")
    public void enterToPassField(String arg) {
        password.setValue(arg);
    }

    @And("I press the login button")
    public void clickOnLogInButton() {
        logInButton.click();
    }


}
