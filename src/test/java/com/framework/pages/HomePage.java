package com.framework.pages;

import com.microsoft.playwright.Page;
public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public String getHeader() {
        return page.locator(".title").innerText();
    }

    public boolean isInventoryDisplayed() {
        return page.locator(".inventory_list").isVisible();
    }

}
