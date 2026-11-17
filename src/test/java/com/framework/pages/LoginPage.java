package com.framework.pages;

import com.microsoft.playwright.Page;
public class LoginPage extends BasePage  {
    public LoginPage(Page page) {
        super(page);
    }

    public void enterUsername(String username) {
        page.locator("#user-name").fill(username);
    }

    public void enterPassword(String password) {
        page.locator("#password").fill(password);
    }

    public void clickLogin() {
        page.locator("#login-button").click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
