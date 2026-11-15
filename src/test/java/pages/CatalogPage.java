package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

/**
 * Реализация pages.ProductListPage для каталога.
 *
 * Контракт тот же, что у HomePage, но реализация чуть отличается:
 * в каталоге товаров больше, и первый может быть вне зоны видимости
 * после загрузки. Поэтому здесь добавлен scrollIntoView перед кликом.
 *
 * Именно такие небольшие различия оправдывают интерфейс: контракт
 * фиксирует «что можно сделать», реализация решает «как именно»,
 * и тест об этих различиях не знает.
 */
public class CatalogPage extends BasePage implements ProductListPage {

    @Override
    @Step("Открыть страницу каталога")
    public void open() {
        super.open("/catalog.php");
    }

    @Override
    @Step("Проверить, что каталог пуст")
    public boolean isEmpty() {
        return $$x("//div[contains(@class,'product-card')]").isEmpty();
    }

    @Override
    @Step("Открыть первый товар из каталога")
    public ProductPage openFirstProduct() {
        $x("(//div[contains(@class,'product-card')]//h3/a)[1]")
            .scrollIntoView(false)
            .click();
        return new ProductPage();
    }
}