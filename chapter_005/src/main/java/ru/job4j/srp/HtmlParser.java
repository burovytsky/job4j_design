package ru.job4j.srp;

import java.util.List;

public class HtmlParser implements Parser {
    @Override
    public String parse(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html><html>")
                .append("<meta charset=\"utf-8\">")
                .append("<head><title>Report</title></head><body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>");
        for (Employee employee : list) {
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
