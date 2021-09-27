package ui.elements;

import com.codeborne.selenide.SelenideElement;

import java.util.function.Function;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class BaseElements {

    protected SelenideElement splashLoader = $(".table-splash-loader");
    protected Function<String, SelenideElement> byOwnText = el -> $(byText(el));
    protected Function<String, SelenideElement> placeholder =
            el -> $x(format("//input[contains(@placeholder,'%s')]", el.trim()));
    protected Function<String, SelenideElement> placeholderMatches =
            el -> $(format("input[placeholder='%s']", el));
    protected Function<String, SelenideElement> minField = (str) -> $(byText(str)).parent().$("[placeholder='Min ']");
    protected Function<String, SelenideElement> maxField = (str) -> $(byText(str)).parent().$("[placeholder='Max ']");

    protected void clickOnDropdownArrow(SelenideElement el) {
        el.parent().parent().parent().find("i.icon.bc-icon-arrow-down").click();
    }
}
