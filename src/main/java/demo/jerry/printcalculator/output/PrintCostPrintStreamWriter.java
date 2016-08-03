package demo.jerry.printcalculator.output;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;

import demo.jerry.printcalculator.model.PrintCost;

/**
 * This class prints a list of {@link PrintCost} to a {@link PrintStream}.
 * @author jzhang
 *
 */
public class PrintCostPrintStreamWriter implements PrintCostOutputWriter {
    private final PrintStream printStream;


    public PrintCostPrintStreamWriter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void outputPrintCost(List<PrintCost> printCosts) {
        if (printCosts == null) {
            return;
        }

        BigDecimal total = BigDecimal.ZERO;

        for (final PrintCost printCost: printCosts) {
            writeToConsole(printCost);
            total = total.add(printCost.getCost());
        }

        writeSummary(total);

    }

    private void writeSummary(BigDecimal total) {
        printStream.println("total amount:" + total);
    }

    private void writeToConsole(PrintCost printCost) {
        final StringBuilder sb = new StringBuilder();
        sb.append(" job: ").append(printCost.getPrintJob().getPrintCategory());
        sb.append(" page number:").append(printCost.getPrintJob().getPageNumber());
        sb.append(" unit price:").append(printCost.getUnitPrice());
        sb.append(" job cost:").append(printCost.getCost());
        printStream.println(sb.toString());

    }

}
