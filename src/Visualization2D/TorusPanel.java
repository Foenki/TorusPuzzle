package Visualization2D;

import TorusPuzzle.TorusPuzzle;

import java.awt.*;

import javax.swing.JPanel;

public class TorusPanel extends JPanel
{
    private TorusPuzzle puzzle;

    public TorusPanel(TorusPuzzle puzzle)
    {
        super();
        this.puzzle = puzzle;
    }

    public void paintComponent(Graphics g)
    {
        Font font = new Font("Courier", Font.BOLD, 20);
        g.setFont(font);
        for(int i = 0; i < puzzle.rowDim(); ++i)
        {
            int lineY = i * 50;
            g.drawLine(0, lineY, puzzle.colDim() * 50, lineY);
            for(int j = 0; j < puzzle.colDim(); ++j)
            {
                int columnX = j * 50;
                if(i == 0)
                {
                    g.drawLine(columnX, 0, columnX, puzzle.rowDim()*50);
                }
                int value = puzzle.getValue(i, j);
                int nbDigits = 1+(int)Math.log10(value);
                g.drawString("" + value, 20 + columnX - (nbDigits-1) * 6, 35 + lineY);
            }
        }
        g.drawLine(0, 50 * puzzle.rowDim(), puzzle.colDim() * 50, 50 * puzzle.rowDim());
        g.drawLine(50 * puzzle.colDim(), 0, puzzle.colDim() * 50, 50 * puzzle.rowDim());


    }

}