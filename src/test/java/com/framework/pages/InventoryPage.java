package com.framework.pages;

import com.microsoft.playwright.*;
import java.util.List;
import java.util.ArrayList;

public class InventoryPage extends BasePage {

    private final Locator inventoryItems;
    private final Locator sortDropdown;
    private final Locator itemPrices;

    public InventoryPage(Page page) {
        super(page);

        inventoryItems = page.locator(".inventory_item");
        sortDropdown = page.locator(".product_sort_container");
        itemPrices = page.locator(".inventory_item_price");
    }

    // Get inventory list size
    public int getInventoryCount() {
        return inventoryItems.count();
    }

    // Sort by price descending
    public void sortByPriceDescending() {
        sortDropdown.selectOption("hilo");
    }

    // Get prices after sorting
    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<>();

        for (String price : itemPrices.allTextContents()) {
            prices.add(Double.parseDouble(price.replace("$", "")));
        }

        return prices;
    }

}
