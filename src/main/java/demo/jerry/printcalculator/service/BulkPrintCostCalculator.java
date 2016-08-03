package demo.jerry.printcalculator.service;

import java.util.List;

import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;

public interface BulkPrintCostCalculator {

    List<PrintCost> calculateAllJobs(List<PrintJob> printJobList);

}
