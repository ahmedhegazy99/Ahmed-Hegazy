import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.List;

public class testSearch {

    HomePage homePage;
    String siteUrl = "https://demo.nopcommerce.com/";
    WebElement searchBox;
    String searchText;
    List items;

    SoftAssert softAssert = new SoftAssert();

    //assign browser driver and open site
    @BeforeTest
    public void prepareTest(){
        homePage = new HomePage();
        homePage.getLink(siteUrl);
    }

    //close browser
    @AfterTest
    public void endTest() {
        homePage.closeSite();
    }

    //find search box element
    public void GetElement() {
        searchBox =  homePage.getElement(By.id("small-searchterms"));
    }

    @Test(priority = 1)
    public void validateElementVisability() {
        GetElement();
        boolean isVisible = homePage.isElementVisible(searchBox);
        Assert.assertTrue(isVisible);
    }
    @Test
    public void validateAllElementsReturned(){
        searchText = "lenovo";

        GetElement();
        homePage.submitText(searchBox,searchText);
        items = homePage.getElements(By.className("item-box"));
        softAssert.assertEquals(items.size(),2);
    }

    @Test
    public void validateSpecificElementIsReturned(){
        searchText = "lenovo-ideacentre-600-all-in-one-pc";

        GetElement();
        homePage.submitText(searchBox,searchText);
        items = homePage.getElements(By.className("item-box"));
        softAssert.assertEquals(items.size(),1);
    }

    @Test
    public void validateMultipleTermElementsReturned(){
        searchText = "apple macbook";

        GetElement();
        homePage.submitText(searchBox,searchText);
        items = homePage.getElements(By.className("item-box"));
        softAssert.assertEquals(items.size(),1);
    }

    @Test
    public void validateNoElementsReturned(){
        searchText = "instabug";
        String noResultText;

        GetElement();
        homePage.submitText(searchBox,searchText);
        items = homePage.getElements(By.className("item-box"));
        noResultText = homePage.getElement(By.className("no-result")).getText();

        softAssert.assertEquals(items.size(),0);
        softAssert.assertEquals(noResultText,"No products were found that matched your criteria.");
    }

    @Test
    public void validateEmptySearchBoxAlert(){
        searchText = "";
        String alertMsg;

        GetElement();
        homePage.submitText(searchBox,searchText);
        alertMsg = homePage.getAlertMsg();
        softAssert.assertEquals(alertMsg, "Please enter some search keyword");
    }



}
