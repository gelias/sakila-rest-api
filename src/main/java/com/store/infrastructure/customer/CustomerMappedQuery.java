package com.store.infrastructure.customer;

public enum CustomerMappedQuery {
    CUSTOMER_BY_COUNTRY("SELECT\n" +
                                "    count(1)\n" +
                                "FROM\n" +
                                "    customer cus\n" +
                                "    INNER JOIN address addr ON (cus.address_id = addr.address_id)\n" +
                                "    INNER JOIN city cit ON (addr.city_id = cit.city_id)\n" +
                                "    INNER JOIN country cty ON (cit.country_id = cty.country_id)\n" +
                                "WHERE\n" +
                                "    lower(cty.country) = ? ;"),
    CUSTOMER_BY_COUNTRY_AND_CITY(CUSTOMER_BY_COUNTRY.getRawValue()
            .replace(";","AND lower(cit.city) = ? ;"));


    private final String rawValue;

    private CustomerMappedQuery(String rawValue){
        this.rawValue = rawValue;
    }

    public String getRawValue() {
        return rawValue;
    }
}
