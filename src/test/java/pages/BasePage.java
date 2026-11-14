package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Базовый Page Object: только то, что есть на каждой странице.
 * Шапка, подвал, приветствие пользователя, счётчик корзины, навигация.
 * <p>
 * Наследование здесь оправдано: эти элементы присутствуют на всех
 * страницах с одинаковыми локаторами. Без BasePage один и тот же XPath
 * пришлось бы дублировать в каждом Page Object.
 * <p>
 * Интерфейсы (например, pages.ProductListPage) и BasePage — не конкуренты,
 * а разные механизмы. Наследование даёт общую реализацию того, что есть
 * везде. Интерфейс даёт общий контракт того, что есть у нескольких страниц.
 */
public abstract class BasePage {

    protected final SelenideElement siteHeader = $x("//header[contains(@class,'site-header')]");
    protected final SelenideElement siteFooter = $x("//footer[contains(@class,'site-footer')]");
    protected final SelenideElement userGreeting = $x("//span[contains(@class,'user-greeting')]");
    protected final SelenideElement cartBadge = $x("//span[contains(@class,'badge')]");
    protected final SelenideElement nav = $x("//nav[contains(@class,'nav')]");
    public static final String Catalog = "Каталог";
    public static final String Basket = "Корзина";
    public static final String Login = "Войти";
    public static final String Registration = "Регистрация";

    /**
     * Открыть страницу по относительному пути от baseUrl.
     * Ждём появления шапки — она есть везде, поэтому это надёжный
     * признак, что страница загрузилась.
     */
    protected void open(String path) {
        Selenide.open(path);
        siteHeader.shouldBe(Condition.visible);
    }

    @Step("Проверить, что в шапке отображается имя пользователя")
    public BasePage shouldBeLoggedInAs(String name) {
        userGreeting.shouldBe(Condition.visible).shouldHave(Condition.text(name));
        return this;
    }

    @Step("Проверить наличие ссылки в навигации")
    public BasePage shouldShowNavLink(String text) {
        nav.$$x(".//a").find(Condition.text(text)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить счётчик корзины")
    public BasePage shouldShowCartBadge(int count) {
        cartBadge.shouldBe(Condition.visible).shouldHave(Condition.text(String.valueOf(count)));
        return this;
    }

    @Step("Проверить, что подвал отображается")
    public BasePage shouldHaveFooter() {
        siteFooter.shouldBe(Condition.visible);
        return this;
    }
}