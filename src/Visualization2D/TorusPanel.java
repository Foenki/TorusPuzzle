package Visualization2D;

import TorusPuzzle.TorusPuzzle;

import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class TorusPanel extends JPanel
{
    private TorusPuzzle puzzle;
    private static final Font VALUES_FONT = new Font("Courier", Font.BOLD, 20);
    private static final int VALUE_SHIFT_X = 20;
    private static final int VALUE_SHIFT_Y = 35;
    private static final int DIGIT_SHIFT_X = 6;

    public TorusPanel(TorusPuzzle puzzle)
    {
        super();
        this.puzzle = puzzle;
    }

    public void paintComponent(Graphics g)
    {
        drawValues(g);
        drawLines(g);
    }

    public void drawValues(Graphics g)
    {
        g.setFont(VALUES_FONT);
        for(int i = 0; i < puzzle.rowDim(); ++i)
        {
            int lineY = i * Window2D.CASE_DIMENSION;
            for(int j = 0; j < puzzle.colDim(); ++j)
            {
                int columnX = j * Window2D.CASE_DIMENSION;
                int value = puzzle.getValue(i, j);
                int nbDigits = 1 + (int)Math.log10(value);
                g.drawString("" + value, columnX + VALUE_SHIFT_X - (nbDigits-1) * DIGIT_SHIFT_X, lineY + VALUE_SHIFT_Y);
            }
        }
    }

    public void drawLines(Graphics g)
    {
        for(int i = 0; i <= puzzle.rowDim(); ++i)
        {
            g.drawLine(0, i * Window2D.CASE_DIMENSION, puzzle.colDim() * Window2D.CASE_DIMENSION, i * Window2D.CASE_DIMENSION);
        }

        for(int j = 0; j <= puzzle.colDim(); ++j)
        {
            g.drawLine(j * Window2D.CASE_DIMENSION, 0, j * Window2D.CASE_DIMENSION, puzzle.rowDim() * Window2D.CASE_DIMENSION);
        }
    }

}