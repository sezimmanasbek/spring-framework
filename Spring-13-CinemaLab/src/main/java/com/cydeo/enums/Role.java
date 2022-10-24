package com.cydeo.enums;

public enum Role {
    REGULAR("Regular"), ADMIN("Admin");

    private final String value;

    Role(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
