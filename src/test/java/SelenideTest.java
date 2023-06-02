import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    void shouldTest() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(0).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $$("div[class='notification__title']").get(0).should(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Успешно"));

//        $("[placeholder='0000 0000 0000 0000']").setValue("4444 4444 4444 4441");
//        $("[placeholder='08']").setValue("12");
//        $("[placeholder='22']").setValue("24");
//        $$("[class='input__control']").get(3).setValue("DAN LYUT");
//        $("[placeholder='999']").setValue("123");
    }
    //Прошел

    @Test
    void shouldTest2() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(0).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4442");
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $$("div[class='notification__title']").get(1).should(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Ошибка"));
    }
    //Идет в issues, так как notification__title Успешно, хотя для данного набора карт (4444 4444 4444 4442) должно быть declined- Ошибка.
    //Хотя в ответах на запросы всё-таки стоит declined, следовательно этто всего лишь визуальных баг

    @Test
    void shouldTest3() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(0).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");
        inputs.get(1).setValue("13");                                                   //не существующий месяц
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $("[class='input__sub']").should(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Неверно указан срок действия карты"));

    }
    //Прошел

    @Test
    void shouldTest4() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(0).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("22");                                                   //прошедший год
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $("[class='input__sub']").should(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Истёк срок действия карты"));

    }
    //Прошел

    @Test
    void shouldTest5() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(0).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("ДАН ЛЮТ");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $("[class='input__sub']").should(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Истёк срок действия карты"));

    }
    //ПОКА НЕ ПРИДУМАЛ КАКА РЕАЛИЗОВАТЬ, ВЛАДЕЛЕЦ НЕ МОЖЕТ БЫТЬ НАПИСАН КИРИЛЛИЦЕЙ

    @Test
    void shouldTest6() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(1).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");                                          //approved
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $$("div[class='notification__title']").get(0).should(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Успешно"));

    }
    //Прошел

    @Test
    void shouldTest7() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(1).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4442");                                          //declined
        inputs.get(1).setValue("12");
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $$("div[class='notification__title']").get(0).should(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Ошибка"));
    }
    //Идет в issues также как в первом случае в разделе Купить

    @Test
    void shouldTest8() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $$("[class='button__text']").get(1).click();
        var inputs = $$("[class='input__control']");
        inputs.get(0).setValue("4444 4444 4444 4441");
        inputs.get(1).setValue("00");                                               //не существующий месяц
        inputs.get(2).setValue("24");
        inputs.get(3).setValue("DAN LYUT");
        inputs.get(4).setValue("123");
        $$("[class='button__text']").get(2).click();
        $("[class='input__sub']").should(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Неверно указан срок действия карты"));

    }
    //Идет в issues, операция проходит с нулевым месяцем
}
