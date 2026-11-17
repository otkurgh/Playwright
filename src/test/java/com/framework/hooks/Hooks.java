package com.framework.hooks;

import com.framework.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }
    @Before
    public void setUp() {
        context.getBrowserManager().initialize();
    }

    @After
    public void tearDown() {
        context.getBrowserManager().close();
    }
}
