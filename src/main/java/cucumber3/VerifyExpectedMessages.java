package cucumber3;

import org.openqa.selenium.By;
import org.junit.Assert;

public class VerifyExpectedMessages extends Utils
{
    ProductPage productPage = new ProductPage();

    private final static String expectedRegisterMessage = "Your registration completed";
    private final static String expectedEmailSentMessage = "Your message has been sent.";
    private final static String expectedEmailNotSentMessage = "Only registered customers can use email a friend feature";
    private final static String expectedOrderSuccessfulMessage = "Your order has been successfully processed!";
    private final static String expectedTermsAndConditionsMessage = "Please accept the terms of service before the next step.";

    public void verifyRegistrationMessage()
    {
        String actualRegisterMessage = getText(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Test case scenario user should be able to register successfully is failed",expectedRegisterMessage,actualRegisterMessage);
    }
    public void verifyEmailSentMessage()
    {
        String actualEmailSentMessage = getText(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Test case scenario registered user should be able to send an email to friend is failed",expectedEmailSentMessage,actualEmailSentMessage);
    }
    public void verifyEmailNotSentMessage()
    {
        String actualEmailNotSentMessage = getText(By.xpath("//li[contains(.,'Only registered customers can use email a friend feature')]\n"));
        Assert.assertEquals("Test case scenario unregistered user should not be able to send an email is failed",expectedEmailNotSentMessage,actualEmailNotSentMessage);
    }
    public void verifyOrderSuccessfulMessage()
    {
        String actualOrderSuccessfullMessage = getText(By.xpath("//strong[contains(.,'Your order has been successfully processed!')]"));
        Assert.assertEquals("Test case scenario to place an order successfully is failed",expectedOrderSuccessfulMessage,actualOrderSuccessfullMessage);
    }
    public void verifyTermsAndConditionMessage()
    {
        String actualTermsAndConditionsMessage = getText(By.xpath("//div[@id='terms-of-service-warning-box']/p"));
        Assert.assertEquals("Test case scenario user should not be able to procced without agreeing to Terms and conditions is failed",expectedTermsAndConditionsMessage,actualTermsAndConditionsMessage);
    }
    public void verifyPriceHighToLow()
    {
        boolean isHighToLow  = productPage.isPriceHighToLow();
        Assert.assertTrue("Price expected high to low but Not", isHighToLow);
    }
}
