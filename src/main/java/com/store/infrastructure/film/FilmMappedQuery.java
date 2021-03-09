package com.store.infrastructure.film;

public enum FilmMappedQuery {

    FILM_BY_ACTOR("SELECT\n" +
            "    actor.first_name AS first_name,\n" +
            "    actor.last_name AS last_name,\n" +
            "    film.title AS title,\n" +
            "    film.description AS description,\n" +
            "    category.name AS category\n" +
            "FROM\n" +
            "    film film\n" +
            "    INNER JOIN film_actor fa ON (film.film_id = fa.film_id)\n" +
            "    INNER JOIN actor actor ON (fa.actor_id = ACTOR.actor_id)\n" +
            "    INNER JOIN film_category fc ON (FILM.film_id = fc.film_id)\n" +
            "    INNER JOIN category category ON (fc.category_id = CATEGORY.category_id)\n" +
            "WHERE\n" +
            "    lower(actor.first_name) = ?\n" +
            "    AND lower(actor.last_name) = ? ;");
    private final String rawValue;

    private FilmMappedQuery(String rawValue) {
        this.rawValue = rawValue;
    }

    public String getRawValue() {
        return rawValue;
    }
}
