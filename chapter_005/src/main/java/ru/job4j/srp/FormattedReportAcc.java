package ru.job4j.srp;

import java.util.function.Predicate;

public class FormattedReportAcc implements FormattedReport {
    private ReportAccountant reportAccountant ;

    public FormattedReportAcc(ReportAccountant reportAccountant) {
        this.reportAccountant = reportAccountant;
    }

    @Override
    public String generate(Predicate<Employee> filter, Parser format) {
        return format.parse(reportAccountant.store.findBy(filter));
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return reportAccountant.generate(filter);
    }
}
