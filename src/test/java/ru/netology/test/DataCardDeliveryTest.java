package ru.netology.test;

import com.codeborne.selenide.Selectors;
import ru.netology.data.DataGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DataCardDeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://0.0.0.0:7777");
    }

    @Test
    void shouldCorrectValues() {
        $("[data-test-id = 'city'] input").setValue("Воронеж");
        $("[placeholder = 'Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(DataGenerator.calendarDate());
        $("[data-test-id = 'name'] input").setValue(DataGenerator.fullName());
        $("[data-test-id = 'phone'] input").setValue(DataGenerator.phoneNumber());
        $("[data-test-id = 'agreement']").click();
        $(withText("Запланировать")).click();
        $("[data-test-id = 'success-notification'] .notification__title")
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[placeholder = 'Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(DataGenerator.calendarDate());
        $(withText("Запланировать")).click();
        $("[data-test-id = 'replan-notification'] .notification__title")
                .shouldBe(visible, Duration.ofSeconds(15));
        $(withText("У вас уже запланирована встреча"));
        $("[class = 'button__text'] ").click();
        $(withText("Встреча успешно")).
                shouldBe(visible, Duration.ofSeconds(15));
    }
}