package steps.reports.sportsbook;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.elements.reports.sportsbook.CompetitionsElements;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static java.lang.Integer.parseInt;

public class CompetitionsPageSteps extends CompetitionsElements {

    @When("I visit competitions report page")
    public void openCompetitions() {
        Selenide.open("http://spring-backoffice-st.betconstruct.int/reports/competitions");
    }

    @When("select {string} from Time type dropdown field")
    public void selectTimeType(String arg) {
        timeType.click();
        byOwnText.apply(arg).click();
    }

    @When("set year from {string} to {string}, day from {string} to {string}")
    public void selectDate(String startYear, String endYear, String from, String to) {
        date.shouldBe(visible).click();
        while (parseInt(startYear) < parseInt(this.startYear.getText())) {
            startYearMinus.click();
        }
        while (parseInt(endYear) < parseInt(this.endYear.getText())) {
            endYearMinus.click();
        }
        startDay.apply(from).click();
        startDay.apply(from).shouldHave(text(from));
        endDay.apply(to).click();
        endDay.apply(to).shouldHave(text(to));
        date.shouldHave(value(from));
        date.pressEnter();
        splashLoader.shouldBe(disappear);
        date.shouldHave(value(to));
    }

    @When("select {string} from Live Pre-Match dropdown field")
    public void selectLivePreMatch(String arg) {
        livePreMatch.click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @When("select {string} from Sports dropdown field")
    public void selectSport(String arg) {
        sport.click();
        sport.sendKeys(arg);
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Region dropdown field")
    public void selectRegion(String arg) {
        region.click();
        region.sendKeys(arg);
        dropDown.click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Competition dropdown field")
    public void selectCompetition(String arg) {
        competition.click();
        filtersDropdown.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Source dropdown field")
    public void selectSource(String arg) {
        source.scrollTo().click();
        String[] split = arg.split(",");
        Arrays.asList(split).forEach(el -> byOwnText.apply(el.trim()).scrollTo().click());
        clickOnDropdownArrow(source);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Client Id field")
    public void selectClientID(String arg) {
        clientId.sendKeys(arg);
    }

    @When("select {string} from is Test dropdown field")
    public void selectIsTest(String arg) {
        isTest.click();
        byOwnText.apply(arg).click();
    }

    @When("apply filter")
    public void apply() {
        apply.click();
        splashLoader.shouldBe(disappear);
    }

    @Then("The result should have {int} rows")
    public void pagesCount(int count) {
        if (count != 0) {
            pagesCount.shouldHave(text(" of " + count));
        } else {
            pagesCount.shouldNotBe(exist);
        }
    }

    private String getCellContent(int i) {
        return reportTableItem.get(i).lastChild().getOwnText();
    }

    private Double getCellContentUSD(int i) throws ParseException {
        DecimalFormat format = new DecimalFormat("$#,##0.00");
        format.setParseBigDecimal(true);

        String cellContent = getCellContent(i);
        String s = cellContent.replaceAll("\\(", "").replaceAll("\\)", "");
        BigDecimal decimal = (BigDecimal) format
                .parse(s);
        double result = decimal.doubleValue();
        if (cellContent.contains("(")) {
            result *= -1;
        }
        return result;
    }

    private Double getCellContentPercentage(int i) throws ParseException {
        DecimalFormat format = new DecimalFormat("#,##%0.00;-#");
        format.setParseBigDecimal(true);
        double d = format.parse(getCellContent(i)).doubleValue();
        return Math.round(d * 10000d) / 100d;
    }

    private Integer getCellSportId(int i) {
        return Integer.parseInt(Objects.requireNonNull(reportTableItem.get(i).lastChild().lastChild().attr("class")).replaceAll("\\D+", ""));
    }

}
