package com.br.automacao.base;

import com.br.automacao.config.BrowserConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        BrowserConfig.setup();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserConfig.teardown();
    }
}
