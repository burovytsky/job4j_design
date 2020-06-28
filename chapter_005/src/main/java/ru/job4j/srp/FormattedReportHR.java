package ru.job4j.srp;

import java.util.function.Predicate;

public class FormattedReportHR extends ReportHR implements FormattedReport {
    public FormattedReportHR(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter, Parser format) {
        return format.parse(store.findBy(filter));
    }
}
