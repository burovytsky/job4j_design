package ru.job4j.srp;

import java.util.function.Predicate;

public class FormattedReportDev extends ReportDev implements FormattedReport {
    public FormattedReportDev(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter, Parser format) {
        return format.parse(store.findBy(filter));
    }
}
