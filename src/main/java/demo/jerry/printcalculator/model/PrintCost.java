package demo.jerry.printcalculator.model;

import java.math.BigDecimal;

/**
 * Immutable POJO that decorate {@link PrintJob} to represent print cost record.
 * @author jzhang
 *
 */
public class PrintCost {
    private final PrintJob printJob;
    private final BigDecimal cost;
    private final BigDecimal unitPrice;


    public PrintCost(PrintJob printJob, BigDecimal cost, BigDecimal unitPrice) {
        this.printJob = printJob;
        this.cost = cost;
        this.unitPrice = unitPrice;
    }

    public PrintJob getPrintJob() {
        return printJob;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

}
