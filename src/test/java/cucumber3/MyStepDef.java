package cucumber3;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyStepDef {
    RegistrationPage registrationPage = new RegistrationPage();
    ProductPage productPage = new ProductPage();
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    LogInPage logInPage = new LogInPage();
    VerifyExpectedMessages verifyExpectedMessages = new VerifyExpectedMessages();

    @Given("^User is on home page$")
    public void user_is_on_home_page() {
    }

    @When("^User enters all the details$")
    public void user_enters_all_the_details() {
        registrationPage.toRegister();
    }

    @Then("^User should be register successfully$")
    public void user_should_be_register_successfully() {
        verifyExpectedMessages.verifyRegistrationMessage();
    }

    @Given("^User is already registered$")
    public void user_is_already_registered() {
        registrationPage.toRegister();
    }

    @When("^User send an email to friend with product$")
    public void user_send_an_email_to_friend_with_product() {
        productPage.toSendEmailWithProduct();
    }

    @Then("^An email should be send to friend$")
    public void an_email_should_be_send_to_friend() {
        verifyExpectedMessages.verifyEmailSentMessage();
    }

    @Then("^An email should not be send to friend$")
    public void an_email_should_not_be_send_to_friend() {
        verifyExpectedMessages.verifyEmailNotSentMessage();
    }

    @Given("^User is on product page$")
    public void user_is_on_product_page() {
        homePage.clickOnNotbooks();
    }

    @When("^User sort price by high to low$")
    public void user_sort_price_by_high_to_low() {
        productPage.productSortByHighToLow();
    }

    @Then("^All product should be sorted by price displaying high to low$")
    public void all_product_should_be_sorted_by_price_displaying_high_to_low() {
        verifyExpectedMessages.verifyPriceHighToLow();
    }

    @Given("^User is already logged in$")
    public void user_is_already_logged_in() {
        logInPage.toLogIn();
    }

    @When("^User purchase a product$")
    public void user_purchase_a_product() {
        productPage.addFirstComputerProductToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage.acceptTermsAndConditions();
        shoppingCartPage.clickOnCheckOut();
        checkOutPage.toPurchase();
    }

    @Then("^Order successful message should be displayed$")
    public void order_successful_message_should_be_displayed() {
        verifyExpectedMessages.verifyOrderSuccessfulMessage();
    }

    @Given("^User has added a  product  in shopping cart$")
    public void user_has_added_a_product_in_shopping_cart() {
        productPage.addFirstComputerProductToCart();
    }

    @When("^User try to purchase a product without agreeing terms and condtion$")
    public void user_try_to_purchase_a_product_without_agreeing_terms_and_condtion() {
        homePage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckOut();
    }

    @Then("^User should not be able to proceed$")
    public void user_should_not_be_able_to_proceed() {
        verifyExpectedMessages.verifyTermsAndConditionMessage();
    }

    @When("^User scroll to view products on homepage$")
    public void user_scroll_to_view_products_on_homepage() {
    }

    @Then("^Add to cart button should be present for all products$")
    public void add_to_cart_button_should_be_present_for_all_products() {
        List<String> priceTexts = homePage.findAddToCartButton();
        for (String priceText : priceTexts) {
            Assert.assertTrue(priceText.contains("Add to cart"));
        }
    }

    @Given("^User is on jewelry page$")
    public void user_is_on_jewelry_page()
    {
        homePage.clickOnJewelry();
    }

    @When("^User select currency as dollar$")
    public void user_select_currency_as_dollar()
    {
    }

    @Then("^Price should be displayed in dollar currency$")
    public void price_should_be_displayed_in_dollar_currency()
    {
        List<String> priceTexts = homePage.changeCurrencyToDollar();
        for (String priceText: priceTexts)
        {
            Assert.assertTrue(priceText.contains("$"));
        }
    }

    @When("^User select currency as euro$")
    public void user_select_currency_as_euro()
    {
    }

    @Then("^Price should be displayed in euro currency$")
    public void price_should_be_displayed_in_euro_currency()
    {
        List<String> priceTexts = homePage.changeCurrencyToEuro();
        for (String priceText: priceTexts)
        {
            Assert.assertTrue(priceText.contains("Ђ"));
        }
    }
}
