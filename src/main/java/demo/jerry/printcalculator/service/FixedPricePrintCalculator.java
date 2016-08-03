package demo.jerry.printcalculator.service;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;
import demo.jerry.printcalculator.model.PrintPriceTable;

/**
 * This is a print calculator that calculate print cost based on fixed price.
 * @author jzhang
 */
public class FixedPricePrintCalculator implements PrintCalculator {

    private static final Log LOGGER = LogFactory.getLog(FixedPricePrintCalculator.class);

    private final PrintPriceTable printPriceTable;

    /**
     * Construct a {@link FixedPricePrintCalculator} based on provided {@link PrintPriceTable}.
     * @param printPriceTable
     */
    public FixedPricePrintCalculator(PrintPriceTable printPriceTable) {
        if (printPriceTable == null) {
            throw new IllegalArgumentException("printPriceTable must be provided.");
        }
        this.printPriceTable = printPriceTable;
    }

    /**
     * Calculate cost using fixed price table.
     * @see PrintCalculator#calculateCost(PrintJob)
     */
    @Override
    public PrintCost calculateCost(PrintJob job) {
        final PrintCategory printCategory = job.getPrintCategory();
        final BigDecimal unitPrice = printPriceTable.getUnitPrice(printCategory);
        if (unitPrice == null) {
            LOGGER.warn("Couldn't find unit price for print category:" + printCategory);
            return new PrintCost(job, BigDecimal.ZERO, BigDecimal.ZERO);
        }
        final BigDecimal jobCost = unitPrice.multiply(new BigDecimal(job.getPageNumber()));
        return new PrintCost(job, jobCost, unitPrice);
    }

}
