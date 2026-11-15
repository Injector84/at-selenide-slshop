package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasketPage extends BasePage {

    private final String labelProduct = "Товар";
    private final String labelPrice = "Цена";
    private final String labelQuantity = "Кол-во";
    private final String labelSum = "Сумма";


    @Step("Открыть страницу корзины")
    public BasketPage open() {
        super.open("/cart.php");
        return this;
    }

    @Step("Проверить, что корзина пуста")
    public boolean isEmpty() {
        return $x("//div[contains(@class,'empty-state')]").isDisplayed();
    }

    @Step("Вернуться в каталог")
            public CatalogPage openCatalog() {
        $x("//a").shouldBe(visible).click();
        return new CatalogPage();
    }

    @Step("Открыть первый товар из корзины")
    public ProductPage openFirstProduct() {
        $$x("//tbody/tr[1]/td[count(//th[normalize-space()='Товар']/preceding-sibling::th)+1]")
                .first()
                .scrollIntoView(true)
                .click();
        return new ProductPage();
    }


}
