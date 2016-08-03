package demo.jerry.printcalculator.output;

import java.util.List;

import demo.jerry.printcalculator.model.PrintCost;

/**
 * Class that implements this class should write print cost list
 * to a form of output.
 * @author jzhang
 *
 */
public interface PrintCostOutputWriter {

    /**
     * Output this list of {@link PrintCost}.
     * @param printCosts
     */
    void outputPrintCost(List<PrintCost> printCosts);

}
