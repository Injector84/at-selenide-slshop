import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест пустой корзины
 */
public class BasketTest extends TestBase {

    @BeforeEach
void login(){
new LoginPage().open().login("customer@test.local", "password");
    }

@Test
@DisplayName("Проверка страницы корзины")
void shouldBeBasket(){
    new BasketPage()
            .open()
            .shouldShowTitleHeader(BasePage.aBasket)
            .shouldShowNavLink(BasePage.aCatalog)
            .shouldShowNavLink(BasePage.aBasket)
            .shouldShowNavLink(BasePage.aLogout);
}

    @Test
    @DisplayName("Проверка пустой корзины")
    void shouldBeEmpty() {
        assertTrue(new BasketPage().open().isEmpty(), "Корзина должна быть пуста");
    }



    @Test
    @DisplayName("Переход в каталог их корзины")
    void shouldMoveToCatalog(){
        new BasketPage()
                .open()
                .openCatalog()
                .shouldShowNavLink(BasePage.aCatalog)
                .shouldShowNavLink(BasePage.aBasket)
                .shouldShowNavLink(BasePage.aLogout);
    }

}