package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportAccountantTest {

    @Test
    public void whenGenerateReportForAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Petr", now, now, 10000);
        store.add(worker);
        ReportAccountant accountants = new ReportAccountant(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 0.014).append(";")
                .append(System.lineSeparator());
        assertThat(accountants.generate(em -> true), is(expected.toString()));
    }
}