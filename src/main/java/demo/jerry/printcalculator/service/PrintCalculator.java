package demo.jerry.printcalculator.service;

import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;

/**
 * This interface provides a common contract for printing calculator service.
 * Class that implement this class should provide a concrete way of calculate print cost.
 * @author jzhang
 *
 */
public interface PrintCalculator {

    /**
     * Calculate cost from a print job.
     * @param job
     * @return calculated print cost.
     */
    PrintCost calculateCost(PrintJob job);

}
