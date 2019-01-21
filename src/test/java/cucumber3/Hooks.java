package cucumber3;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();


    @Before
    public void setUp()
    {
        browserSelector.browser();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
