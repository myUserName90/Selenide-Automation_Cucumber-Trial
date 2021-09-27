package ui.elements.login;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {

    protected Map<String, String> validUser = Map.of("davit.badalyan@mailinator.com", "123456*aA");

    protected SelenideElement goToLoginPageBtn = $(".ellipsis-text");
    protected SelenideElement username = $("[data-key='email']");
    protected SelenideElement password = $("[data-key='password']");
    protected SelenideElement logInButton = $(".button.c-undefined");
    protected SelenideElement secondaryButton = $(".secondary-button.small-link");
    protected SelenideElement bcIconLoader = $(".bc-icon-loader");

}
