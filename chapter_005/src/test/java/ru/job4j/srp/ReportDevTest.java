package ru.job4j.srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Calendar;

public class ReportDevTest {

    @Test
    public void whenGenerateReportForDev() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 600);
        store.add(worker);
        ReportDev engine = new ReportDev(store);
        StringBuilder expected = new StringBuilder();
        expected.append("<!DOCTYPE html><html>")
                .append("<meta charset=\"utf-8\">")
                .append("<head><title>Report</title></head><body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body></html>");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}