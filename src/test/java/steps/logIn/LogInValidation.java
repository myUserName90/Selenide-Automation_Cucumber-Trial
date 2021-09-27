package steps.logIn;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;

public class LogInValidation {

    @Then("The End")
    public void shouldBeLoggedIn() {
        Selenide.sleep(5000);
        System.out.println("Good");
    }

}
