package Visualization2D;

import TorusPuzzle.TorusPuzzle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Window2D extends JFrame
{
    private final int CASE_DIMENSION = 50;

    public Window2D(TorusPuzzle puzzle)
    {
        this.setTitle("TorusPuzzle");
        this.setResizable(false);
        this.setSize(puzzle.colDim() * CASE_DIMENSION + 7, puzzle.rowDim() * CASE_DIMENSION + 36 + 45);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new TorusPanel(puzzle);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(panel, BorderLayout.CENTER);

        JPanel buttonsContainer = new JPanel();;
        buttonsContainer.add(new JButton("Shuffle"));
        buttonsContainer.add(new JButton("Solve"));
        mainContainer.add(buttonsContainer, BorderLayout.SOUTH);

        this.setContentPane(mainContainer);
        this.setVisible(true);

    }

}
