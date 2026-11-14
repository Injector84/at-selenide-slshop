package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Page Object карточки товара. Возвращается как результат
 * pages.ProductListPage.openFirstProduct().
 */
public class ProductPage extends BasePage {

    @Step("Проверить, что карточка товара открыта")
    public ProductPage shouldBeOpened() {
        $x("//div[contains(@class,'product-detail')]").shouldBe(Condition.visible);
        return this;
    }
}