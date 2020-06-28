package ru.job4j.srp;

import ru.job4j.srp.Employee;
import ru.job4j.srp.Report;
import ru.job4j.srp.Parser;

import java.util.function.Predicate;

public interface FormattedReport extends Report {
    String generate(Predicate<Employee> filter, Parser format);
}
