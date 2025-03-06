package com.br.automacao.config;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Configuration.remoteConnectionTimeout;
import static com.codeborne.selenide.Configuration.webdriverLogsEnabled;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserConfig {

    private static void configSelenide() {
        Configuration.remote = "http://localhost:4444"; // Configuração para rodar no Selenium Grid
        Configuration.browser = System.getProperty("browser", "firefox"); // Define navegador dinamicamente
        Configuration.browserSize = "1920x1080"; // Definir o tamanho da tela
        Configuration.headless = true;
        webdriverLogsEnabled = true;
        remoteConnectionTimeout = 30000;

    }

    public static void setup() {
        configSelenide();
        clearBrowserCookies();
        WebDriverRunner.getAndCheckWebDriver();
        getWebDriver().manage().window().maximize();
        open("https://www.google.com.br/");
    }

    public static void teardown() {
        clearBrowserCookies();
        closeWebDriver();
    }

}
