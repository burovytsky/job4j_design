package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHRJson extends ReportHR {
    public ReportHRJson(Store store) {
        super(store);
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> hrList = store.findBy(filter);
        hrList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        text.append("JSON tags")
                .append("Name; Salary;");
        for (Employee employee : hrList) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        text.append("JSON tags");
        return text.toString();
    }
}
