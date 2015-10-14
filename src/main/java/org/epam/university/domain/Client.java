package org.epam.university.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Andrei Kuzniatsou
 */
public class Client {

    @Value("${id}")
    private String id;
    @Value("${name}")
    private String name;
    @Value("${greeting}")
    private String greeting;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("greeting", greeting)
                .toString();
    }
}
