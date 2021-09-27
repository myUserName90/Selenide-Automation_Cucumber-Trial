package ui.elements.reports.sportsbook;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ui.elements.BaseElements;

import java.util.function.Function;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CompetitionsElements extends BaseElements {

    protected SelenideElement timeType = $("[placeholder='Time Type ']");
    protected SelenideElement date = $("[placeholder='Date *']");
    protected SelenideElement livePreMatch = $("[placeholder='Live/Prematch ']");
    protected SelenideElement sport = $("[placeholder='Sport ']");
    protected SelenideElement region = $("[placeholder='Region ']");
    protected SelenideElement dropDown = $("div.dropdown-item");
    protected SelenideElement competition = $("[placeholder='Competition ']");
    protected Function<String, SelenideElement> filtersDropdown = (str) ->
            $(".dropdown-item > p").find(byText(str));
    protected Function<String, SelenideElement> sourceDropdown = (str) ->
            $(".popover-top-bottom-padding").findAll("p").find(Condition.text(str));
    protected SelenideElement source = $("[placeholder='Source ']");
    protected SelenideElement clientId = $("[placeholder='Client ID ']");
    protected SelenideElement isTest = $("[placeholder='Is Test ']");
    protected SelenideElement apply = $(".c-confirm > .ellipsis-text");

    protected ElementsCollection reportTableItem = $$(".ta-group .ta-row > [data-id]");

    protected SelenideElement startYearMinus = $(".date-box-1 .bc-icon-left-outline");
    protected SelenideElement endYearMinus = $(".date-box-2 .bc-icon-left-outline");
    protected Function<String, SelenideElement> startDay = el ->
            $(".datepicker-holder").findAll(byText(el)).first();
    protected Function<String, SelenideElement> endDay = el ->
            $(".datepicker-holder").findAll(byText(el)).last();
    protected Function<String, SelenideElement> byOwnText = el -> $(byText(el));
    protected SelenideElement startYear = $(".date-box-1 span:nth-child(2)");
    protected SelenideElement endYear = $(".date-box-2 span:nth-child(2)");
    protected SelenideElement pagesCount = $(".pagination-drop > p");
}
