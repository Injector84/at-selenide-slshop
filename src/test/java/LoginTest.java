import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.BasePage;
import pages.LoginPage;

/**
 * Демонстрация BasePage.
 * <p>
 * Тест вызывает один метод login() — и дальше три метода подряд,
 * унаследованных от BasePage: shouldBeLoggedInAs, shouldShowNavLink,
 * shouldHaveFooter. В отчёте Allure это три отдельных @Step-шага.
 */
public class LoginTest extends TestBase {


    @DisplayName("Покупатель входит через форму логина и видит шапку и подвал")
    @ParameterizedTest(name = "{displayName}: {0}")
    @CsvFileSource(resources = "register.csv", numLinesToSkip = 1)
    void shouldLoginAsCustomer(String email, String name, String password) {
        new LoginPage()
                .open()
                .login(email, password)
                .shouldShowNavLink(BasePage.aCatalog)
                .shouldShowNavLink(BasePage.aBasket)
                .shouldShowNavLink(BasePage.aLogout)
                .shouldHaveFooter();
    }


}