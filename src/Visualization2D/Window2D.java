package Visualization2D;

import TorusPuzzle.TorusPuzzle;

import javax.swing.JFrame;

public class Window2D extends JFrame
{
    private final int CASE_DIMENSION = 50;

    public Window2D(TorusPuzzle puzzle)
    {
        this.setTitle("TorusPuzzle");
        this.setResizable(false);
        this.setSize((puzzle.colDim()+1) * CASE_DIMENSION, (puzzle.rowDim()+1) * CASE_DIMENSION);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new TorusPanel(puzzle));
        this.setVisible(true);

    }

}
