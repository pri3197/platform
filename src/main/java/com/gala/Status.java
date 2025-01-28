package com.gala;
public enum Status {
    LOW("Low Compliance"),
    MEDIUM("Medium Compliance"),
    HIGH("High Compliance");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}