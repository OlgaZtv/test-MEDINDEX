package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MedindexTests extends TestBase {
    @Test
    @Description("Test for Medindex")
    @DisplayName("Form for applicants is in the page")
    void formforapplicantsTest() {
        step("Open \"https://medindex.ru/\"", () ->
                open("https://medindex.ru/"));

        step("Should have form for applicants", () ->
             $(By.className("container")).shouldBe(visible));
    }

    @Test
    @Description("Test for Medindex")
    @DisplayName("Page is switches to English")
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

    @Test
    @Description("Test for Medindex")
    @DisplayName("Vacancies for applicants is in the page")
    void vacanciesforapplicantsTest() {
        step("Open \"https://medindex.ru/\"", () ->
                open("https://medindex.ru/"));

        step("Should have form vacancies", () ->
                $(By.className("vacancy-accordion")).shouldBe(visible));
    }

    @Test
    @Description("Page title Medindex should have header text")
    @DisplayName("Page title Medindex should have header text")
    void titleTest() {
        step("Open url 'https://medindex.ru/'", () ->
            open("https://medindex.ru/"));

        step("Page title should have text 'Мединдекс: ИТ решения для медицины'", () -> {
            String expectedTitle = "Мединдекс: ИТ решения для медицины";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console log should not have errors")
    @DisplayName("Page console log should not have errors")
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
