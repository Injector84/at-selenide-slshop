package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Page Object страницы входа.
 *
 * Интерфейс здесь намеренно НЕ вводится: страница одна, вторая реализация
 * не предвидится. Это тоже часть демонстрации — интерфейс оправдан там,
 * где есть реальная развилка, а не везде, где есть класс.
 */
public class LoginPage extends BasePage {

    private final SelenideElement emailInput    = $x("//input[@name='email']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement submitButton  = $x("//button[@type='submit']");
    private final SelenideElement alert  = $x("//*[contains(@class,'alert-success')]");

    @Step("Открыть страницу входа")
    public LoginPage open() {
        super.open("/login.php");
        return this;
    }

    @Step("Войти под учётной записью покупателя")
    public HomePage login(String email, String password, boolean bFirst) {
        if(bFirst) alert.shouldBe(Condition.visible);
        emailInput.shouldBe(Condition.visible).setValue(email);
        passwordInput.setValue(password);
        submitButton.click();
        return new HomePage();
    }

    public HomePage login(String email, String password){
        return login(email, password, false);
    }

}