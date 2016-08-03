package demo.jerry.printcalculator.service;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;
import demo.jerry.printcalculator.model.PrintPriceTable;
import static org.junit.Assert.assertEquals;

/**
 * FixedPricePrintCalculator unit test.
 * @author jzhang
 *
 */
public class FixedPricePrintCalculatorTest {
    private FixedPricePrintCalculator calculator;
    private PrintPriceTable printPriceTable;

    @Before
    public void setup() {
        printPriceTable = new PrintPriceTable();
        printPriceTable.addUnitPrice(PrintCategory.a4BlackWhiteDoubleSided(), new BigDecimal("0.10"));
        printPriceTable.addUnitPrice(PrintCategory.a4ColourDoubleSided(), new BigDecimal("0.20"));
        calculator = new FixedPricePrintCalculator(printPriceTable);
    }

    @Test
    public void testValidCalculate() {
        final PrintCost cost = calculator.calculateCost(new PrintJob(PrintCategory.a4BlackWhiteDoubleSided(), 10));
        assertEquals(new BigDecimal("1.00"), cost.getCost());
        assertEquals(new BigDecimal("0.10"), cost.getUnitPrice());
        assertEquals(10, cost.getPrintJob().getPageNumber());
        assertEquals(PrintCategory.a4BlackWhiteDoubleSided(), cost.getPrintJob().getPrintCategory());
    }

    @Test
    public void testValidCalculate2() {
        final PrintCost cost = calculator.calculateCost(new PrintJob(PrintCategory.a4ColourDoubleSided(), 10));
        assertEquals(new BigDecimal("2.00"), cost.getCost());
        assertEquals(new BigDecimal("0.20"), cost.getUnitPrice());
        assertEquals(10, cost.getPrintJob().getPageNumber());
        assertEquals(PrintCategory.a4ColourDoubleSided(), cost.getPrintJob().getPrintCategory());
    }


    @Test
    public void testInValidUnitPriceCalculate() {
        final PrintCost cost = calculator.calculateCost(new PrintJob(PrintCategory.a4BlackWhiteSingleSided(), 10));
        assertEquals(new BigDecimal("0"), cost.getCost());
        assertEquals(new BigDecimal("0"), cost.getUnitPrice());
        assertEquals(10, cost.getPrintJob().getPageNumber());
        assertEquals(PrintCategory.a4BlackWhiteSingleSided(), cost.getPrintJob().getPrintCategory());
    }
}
