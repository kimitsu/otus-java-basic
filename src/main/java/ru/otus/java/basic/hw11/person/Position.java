package ru.otus.java.basic.hw11.person;

public enum Position {
    DIRECTOR(true), BRANCH_DIRECTOR(true), SENIOR_MANAGER(true), MANAGER(true),
    DEVELOPER(false), QA(false), DRIVER(false), ENGINEER(false),
    JANITOR(false), PLUMBER(false), JUNIOR_DEVELOPER(false);

    private final boolean isManager;

    Position(boolean isManager) {
        this.isManager = isManager;
    }

    /**
     * @return true if the position is related to management
     */
    public boolean isManager() {
        return isManager;
    }
}
