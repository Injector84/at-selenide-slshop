package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.Button;
import entities.Field;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Page Object страницы регистрации.
 */
public class RegPage extends BasePage {

    private final String labelEmail = "Email";
    private final String labelName = "Имя";
    private final String labelPassword = "Пароль";
    private final String labelCode = "Код";
    private final String registerButton = "Зарегистрироваться";
    private final String confirmButton = "Подтвердить";
    private final String codeLinkText = "служебной странице кодов";


    @Step("Открыть страницу регистрации покупателя")
    public RegPage open() {
        super.open("/register.php");
        return this;
    }

    @Step("Ввод и отправка данных для регистрации покупателя")
    public LoginPage register(String sEmail, String sName, String sPassword) {
        Field.setFieldValue(labelEmail, sEmail);
        Field.setFieldValue(labelName, sName);
        Field.setFieldValue(labelPassword, sPassword);
        Button.buttonclick(registerButton);
        this.confirmCode(this.codePageClick().getCode(sEmail,true));
        return new LoginPage();
    }

    @Step("Кликнуть по ссылке на служебную страницу кодов")
    public CodePage codePageClick(){
        $(By.partialLinkText(codeLinkText)).click();
        return new CodePage();
    }

    @Step("Ввод и подтверждение кода")
    public void confirmCode(String sCode)
    {
        Field.setFieldValue(labelCode,sCode);
        Button.buttonclick(confirmButton);
    }
}