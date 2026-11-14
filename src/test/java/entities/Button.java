package entities;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Button {
    private static final String selButton = "button";


    public static void buttonclick(String selButton, String sButton) {
        $$(selButton).findBy(Condition.text(sButton)).shouldBe(visible).scrollIntoView(false).click();
    }

    public static void buttonclick(String sButton) {
        buttonclick(selButton, sButton);
    }

}