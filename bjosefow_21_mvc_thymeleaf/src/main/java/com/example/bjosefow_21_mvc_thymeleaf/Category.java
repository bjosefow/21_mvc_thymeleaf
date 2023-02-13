package com.example.bjosefow_21_mvc_thymeleaf;

public enum Category {
    GROCERIES("Art_spozywcze"),
    HOUSEHOLD_ART("Art_gosp_domowego"),
    OTHER("Inne");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
