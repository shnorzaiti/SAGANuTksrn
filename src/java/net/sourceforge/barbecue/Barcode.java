package net.sourceforge.barbecue;

import java.awt.*;
import java.awt.print.*;
import java.text.StringCharacterIterator;
import javax.swing.JComponent;
import net.sourceforge.barbecue.env.Environment;
import net.sourceforge.barbecue.env.EnvironmentFactory;
import net.sourceforge.barbecue.env.HeadlessEnvironment;
import net.sourceforge.barbecue.output.GraphicsOutput;
import net.sourceforge.barbecue.output.Output;
import net.sourceforge.barbecue.output.OutputException;
import net.sourceforge.barbecue.output.SizingOutput;

// Referenced classes of package net.sourceforge.barbecue:
//            BarcodeException, Module
public abstract class Barcode extends JComponent
        implements Printable {

    private static final int DEFAULT_BAR_HEIGHT = 50;
    protected String data;
    protected String label;
    protected boolean drawingText;
    protected boolean drawingQuietSection;
    protected int barWidth;
    protected int barHeight;
    private Font font;
    private Dimension size;
    private int x;
    private int y;
    private int resolution;

    protected Barcode(String s)
            throws BarcodeException {
        drawingQuietSection = true;
        barWidth = 2;
        resolution = -1;
        if (s == null || s.length() == 0) {
            throw new BarcodeException("Data to encode cannot be empty");
        }
        data = s;
        int i = calculateMinimumBarHeight(getResolution());
        if (i > 0) {
            barHeight = i;
        } else {
            barHeight = 50;
        }
        font = EnvironmentFactory.getEnvironment().getDefaultFont();
        drawingText = true;
        setBackground(Color.white);
        setForeground(Color.black);
        setOpaque(true);
        invalidateSize();
    }

    public String getData() {
        return data;
    }

    public void setFont(Font font1) {
        font = font1;
        invalidateSize();
    }

    public void setDrawingText(boolean flag) {
        drawingText = flag;
        invalidateSize();
    }

    public boolean isDrawingText() {
        return drawingText;
    }

    public void setDrawingQuietSection(boolean flag) {
        drawingQuietSection = flag;
        invalidateSize();
    }

    public boolean isDrawingQuietSection() {
        return drawingQuietSection;
    }

    public void setBarWidth(int i) {
        if (i >= 1) {
            barWidth = i;
        } else {
            barWidth = 1;
        }
        invalidateSize();
    }

    public void setBarHeight(int i) {
        if (i > calculateMinimumBarHeight(getResolution())) {
            barHeight = i;
            invalidateSize();
        }
    }

    public void setResolution(int i) {
        if (i > 0) {
            resolution = i;
            int j = calculateMinimumBarHeight(getResolution());
            if (j > barHeight) {
                barHeight = j;
            }
            invalidateSize();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return (int) getActualSize().getWidth();
    }

    public int getHeight() {
        return (int) getActualSize().getHeight();
    }

    public Rectangle getBounds() {
        return getBounds(new Rectangle());
    }

    public Rectangle getBounds(Rectangle rectangle) {
        rectangle.setBounds(getX(), getY(), (int) getActualSize().getWidth() + getX(), (int) getActualSize().getHeight() + getY());
        return rectangle;
    }

    public Dimension getPreferredSize() {
        return getActualSize();
    }

    public Dimension getMinimumSize() {
        return getActualSize();
    }

    public Dimension getMaximumSize() {
        return getActualSize();
    }

    public Dimension getSize() {
        return getActualSize();
    }

    public void draw(Graphics2D graphics2d, int i, int j)
            throws OutputException {
        x = i;
        y = j;
        GraphicsOutput graphicsoutput = new GraphicsOutput(graphics2d, font, getForeground(), getBackground());
        size = draw(((Output) (graphicsoutput)), i, j, barWidth, barHeight);
    }

    public void output(Output output1)
            throws OutputException {
        draw(output1, 0, 0, barWidth, barHeight);
    }

    protected abstract Module[] encodeData();

    protected abstract Module calculateChecksum();

    protected abstract Module getPreAmble();

    protected abstract Module getPostAmble();

    protected abstract Dimension draw(Output output1, int i, int j, int k, int l)
            throws OutputException;

    public String getLabel() {
        if (label != null) {
            return label;
        } else {
            return beautify(data);
        }
    }

    public void setLabel(String s) {
        label = s;
    }

    protected int calculateMinimumBarHeight(int i) {
        return 0;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Insets insets = getInsets();
        try {
            draw((Graphics2D) g, insets.left, insets.top);
        } catch (OutputException outputexception) {
        }
    }

    protected int getResolution() {
        if (resolution > 0) {
            return resolution;
        } else {
            return EnvironmentFactory.getEnvironment().getResolution();
        }
    }

    protected int drawModule(Module module, Output output1, int i, int j, int k, int l)
            throws OutputException {
        if (module == null) {
            return 0;
        } else {
            return module.draw(output1, i, j, k, l);
        }
    }

    protected String beautify(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        StringCharacterIterator stringcharacteriterator = new StringCharacterIterator(s);
        for (char c = stringcharacteriterator.first(); c != '\uFFFF'; c = stringcharacteriterator.next()) {
            if (Character.isDefined(c) && !Character.isISOControl(c)) {
                stringbuffer.append(c);
            }
        }

        return stringbuffer.toString();
    }

    private void invalidateSize() {
        size = null;
    }

    private Dimension getActualSize() {
        if (size == null) {
            size = calculateSize();
        }
        return size;
    }

    private Dimension calculateSize() {

        setFont(new Font("Arial", Font.BOLD, 12));
        Dimension dimension = new Dimension();
        if (EnvironmentFactory.getEnvironment() instanceof HeadlessEnvironment) {
            try {

                if (font == null) {
                    dimension = draw(new SizingOutput(font, getForeground(), getBackground()), 0, 0, barWidth, barHeight);
                } else {
                    java.awt.FontMetrics fontMetrics = getFontMetrics(font);
                    dimension = draw(new SizingOutput(font, fontMetrics, getForeground(), getBackground()), 0, 0, barWidth, barHeight);
                }
            } catch (OutputException e) {
                e.printStackTrace();
            }
        } else {
            try {
                java.awt.FontMetrics fontMetrics = null;
                if (font != null) {
                    fontMetrics = getFontMetrics(font);
                }
                dimension = draw(new SizingOutput(font, fontMetrics, getForeground(), getBackground()), 0, 0, barWidth, barHeight);
            } catch (OutputException e) {
            }
        }
        return dimension;
    }

    public int print(Graphics g, PageFormat pageformat, int i)
            throws PrinterException {
        try {
            if (i >= 1) {
                return 1;
            }
            draw((Graphics2D) g, 0, 0);
            return 0;
        } catch (OutputException outputexception) {
            throw new PrinterException(outputexception.getMessage());
        }
        //OutputException outputexception;
        //outputexception;

    }

    public String toString() {
        return getData();
    }
}
