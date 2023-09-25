package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//class for browser actions to use in different pages
public class BrowserActions {

    WebDriver driver;

    //initialize browser driver
    public void initBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //open site url
    public void openSite(String siteUrl) {
        driver.navigate().to(siteUrl);
    }

    //return element
    public WebElement allocateElement(By e){
        return driver.findElement(e);
    }

    //return list of elements
    public List<WebElement> allocateElements(By e){
        return driver.findElements(e);
    }

    //input text in textBox and submit it
    public void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        element.submit();
    }

    //return alert box text and accept it
    public String checkAlertMsg() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    //check that element is visible to user
    public boolean checkElementVisabilty(WebElement e) {
        return e.isDisplayed();
    }

    //back to previous page
    public void backSite(){driver.navigate().back();}

    //close site
    public void closeSite() {
        driver.quit();
    }
}
