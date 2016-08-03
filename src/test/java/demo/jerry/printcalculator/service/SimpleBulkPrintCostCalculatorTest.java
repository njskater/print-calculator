package demo.jerry.printcalculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.jerry.printcalculator.model.PrintCategory;
import demo.jerry.printcalculator.model.PrintCost;
import demo.jerry.printcalculator.model.PrintJob;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

/**
 * SimpleBulkPrintCostCalculator unit test.
 * @author jzhang
 *
 */
public class SimpleBulkPrintCostCalculatorTest {
    private SimpleBulkPrintCostCalculator bulkCalculator;

    @Mock
    private PrintCalculator mockPrintCalculator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bulkCalculator = new SimpleBulkPrintCostCalculator(mockPrintCalculator);
    }

    @Test
    public void testCalculateNullJobList() {
        final List<PrintCost> result = bulkCalculator.calculateAllJobs(null);
        assertEquals(0, result.size());
    }


    @Test
    public void testCalculateEmptyList() {
        final List<PrintCost> result = bulkCalculator.calculateAllJobs(new ArrayList<>());
        assertEquals(0, result.size());
    }

    @Test
    public void testBulkCalculate() {
        final PrintJob job1 = new PrintJob(PrintCategory.a4BlackWhiteDoubleSided(), 3);
        final PrintJob job2 = new PrintJob(PrintCategory.a4BlackWhiteSingleSided(), 5);

        final PrintCost cost1 = new PrintCost(job1, new BigDecimal("3.0"), new BigDecimal("1.0"));
        final PrintCost cost2 = new PrintCost(job2, new BigDecimal("10.0"), new BigDecimal("2.0"));

        when(mockPrintCalculator.calculateCost(job1)).thenReturn(cost1);
        when(mockPrintCalculator.calculateCost(job2)).thenReturn(cost2);

        final List<PrintCost> result = bulkCalculator.calculateAllJobs(Arrays.asList(job1, job2));

        assertEquals(2, result.size());
        assertEquals(cost1, result.get(0));
        assertEquals(cost2, result.get(1));
    }
}
