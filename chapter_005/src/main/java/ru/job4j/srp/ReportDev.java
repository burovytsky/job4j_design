package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportDev implements Report {
    private final Store store;

    public ReportDev(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> engineList = store.findBy(filter);
        text.append("<!DOCTYPE html><html>")
                .append("<meta charset=\"utf-8\">")
                .append("<head><title>Report</title></head><body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>");
        for (Employee employee : engineList) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body></html>");
        return text.toString();
    }
}
