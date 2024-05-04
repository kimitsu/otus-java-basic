package ru.otus.java.basic.hw4;

import java.util.Calendar;
import java.util.OptionalInt;

public class User {
    private String lastName, firstName, middleName;
    private int birthYear;
    private String email;

    /**
     * Конструктор пользователя
     * @param _lastName   фамилия
     * @param _firstName  имя
     * @param _middleName отчество
     * @param _birthYear  год рождения
     * @param _email      адрес электронной почты
     */
    public User(String _lastName, String _firstName, String _middleName, int _birthYear, String _email) {
        lastName = _lastName;
        firstName = _firstName;
        middleName = _middleName;
        birthYear = _birthYear;
        email = _email;
    }

    /**
     * Печатает информацию о пользователе в консоль
     */
    public void print() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("E-Mail: " + email);
    }

    /**
     * Возвращает примерный пользователя возраст в годах (без учета месяца и дня рождения),
     * или ничего, если пользователь еще не родился.
     * @return возраст (лет)
     */
    public OptionalInt getAgeYears() {
        Calendar calendar = Calendar.getInstance();
        int age = calendar.get(Calendar.YEAR) - birthYear;
        return age >= 0 ? OptionalInt.of(age) : OptionalInt.empty();
    }
}
