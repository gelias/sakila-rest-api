package com.store.infrastructure.rental;

public enum RentalMappedQuery {

    RENTAL_OVERDUE("SELECT\n" +
            "    c.last_name || ', ' || c.first_name AS customer,\n" +
            "    a.phone AS phone,\n" +
            "    f.title AS title\n" +
            "\n" +
            "FROM\n" +
            "    rental r\n" +
            "    INNER JOIN inventory i ON (r.inventory_id = i.inventory_id)\n" +
            "    INNER JOIN film f ON (i.film_id = f.film_id)\n" +
            "    INNER JOIN customer c ON (r.customer_id = c.customer_id)\n" +
            "    INNER JOIN address a ON (c.address_id = a.address_id)\n" +
            "WHERE\n" +
            "    r.return_date IS NULL\n" +
            "    AND (EXTRACT(DAY FROM (CURRENT_DATE - r.rental_date)) > f.rental_duration);");

    private final String rawValue;

    private RentalMappedQuery(String rawValue){
        this.rawValue = rawValue;
    }

    public String getRawValue() {
        return rawValue;
    }
}
