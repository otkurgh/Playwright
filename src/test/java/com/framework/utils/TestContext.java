package com.framework.utils;

import com.framework.core.BrowserManager;
import com.framework.pages.InventoryPage;
import com.framework.pages.LoginPage;
import com.framework.pages.HomePage;
import com.microsoft.playwright.Page;

public class TestContext {

    private final BrowserManager browserManager;

    public TestContext(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(browserManager.getPage());
    }

    public HomePage getHomePage() {
        return new HomePage(browserManager.getPage());
    }
    public InventoryPage getInventoryPage() {
        return new InventoryPage(browserManager.getPage());
    }

    public Page getPage() {
        return browserManager.getPage();
    }
    public BrowserManager getBrowserManager() {
        return browserManager;
    }

}
