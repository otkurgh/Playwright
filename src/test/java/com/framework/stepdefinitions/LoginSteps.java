package com.framework.stepdefinitions;

import com.framework.utils.ConfigReader;
import com.framework.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
public class LoginSteps {

    private final TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {

        String url = ConfigReader.getProperty("baseUrl");

        context.getLoginPage().navigate(url);
    }

    @When("the user enters valid credentials")
    public void enterValidCredentials() {

        String username =
                ConfigReader.getProperty("username");

        String password =
                ConfigReader.getProperty("password");

        context.getLoginPage().enterUsername(username);
        context.getLoginPage().enterPassword(password);
    }

    @When("clicks the login button")
    public void clickLoginButton() {

        context.getLoginPage().clickLogin();
    }

    @Then("the user should see the home page")
    public void verifyHomePage() {

        String actualHeader =
                context.getHomePage().getHeader();
        System.out.println("Actual Header of the page is:"+ actualHeader);

        Assertions.assertEquals(
                "Products",
                actualHeader,
                "Home page header does not match"
        );

        Assertions.assertTrue(
                context.getHomePage().isInventoryDisplayed(),
                "Inventory list is not displayed"
        );


    }

}
