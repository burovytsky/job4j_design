package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {
    @Test
    public void whenGeneratedReportForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 600);
        Employee worker2 = new Employee("Petr", now, now, 700);
        Employee worker3 = new Employee("John", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportHR hr = new ReportHR(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true), is(expected.toString()));
    }
}