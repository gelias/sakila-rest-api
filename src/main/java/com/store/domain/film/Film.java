package com.store.domain.film;

import lombok.Getter;

public class Film {

    @Getter private final String actorFirstName;
    @Getter private final String actorLastName;
    @Getter private final String title;
    @Getter private final String description;
    private final String category;

    public Film(String actorFirstName, String actorLastName, String title, String description, String category) {
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
