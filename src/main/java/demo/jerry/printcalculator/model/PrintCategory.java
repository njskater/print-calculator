package demo.jerry.printcalculator.model;


/**
 * Immutable POJO to reprsent Printing Category.
 * @author jzhang
 *
 */
public class PrintCategory {
    private final PaperSize paperSize;
    private final boolean colourPrint;
    private final boolean doubleSided;

    public PrintCategory(PaperSize paperSize, boolean colourPrint, boolean doubleSided) {
        this.paperSize = paperSize;
        this.colourPrint = colourPrint;
        this.doubleSided = doubleSided;
    }

    public static PrintCategory a4BlackWhiteSingleSided() {
        return new PrintCategory(PaperSize.A4, false, false);
    }

    public static PrintCategory a4BlackWhiteDoubleSided() {
        return new PrintCategory(PaperSize.A4, false, true);
    }

    public static PrintCategory a4ColourSingleSided() {
        return new PrintCategory(PaperSize.A4, true, false);
    }

    public static PrintCategory a4ColourDoubleSided() {
        return new PrintCategory(PaperSize.A4, true, true);
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public boolean isColourPrint() {
        return colourPrint;
    }

    public boolean isDoubleSided() {
        return doubleSided;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (colourPrint ? 1231 : 1237);
        result = prime * result + (doubleSided ? 1231 : 1237);
        result = prime * result + ((paperSize == null) ? 0 : paperSize.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final PrintCategory other = (PrintCategory) obj;
        if (colourPrint != other.colourPrint) return false;
        if (doubleSided != other.doubleSided) return false;
        if (paperSize != other.paperSize) return false;
        return true;
    }

    @Override
    public String toString() {
        return "[paperSize=" + paperSize + ", colorPrint=" + colourPrint + ", doubleSided=" + doubleSided + "]";
    }





}
