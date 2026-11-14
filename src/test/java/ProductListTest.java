import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CatalogPage;
import pages.HomePage;
import pages.ProductListPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Демонстрация интерфейса pages.ProductListPage.
 *
 * Два тестовых метода, по два прогона каждый — итого 4 теста в отчёте Allure.
 * Ни одного if по типу страницы, ни одного switch. Тип параметра — интерфейс,
 * тест не знает, какая реализация под капотом.
 */
public class ProductListTest extends TestBase {

    static Stream<Arguments> productListPages() {
        return Stream.of(
            Arguments.of("Домашняя страница",    new HomePage()),
            Arguments.of("Страница каталога", new CatalogPage())
        );
    }

    @DisplayName("Проверка списка товаров")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("productListPages")
    void shouldShowProducts(String name, ProductListPage page) {
        page.open();
        assertFalse(page.isEmpty(), "Список товаров не должен быть пуст");
    }

    @DisplayName("Открывается первый товар")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("productListPages")
    void pageShouldOpenFirstProduct(String name, ProductListPage page) {
        page.open();
        page.openFirstProduct().shouldBeOpened();
    }


//    @Test
//    @DisplayName("Открывается первый товар: Домашняя страница")
//    void homePageShouldOpenFirstProduct() {
//        HomePage page = new HomePage();
//        page.open();
//        page.openFirstProduct().shouldBeOpened();
//    }
//
//    @Test
//    @DisplayName("Открывается первый товар: Страница каталога")
//    void catalogPageShouldOpenFirstProduct() {
//        CatalogPage page = new CatalogPage();
//        page.open();
//        page.openFirstProduct().shouldBeOpened();
//    }


}