package org.logging.utils.dtos;

import java.io.Serial;
import java.io.Serializable;

public class Animal implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String color;

    private transient String secureMedical;

    public Animal() {

        this.name = "Unknown";
        this.color = "#FF0000";
        this.secureMedical = "CPT";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
