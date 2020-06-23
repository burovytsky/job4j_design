package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHRHtml extends ReportHR {
    public ReportHRHtml(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> hrList = store.findBy(filter);
        hrList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        text.append("<!DOCTYPE html><html>")
                .append("<meta charset=\"utf-8\">")
                .append("<head><title>Report</title></head><body>")
                .append("<h1>Name; Salary;</h1>");
        for (Employee employee : hrList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body></html>");
        return text.toString();
    }
}
