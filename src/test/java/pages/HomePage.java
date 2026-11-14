package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

/**
 * Реализация pages.ProductListPage для главной страницы.
 * Карточки рекомендаций — те же, что и в каталоге, но их всего 5,
 * и все в зоне видимости после загрузки.
 */
public class HomePage extends BasePage implements ProductListPage {

    @Override
    @Step("Открыть главную страницу")
    public void open() {
        super.open("/index.php");
    }

    @Override
    @Step("Проверить, что список товаров на главной пуст")
    public boolean isEmpty() {
        return $$x("//div[contains(@class,'product-card')]").isEmpty();
    }

    @Override
    @Step("Открыть первый товар с главной страницы")
    public ProductPage openFirstProduct() {
        $x("(//div[contains(@class,'product-card')]//h3/a)[1]").click();
        return new ProductPage();
    }
}