package ru.netology.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.github.javafaker.service.RandomService;
import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String calendarDate() {
        LocalDate date = LocalDate.now();
        LocalDate newDate = date.plusDays(3);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return newDate.format(dateFormatter);
    }

    public static String generateCity() {
        String[] listCities = {"Воронеж", "Белгород", "Екатеринбург", "Иркутск", "Новосибирск"};
        int randomCity = new RandomService().nextInt(listCities.length);
        return listCities[randomCity];
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationByCardInfo generateByCard() {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationByCardInfo(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );

        }

    }


}
