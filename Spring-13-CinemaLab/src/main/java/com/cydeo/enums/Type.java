package com.cydeo.enums;

public enum Type {

    PREMIER("Premier"),REGULAR("Regular");
    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
