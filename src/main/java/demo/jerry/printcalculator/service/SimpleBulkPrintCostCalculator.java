package demo.jerry.printcalculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;

/**
 * This calculator calculate a list of {@link PrintJob} using given {@link PrintCalculator} and returns a list of {@link PrintCost}.
 * @author jzhang
 */
public class SimpleBulkPrintCostCalculator implements BulkPrintCostCalculator {

    private final PrintCalculator calculator;

    public SimpleBulkPrintCostCalculator(final PrintCalculator calculator) {
        this.calculator = calculator;
    }

    /* (non-Javadoc)
     * @see demo.jerry.printcalculator.service.BulkPrintCostCalculator#calculateAllJobs(java.util.List) */
    @Override
    public List<PrintCost> calculateAllJobs(List<PrintJob> printJobList) {
        final List<PrintCost> result = new ArrayList<>();
        if (printJobList == null) {
            return result;
        }

        return printJobList.stream().map(p -> calculator.calculateCost(p)).collect(Collectors.toList());

    }

}
