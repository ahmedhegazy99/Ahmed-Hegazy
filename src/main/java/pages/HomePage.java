package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.BrowserActions;

import java.util.List;

public class HomePage {

    BrowserActions browserActions;

    //initialize browser driver
    public HomePage () {
        browserActions = new BrowserActions();
        browserActions.initBrowser();
    }

    //open site url
    public void getLink(String link) {
        browserActions.openSite(link);
    }

    //return element
    public WebElement getElement(By element) {
       return browserActions.allocateElement(element);
    }

    //return list of elements
    public List<WebElement> getElements(By element) {
        return browserActions.allocateElements(element);
    }

    //input text in textBox and submit it
    public void submitText(WebElement element, String text) {
        browserActions.sendText(element,text);
    }

    //return alert box text and accept it
    public String getAlertMsg() {
        return browserActions.checkAlertMsg();
    }

    //check that element is visible to user
    public boolean isElementVisible(WebElement element) {
        return browserActions.checkElementVisabilty(element);
    }

    //back to previous page
    public void back(){browserActions.backSite();}
    //close site
    public void closeSite() {
        browserActions.closeSite();
    }
}
