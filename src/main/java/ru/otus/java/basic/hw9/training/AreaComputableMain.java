package ru.otus.java.basic.hw9.training;

public class AreaComputableMain {

    public static void main(String[] args) {
        System.out.println("Площадь квадрата со сторонами 2 и 4 = " + new Square(2, 4).computeArea());
    }
}

interface AreaComputable {
    int computeArea();
}

class Square implements AreaComputable {
    private final double width;
    private final double height;

    public Square(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int computeArea() {
        return (int) Math.round(width * height);
    }
}

class Circle implements AreaComputable {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public int computeArea() {
        return (int) Math.round(Math.PI * radius * radius);
    }
}