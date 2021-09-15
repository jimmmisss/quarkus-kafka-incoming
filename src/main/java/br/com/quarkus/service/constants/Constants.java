package br.com.quarkus.service.constants;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constant class");
    }

    public static final String ENTITY_NOT_FOUND = "%s não encontrado(a), ID: %d";

    public static final String CUSTOMER = "cliente";
    public static final String CUSTOMER_PRODUCER = "CUSTOMER";

    public static final String CREATE = "CREATE";
}
