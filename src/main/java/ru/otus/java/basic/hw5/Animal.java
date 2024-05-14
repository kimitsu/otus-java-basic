package ru.otus.java.basic.hw5;

public abstract class Animal {
    String name;
    double runSpeed;
    double swimSpeed;
    double endurance;
    double swimEndurancePerMeter;

    public Animal(String name, double runSpeed, double swimSpeed, double endurance, double swimEndurancePerMeter) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        this.swimEndurancePerMeter = swimEndurancePerMeter;
    }

    public double run(int distance) {
        if (endurance < 0) {
            System.out.println(name + " отдыхает и дальше не побежит");
            return -1;
        }
        endurance -= distance;
        if (endurance < 0) {
            System.out.println(name + " устает при забеге на дистанцию, пробежав " +
                    (distance + endurance) + " из " + distance + " м");
            return -1;
        }
        System.out.println(name + " пробегает " + distance + " м за " + distance / runSpeed + " с, сохраняя " + endurance + " выносливости в запасе");
        return distance / runSpeed;
    }

    public double swim(int distance) {
        if (endurance < 0) {
            System.out.println(name + " отдыхает и дальше не поплывет");
            return -1;
        }
        endurance -= distance * swimEndurancePerMeter;
        if (endurance < 0) {
            System.out.println(name + " устает при заплыве на дистанцию, проплыв " +
                    (distance + endurance / swimEndurancePerMeter) + " из " + distance + " м");
            return -1;
        }
        System.out.println(name + " проплывает " + distance + " м за " + distance / swimSpeed + " с, сохраняя " + endurance + " выносливости в запасе");
        return distance / swimSpeed;
    }

    public void info() {
        System.out.println("Это животное по имени " + name);
        System.out.println("Скорость бега:        " + runSpeed);
        System.out.println("Скорость плавания:    " + swimSpeed);
        System.out.println("Остаток выносливости: " + endurance);
        if (endurance < 0) {
            System.out.println(name + " отдыхает");
        }
    }
}
