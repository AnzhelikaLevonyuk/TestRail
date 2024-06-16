package utils;

import com.github.javafaker.Faker;

public class TestDataGeneration {
    static Faker faker = new Faker();

    public static String generateTitleForProject() {
        return faker.country().name() + faker.number().randomDigit();
    }

    public static String generateTitleForMilestone() {
        return faker.animal().name() + faker.number().randomDigit();
    }

    public static String generateTitleForTestCase() {
        return faker.color().name() + faker.number().randomDigit();
    }
}
