package ru.job4j.srp;

import java.util.function.Predicate;

public class FormattedReportDev implements FormattedReport {

    private ReportDev reportDev;

    public FormattedReportDev(ReportDev reportDev) {
        this.reportDev = reportDev;
    }

    @Override
    public String generate(Predicate<Employee> filter, Parser format) {
        return format.parse(reportDev.store.findBy(filter));
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return reportDev.generate(filter);
    }
}
