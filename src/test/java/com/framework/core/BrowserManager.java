package com.framework.core;
import com.microsoft.playwright.*;
public class BrowserManager {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public void initialize() {

        playwright = PlaywrightFactory.createPlaywright();

        browser = PlaywrightFactory.createBrowser(playwright);

        context = browser.newContext();

        page = context.newPage();
    }

    public Page getPage() {
        return page;
    }

    public void close() {

        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
