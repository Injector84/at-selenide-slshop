import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * Общая настройка тестов:
 * — Allure-листенер Selenide автоматически прикладывает скриншоты
 *   и HTML-страницы к упавшим тестам (без единой @Step-аннотации);
 * — после каждого теста браузер закрывается, состояние логина
 *   не протекает между тестами.
 *
 * Configuration.headless, browser, разрешение окна не задаются —
 * используются значения Selenide по умолчанию. При необходимости
 * переопределяются флагом запуска: -Dselenide.headless=true.
 */
public abstract class TestBase {

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://slqa.ru/demo/slshop/v02";
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
}