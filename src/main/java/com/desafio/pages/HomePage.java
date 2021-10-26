package com.desafio.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;


public class HomePage  {
    private WebDriver driver;
    protected WebElement waitElement(WebElement webElement, int timeOutInSeconds) {
        @SuppressWarnings("deprecation")
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }
    protected void moveToElement(WebElement element) {
       Actions action = new Actions(driver);
       action.moveToElement(element).build().perform();
    }



    public HomePage(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
    }

    public void accessWebsite(String url){
        driver.get(url);

    }

    public void searchProduct(String productName){
        driver.findElement(By.cssSelector("#search_query_top")).click();
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(productName);
        driver.findElement(By.cssSelector("#searchbox > button")).click();
    }
    public void addTheProductToTheCart(String productName){
        WebElement nomeProdutoTela = driver.findElement(By.xpath(".//*[@itemprop='name']/*[contains(text(), '" + productName + "')] | .//*[@itemprop='name'][text()='" + productName + "']"));
        moveToElement(nomeProdutoTela);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
        WebElement element = driver.findElement(By.cssSelector("[title='Proceed to checkout']"));
        waitElement(element,10).click();

    }

    public void accessTheCheckout(){
        driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
    }
    public void logIn(){
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("juliobdddio@digitailinnovation.one");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("password");
        driver.findElement(By.cssSelector("#SubmitLogin")).click();

    }
    public void confirmTheShippingAddress() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.name("processCarrier")).click();
    }
    public void paymentIsConfirmed() {
        driver.findElement(By.className("cheque")).click();
        driver.findElement(By.cssSelector("#cart_navigation > button")).click();

    }
    public void messageShouldBeDisplayed(String message) throws Exception {
        String text = driver.findElement(By.cssSelector("#center_column > p.alert.alert-success")).getText();
        if (!text.equals(message)) throw new Exception("Message not valid");
    }
}







