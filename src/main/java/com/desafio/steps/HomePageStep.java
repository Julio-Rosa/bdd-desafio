package com.desafio.steps;

import com.desafio.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageStep {
    private WebDriver driver;
    HomePage homePage = new HomePage();



    @Given("^That a user accesses the site \"(.*)\"$")
    public void accessWebsite(String url){
       homePage.accessWebsite(url);

    }
    @Given("^Search for product \"(.*)\"$")
    public void searchProduct(String productName){
      homePage.searchProduct(productName);

    }


    @And("Add the product {string} to the cart")
    public void addTheProductToTheCart(String prductName) {
        homePage.addTheProductToTheCart(prductName);

    }

    @And("access the checkout")
    public void accessTheCheckout() {
        homePage.accessTheCheckout();
    }

    @And("log in")
    public void logIn() {
        homePage.logIn();
    }

    @And("Confirm the shipping address")
    public void confirmTheShippingAddress() {
        homePage.confirmTheShippingAddress();
    }

    @When("Payment is confirmed")
    public void paymentIsConfirmed() {
        homePage.paymentIsConfirmed();

    }
    @Then("The message should be displayed {string}")
    public void theMessageShouldBeDisplayed(String message) throws Exception {
        homePage.messageShouldBeDisplayed(message);
    }
}
