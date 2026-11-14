package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;

public class CodePage {

    private static String selCode = "code";


    @Step("Открыть служебную страницу кодов")
    public CodePage open() {
        Selenide.open("/test-codes.php");
        return this;
    }

    @Step("Получить код")
    public String getCode(String sEmail, boolean bBack) {
        String sCode = $$("td").findBy(Condition.ownText(sEmail))
                .shouldBe(exist)
                .parent()
                .$(selCode)
                .getText();
        if (bBack) Selenide.back();
        return sCode;
    }

    public String getCode(String sEmail){
        return getCode(sEmail,false);
    }

}
