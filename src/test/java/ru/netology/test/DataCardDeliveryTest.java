package ru.netology.test;

import com.codeborne.selenide.Selectors;
import ru.netology.data.DataGenerator;
import ru.netology.data.RegistrationByCardInfo;
import ru.netology.data.DataGenerator.Registration;


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
        $("[data-test-id = 'city'] input")
                .setValue(DataGenerator.generateCity());
        $("[placeholder = 'Дата встречи']")
                .doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input")
                .setValue(DataGenerator.calendarDate());
        $("[data-test-id = 'name'] input").
                setValue(DataGenerator.Registration.generateByCard().getFullName());
        $("[data-test-id = 'phone'] input")
                .setValue(DataGenerator.Registration.generateByCard().getPhoneNumber());
        $("[data-test-id = 'agreement']").click();
        $(withText("Запланировать")).click();
        $("[data-test-id = 'success-notification'] .notification__title")
                .shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id = 'success-notification'] .notification__content")
                .shouldHave(text(DataGenerator.calendarDate()));
        $("[placeholder = 'Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(DataGenerator.calendarDate());
        $(withText("Запланировать")).click();
        $("[data-test-id = 'replan-notification'] .notification__title")
                .shouldBe(visible, Duration.ofSeconds(15));
        $(withText("У вас уже запланирована встреча"));
        $("[class = 'button__text'] ").click();
        $(withText("Встреча успешно")).
                shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id = 'success-notification'] .notification__content")
                .shouldHave(text(DataGenerator.calendarDate()))
                .shouldBe(visible, Duration.ofSeconds(15));
    }
}