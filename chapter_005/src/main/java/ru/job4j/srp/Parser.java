package ru.job4j.srp;

import ru.job4j.srp.Employee;

import java.util.List;

public interface Parser {
    String parse(List<Employee> list);
}
