package ru.job4j.srp;

import java.util.List;

public class XmlParser implements Parser {
    @Override
    public String parse(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><employers>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;");
        for (Employee employee : list) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("XML");
        return text.toString();
    }
}
