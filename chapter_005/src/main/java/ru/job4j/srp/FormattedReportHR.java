package ru.job4j.srp;

import java.util.function.Predicate;

public class FormattedReportHR implements FormattedReport {
    private ReportHR reportHR;

    public FormattedReportHR(ReportHR reportHR) {
        this.reportHR = reportHR;
    }

    @Override
    public String generate(Predicate<Employee> filter, Parser format) {
        return format.parse(reportHR.store.findBy(filter));
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return reportHR.generate(filter);
    }
}
