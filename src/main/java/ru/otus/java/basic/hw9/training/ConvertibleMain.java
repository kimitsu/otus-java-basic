package ru.otus.java.basic.hw9.training;

public class ConvertibleMain {
    public static void main(String[] args) {
        System.out.println("100 километров в милях = " + new Mile().parseValue(100));
        System.out.println("0,99 километров в верстах = " + new Verst().parseValue(0.99));
    }
}

interface Convertible {
    double KILOS_IN_MILE = 1.6;
    double KILOS_IN_VERST = 0.95;

    long parseValue(double kilosValue);
}

class Mile implements Convertible {
    @Override
    public long parseValue(double kilosValue) {
        return (long) Math.floor(kilosValue / KILOS_IN_MILE);
    }
}

class Verst implements Convertible {
    @Override
    public long parseValue(double kilosValue) {
        return (long) Math.floor(kilosValue / KILOS_IN_VERST);
    }
}