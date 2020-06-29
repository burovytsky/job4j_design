package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FormattedReportDevTest {

    @Test
    public void whenGenerateJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 600);
        store.add(worker1);
        FormattedReport hr = new FormattedReportDev(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Json tags")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("Json tags");
        assertThat(hr.generate(em -> true, new JsonParser()), is(expected.toString()));
    }

    @Test
    public void whenGenerateXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Petr", now, now, 1000);
        store.add(worker1);
        FormattedReport hr = new FormattedReportDev(store);
        StringBuilder expected = new StringBuilder();
        expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><employers>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("XML");
        assertThat(hr.generate(em -> true, new XmlParser()), is(expected.toString()));
    }
}