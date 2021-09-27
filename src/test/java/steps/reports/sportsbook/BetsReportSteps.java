package steps.reports.sportsbook;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ui.elements.reports.sportsbook.BetsReportElements;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.open;

public class BetsReportSteps extends BetsReportElements {

    @When("I visit Bets Reports page")
    public void openBetsReport() {
        open("http://spring-backoffice-st.betconstruct.int/reports/bet-report");
    }

    @When("type {string} in Bet ID field")
    public void selectTimeType(String arg) {
        betId.click();
        betId.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Player ID field")
    public void typeInPlayerIDField(String arg) {
        playerId.click();
        playerId.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @When("choose {string} from Bet Type dropdown field")
    public void selectBetType(String arg) {
        betType.click();
        String[] split = arg.split(",");
        Arrays.asList(split).forEach(el -> {
            byOwnText.apply(el.trim()).scrollTo().click();
        });
        clickOnDropdownArrow(betType);
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from State dropdown field")
    public void pickAsState(String arg) {
        state.click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from is Live dropdown field")
    public void pickIsLive(String arg) {
        isLive.click();
        byOwnText.apply(arg).click();
        clickOnDropdownArrow(isLive);
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Currency dropdown field")
    public void selectFromCurrencyDropdownField(String arg) {
        currency.scrollTo();
        currency.click();
        byOwnText.apply(arg).click();
        clickOnDropdownArrow(currency);
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Betshop Group dropdown field")
    public void selectFromBetshopGroupDropdownField(String arg) {
        betShopGroup.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Betshop dropdown field")
    public void selectFromBetshopDropdownField(String arg) {
        betShop.scrollIntoView(true).click();
        betShop.sendKeys(arg);
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Cashdesk dropdown field")
    public void selectFromCashdeskDropdownField(String arg) {
        cashdesk.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Bet Number field")
    public void selectFromBetNumberDropdownField(String arg) {
        betNumber.scrollTo();
        betNumber.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Barcode field")
    public void typeInBarcodeField(String arg) {
        barcode.scrollTo();
        barcode.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Username field")
    public void typeInUsernameField(String arg) {
        username.scrollTo();
        username.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Match Id field")
    public void typeInMatchIdField(String arg) {
        matchId.scrollTo();
        matchId.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in External Id field")
    public void typeInExternalIdField(String arg) {
        externalId.scrollTo();
        externalId.sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Players Connected to a Betshop dropdown field")
    public void selectFromPlayersConnectedToABetshopDropdownField(String arg) {
        playersConnectedToABetshop.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Client Betshop Group dropdown field")
    public void selectFromClientBetshopGroupDropdownField(String arg) {
        clientBetshopGroup.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Client Cashdesk dropdown field")
    public void selectFromClientCashdeskDropdownField(String arg) {
        clientCashdesk.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Stake min field")
    public void typeInStakeMinField(String arg) {
        stakeMin.scrollIntoView(true).sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Stake max field")
    public void typeInStakeMaxField(String arg) {
        stakeMax.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Winning min field")
    public void typeInWinningMinField(String arg) {
        winningMin.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Winning max field")
    public void typeInWinningMaxField(String arg) {
        winningMax.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Price min field")
    public void typeInPriceMinField(String arg) {
        priceMin.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Price max field")
    public void typeInPriceMaxField(String arg) {
        priceMax.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Selection Count min field")
    public void typeInSelectionCountMinField(String arg) {
        selectionCountMin.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in Selection Count max field")
    public void typeInSelectionCountMaxField(String arg) {
        selectionCountMax.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Bonus Type dropdown field")
    public void selectFromBonusTypeDropdownField(String arg) {
        bonusType.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Is Cashdesk Paid dropdown field")
    public void selectFromIsCashdeskPaidDropdownField(String arg) {
        isCashdeskPaid.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Is Player Category dropdown field")
    public void selectFromIsPlayerCategoryDropdownField(String arg) {
        playerCategory.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Is Recalculated dropdown field")
    public void selectFromIsRecalculatedDropdownField(String arg) {
        isRecalculated.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Is Test dropdown field")
    public void selectFromIsTestDropdownField(String arg) {
        isTest.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Is Super Bet dropdown field")
    public void selectFromIsSuperBetDropdownField(String arg) {
        isSuperBet.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("select {string} from Cashdesk Info dropdown field")
    public void selectFromCashdeskInfoDropdownField(String arg) {
        cashdeskInfo.scrollTo().click();
        byOwnText.apply(arg).click();
        splashLoader.shouldBe(disappear);
    }

    @And("type {string} in IP Address max field")
    public void typeInIPAddressMaxField(String arg) {
        ipAddress.scrollTo().sendKeys(arg);
        splashLoader.shouldBe(disappear);
    }

}
