package entities;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class Field {

    private static final String Email = "Email";
    private static final String Password = "Пароль";
    private static final String selFieldLabel = "label";
    private static final String selField = "input";


    public static void setFieldValue(String selFieldLabel, String selField, String sFieldName, String sValue) {
        $$(selFieldLabel)
                .findBy(Condition.text(sFieldName))
                .shouldBe(visible)
                .scrollIntoView(false)
                .parent()
                .$(selField)
                .setValue(sValue);
    }

    public static void setFieldValue(String sFieldName, String sValue) {
        setFieldValue(selFieldLabel, selField, sFieldName, sValue);
    }

    public static String getFieldValue(String selFieldLabel, String selField, String sFieldName) {
        return $$(selFieldLabel)
                .findBy(Condition.text(sFieldName))
                .shouldBe(visible)
                .scrollIntoView(false)
                .parent()
                .$(selField)
                .getValue();
    }

    public static String getFieldValue(String sFieldName) {
        return getFieldValue(selFieldLabel, selField,sFieldName);
    }

    public static String getFieldText(String selFieldLabel, String selField, String sFieldName) {
        return $$(selFieldLabel)
                .findBy(Condition.text(sFieldName))
                .shouldBe(visible)
                .scrollIntoView(false)
                .parent()
                .$(selField)
                .getText();
    }

    public static String getFieldText(String sFieldName) {
        return getFieldText(selFieldLabel, selField, sFieldName);
    }
}