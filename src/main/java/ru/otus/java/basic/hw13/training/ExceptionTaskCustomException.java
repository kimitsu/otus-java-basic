package ru.otus.java.basic.hw13.training;
public class ExceptionTaskCustomException {
    public static int simpleAbs(int left, int right) throws CustomException {
        if (left < right) {
            throw new CustomException("my custom exception");
        }
        return left - right;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("No exception: " + simpleAbs(3, 2));
        try {
            System.out.println("Exception: " + simpleAbs(1, 2));
            System.out.println("Исключение не брошено, ошибка!");
        } catch (CustomException e) {
            System.out.println("Успешно брошено исключение.");
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}