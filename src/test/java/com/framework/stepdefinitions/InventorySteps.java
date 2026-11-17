package com.framework.stepdefinitions;


import com.framework.pages.InventoryPage;
import com.framework.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class InventorySteps {
    private final TestContext context;
    private InventoryPage inventoryPage;

    public InventorySteps(TestContext context) {
        this.context = context;
    }

    @Given("user is on the inventory page")
    public void userIsOnInventoryPage() {

        inventoryPage = context.getInventoryPage();

        assertTrue(
                context.getPage().url().contains("inventory"),
                "User is not on the inventory page"
        );
    }

    @When("user retrieves the inventory list")
    public void retrieveInventoryList() {

        int count = inventoryPage.getInventoryCount();

        System.out.println("Inventory count: " + count);
    }

    @Then("the inventory list should contain {int} items")
    public void verifyInventoryCount(int expectedCount) {

        assertEquals(
                expectedCount,
                inventoryPage.getInventoryCount()
        );
    }

    @When("user sorts inventory by price from high to low")
    public void sortInventoryByPriceDescending() {

        inventoryPage.sortByPriceDescending();
    }

    @Then("inventory items should be displayed in descending price order")
    public void verifyPricesDescending() {

        List<Double> prices = inventoryPage.getItemPrices();

        System.out.println("Prices: " + prices);

        for (int i = 0; i < prices.size() - 1; i++) {

            assertTrue(
                    prices.get(i) >= prices.get(i + 1),
                    "Inventory prices are not in descending order"
            );
        }
    }


}
