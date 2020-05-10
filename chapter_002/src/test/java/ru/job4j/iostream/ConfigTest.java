package ru.job4j.iostream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/app.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"), is("username")
        );
        assertThat(
                config.value("hibernate.connection.class"), is("org.postgresql.Driver")
        );
    }

}