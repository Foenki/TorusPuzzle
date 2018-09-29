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
            for(int j = 0; j < puzzle.colDim(); ++j)
            {
                g.drawString(""+puzzle.getValue(i, j), 15 + j * 50, 30 + i * 50);
            }
        }

    }

}