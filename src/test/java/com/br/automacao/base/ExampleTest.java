package com.br.automacao.base;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ExampleTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
//        open("https://www.google.com");
        $("[name='q']").setValue("Selenide").pressEnter();
    }
}
