import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.BasePage;
import pages.RegPage;

/**
 * Демонстрация BasePage.
 * <p>
 * Тест вызывает два метода login() и register — и дальше три метода подряд,
 * унаследованных от BasePage: shouldBeLoggedInAs, shouldShowNavLink,
 * shouldHaveFooter. В отчёте Allure это три отдельных @Step-шага.
 */
public class RegisterTest extends TestBase {

    @DisplayName("Покупатель регистрируется через форму регистрации, входит и видит шапку и подвал")
    @ParameterizedTest(name = "{displayName}: {0}")
    @CsvFileSource(resources = "register.csv", numLinesToSkip = 1)
    void shouldRegisterAsCustomer(String email, String name, String password) {
        new RegPage()
                .open()
                .register(email, name, password)
                .login(email, password)
                .shouldBeLoggedInAs(name)
                .shouldShowNavLink(BasePage.aCatalog)
                .shouldShowNavLink(BasePage.aBasket)
                .shouldShowNavLink(BasePage.aLogout)
                .shouldHaveFooter();
    }
}