package com.example.bjosefow_21_mvc_thymeleaf;

public enum Category {
    GROCERIES("art_spozywcze", "Artykuly spozywcze"),
    HOUSEHOLD_ART("art_gosp_domowego", "Artykuly gospodarstwa domowego"),
    OTHER("inne", "Pozostale");

    private final String description;
    private final String descriptionToDisplay;

    Category(String description, String descriptionToDisplay) {
        this.description = description;
        this.descriptionToDisplay = descriptionToDisplay;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionToDisplay() {
        return descriptionToDisplay;
    }

    public static Category getCategoryFromDesc(String description) {
        for (Category value : values()) {
            if (value.description.equals(description)) {
                return value;
            }
        }
        return null;
    }

}
