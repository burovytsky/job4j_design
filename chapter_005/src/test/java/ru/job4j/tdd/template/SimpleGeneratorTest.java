package ru.job4j.tdd.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {
    @Ignore
    public void whenGeneratorReturnCorrectResult() {
        SimpleGenerator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> words = new HashMap<>();
        words.put("name", "Petr");
        words.put("subject", "you");
        String result = generator.produce(template, words);
        String expected = "I am a Petr, Who are you";
        assertThat(result, is(expected));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenThereAreNotKeyInMap(){
        SimpleGenerator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> words = new HashMap<>();
        words.put("name", "Petr");
        generator.produce(template, words);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenThereIsAnExtraKeyInTheCard(){
        SimpleGenerator generator = new SimpleGenerator();
        String template = "I am a ${name}";
        Map<String, String> words = new HashMap<>();
        words.put("name", "Petr");
        words.put("subject", "you");
        generator.produce(template, words);
    }
}