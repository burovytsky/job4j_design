package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHRXml extends ReportHR {
    public ReportHRXml(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> hrList = store.findBy(filter);
        hrList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        text.append("XML tags")
                .append("Name; Salary;");
        for (Employee employee : hrList) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        text.append("XML tags");
        return text.toString();
    }
}
