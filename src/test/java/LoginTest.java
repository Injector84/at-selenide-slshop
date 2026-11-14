import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

/**
 * Демонстрация BasePage.
 *
 * Тест вызывает один метод login() — и дальше три метода подряд,
 * унаследованных от BasePage: shouldBeLoggedInAs, shouldShowNavLink,
 * shouldHaveFooter. В отчёте Allure это три отдельных @Step-шага.
 */
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Покупатель входит через форму логина и видит шапку и подвал")
    void shouldLoginAsCustomer() {
        new LoginPage()
            .open()
            .login("customer@test.local", "password")
            .shouldBeLoggedInAs("Тестовый покупатель")
            .shouldShowNavLink("Каталог")
            .shouldHaveFooter();
    }
}