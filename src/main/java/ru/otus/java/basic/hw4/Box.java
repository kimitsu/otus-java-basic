package ru.otus.java.basic.hw4;

public class Box {
    private final double width, height, depth;
    private String color;
    private boolean isOpen;
    private String contents;

    /**
     * Конструктор коробки
     * @param _color  цвет
     * @param _width  ширина
     * @param _height высота
     * @param _depth  глубина
     */
    public Box(String _color, double _width, double _height, double _depth) {
        color = _color;
        width = _width;
        height = _height;
        depth = _depth;
        contents = null;
        isOpen = false;
    }

    /**
     * Проверяет, открыта ли коробка
     * @return инстина - коробка открыта, ложь - коробка закрыта
     */
    public boolean getIsOpen() {
        System.out.println("Посмотрели на коробку: она " + (isOpen ? "открыта" : "закрыта"));
        return isOpen;
    }

    /**
     * Проверяет цвет коробки
     * @return цвет коробки
     */
    public String getColor() {
        System.out.println("Посмотрели на коробку: она покрашена в " + color + " цвет");
        return color;
    }

    /**
     * Перекрашивает коробку
     * @param _color новый цвет коробки
     */
    public void paint(String _color) {
        System.out.println("Перекрасили коробку в " + _color + " цвет");
        color = _color;
    }

    /**
     * Открывает коробку, если она закрыта
     */
    public void open() {
        if (!isOpen) {
            System.out.println("Открыли коробку");
            isOpen = true;
        } else {
            System.out.println("Убедились, что коробка открыта");
        }
    }

    /**
     * Закрывает коробку, если она открыта
     */
    public void close() {
        if (isOpen) {
            System.out.println("Закрыли коробку");
            isOpen = false;
        } else {
            System.out.println("Убедились, что коробка закрыта");
        }
    }

    /**
     * Заглядывает в коробку, если она открыта
     * @return предмет, который лежит в коробке
     * @throws BoxIsClosedException коробка закрыта
     */
    public String peek() throws BoxIsClosedException {
        if (!isOpen) {
            System.out.println("Неудачная попытка заглянуть в коробку: коробка закрыта");
            throw new BoxIsClosedException();
        }
        System.out.println("Заглянули в коробку: внутри " + (contents == null ? "пусто" : contents));
        return contents;
    }

    /**
     * Вынимает предмет из коробки
     * @return предмет, вынутый из коробки
     * @throws BoxIsClosedException коробка закрыта
     * @throws BoxIsEmptyException в коробке было пусто
     */
    public String eject() throws BoxIsClosedException, BoxIsEmptyException {
        if (!isOpen) {
            System.out.println("Неудачная попытка вынуть предмет из коробки: коробка закрыта");
            throw new BoxIsClosedException();
        }
        if (contents == null) {
            System.out.println("Неудачная попытка вынуть предмет из коробки: внутри оказалось пусто");
            throw new BoxIsEmptyException();
        }
        System.out.println("Вытряхнули из коробки предмет: " + contents);
        String ejectedContents = contents;
        contents = null;
        return ejectedContents;
    }

    /**
     * Кладет предмет в коробку
     * @param _contents предмет, складываемый в коробку
     * @throws BoxIsClosedException коробка закрыта
     * @throws BoxIsOccupiedException в коробке уже есть предмет
     */
    public void put(String _contents) throws BoxIsClosedException, BoxIsOccupiedException {
        if (!isOpen) {
            System.out.println("Неудачная попытка положить предмет в коробку: коробка закрыта");
            throw new BoxIsClosedException();
        }
        if (contents != null) {
            System.out.println("Неудачная попытка положить предмет в коробку: внутри уже есть предмет");
            throw new BoxIsOccupiedException();
        }
        System.out.println("Положили предмет в коробку: " + _contents);
        contents = _contents;
    }

    /**
     * Печатает полную информацию о коробке и ее содержимом в консоль
     */
    public void print() {
        System.out.printf("Это коробка. Она покрашена в %s цвет.\n" +
                        "Ее ширина - %f, высота - %f, а глубина - %f.\n" +
                        "Коробка %s. Внутри %s.\n",
                color,
                width, height, depth,
                isOpen ? "открыта" : "закрыта", contents == null ? "пусто" : contents);
    }

}

