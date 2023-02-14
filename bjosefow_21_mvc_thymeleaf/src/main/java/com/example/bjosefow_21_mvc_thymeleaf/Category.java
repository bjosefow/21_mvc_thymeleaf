package com.example.bjosefow_21_mvc_thymeleaf;

public enum Category {
    GROCERIES("art_spozywcze"),
    HOUSEHOLD_ART("art_gosp_domowego"),
    OTHER("inne");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
