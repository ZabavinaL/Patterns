package ru.netology.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {

    public static String calendarDate() {
        LocalDate date = LocalDate.now();
        LocalDate newDate = date.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return newDate.format(dateFormatter);
    }

    public static String fullName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String phoneNumber() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }
}
