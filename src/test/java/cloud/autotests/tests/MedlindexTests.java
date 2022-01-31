package cloud.autotests.tests;

import annotations.Layer;
import annotations.Microservice;
import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("web")
@Owner("zatulivetrova")
@Story("MedIndex")
@Feature("Main page common")
@Tags({@Tag("all_tests"), @Tag("main_page")})

public class MedlindexTests extends TestBase {
    @Microservice("Main page")
    @Test
    @AllureId("1734")
    @DisplayName("Main page should have form for applicants")
    @Feature("Form for applicants")
    @Description("Test for Medindex")
    void formforapplicantsTest() {
        step("Open \"https://medindex.ru/\"", () ->
                open("https://medindex.ru/"));

        step("Should have form for applicants", () ->
             $(By.className("container")).shouldBe(visible));
    }
    @Microservice("English main page")
    @Test
    @AllureId("1734")
    @DisplayName("Check the page is switches to English")
    @Feature("Switch to English")
    @Description("Test for Medindex")
    void pageisswitchesTest() {
        step("Open \"https://medindex.ru/\"", () ->
                open("https://medindex.ru/"));

        step("Page is switches to English", () ->
                $(By.linkText("Eng")).click());

        step("Page title should have text 'Medindex: Healthcare IT solutions'", () -> {
            String expectedTitle = "Medindex: Healthcare IT solutions";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Microservice("Main page")
    @Test
    @AllureId("1734")
    @DisplayName("Main page should have form vacancies")
    @Feature("Vacancies form")
    @Description("Test for Medindex")
    void vacanciesforapplicantsTest() {
        step("Open \"https://medindex.ru/\"", () ->
                open("https://medindex.ru/"));

        step("Should have form vacancies", () ->
                $(By.className("vacancy-accordion")).shouldBe(visible));
    }

    @Microservice("Header")
    @Test
    @AllureId("1734")
    @DisplayName("Check headers text")
    @Feature("Header")
    @Description("Page title Medindex should have header text")
    void titleTest() {
        step("Open url 'https://medindex.ru/'", () ->
            open("https://medindex.ru/"));

        step("Page title should have text 'Мединдекс: ИТ решения для медицины'", () -> {
            String expectedTitle = "Мединдекс: ИТ решения для медицины";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Microservice("Main page errors")
    @Test
    @AllureId("1734")
    @DisplayName("Page console log should not have errors")
    @Feature("Console log")
    @Description("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://medindex.ru/'", () ->
            open("https://medindex.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
