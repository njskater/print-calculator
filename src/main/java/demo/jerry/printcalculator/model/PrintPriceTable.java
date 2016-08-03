package demo.jerry.printcalculator.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * An decorator of Map to represent print price table.
 * @author jzhang
 *
 */
public class PrintPriceTable {
    private final Map<PrintCategory, BigDecimal> printPriceMap = new HashMap<>();

    /**
     * Add a {@link PrintCategory} and unit price to this price table.
     * @param printCategory print category of the unit price.
     * @param unitPrice unit price of print for this category.
     */
    public void addUnitPrice(PrintCategory printCategory, BigDecimal unitPrice) {
        if (printCategory == null || unitPrice == null) {
            throw new IllegalArgumentException("printCategory and unitPrice must be provided");
        }
        printPriceMap.put(printCategory, unitPrice);
    }

    /**
     * Get unit price for give {@link PrintCategory}.
     * @param printCategory printCategory to find unit price, mandatory.
     * @return unit price if category is found, otherwise return null.
     */
    public BigDecimal getUnitPrice(PrintCategory printCategory) {
        return printPriceMap.get(printCategory);
    }


}
