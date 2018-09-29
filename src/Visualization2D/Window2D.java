package Visualization2D;

import TorusPuzzle.TorusPuzzle;
import TorusPuzzle.MoveSequence;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window2D extends JFrame implements ActionListener
{
    private final int CASE_DIMENSION = 50;
    private TorusPuzzle puzzle;
    JButton shuffleButton = new JButton("Shuffle");
    JButton solveButton = new JButton("Solve");
    MoveSequence sequence = new MoveSequence();

    public Window2D(TorusPuzzle puzzle)
    {
        this.puzzle = puzzle;
        this.setTitle("TorusPuzzle");
        this.setResizable(false);
        this.setSize(puzzle.colDim() * CASE_DIMENSION + 7, puzzle.rowDim() * CASE_DIMENSION + 36 + 45);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new TorusPanel(puzzle);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(panel, BorderLayout.CENTER);

        JPanel buttonsContainer = new JPanel();
        shuffleButton.addActionListener(this);
        buttonsContainer.add(shuffleButton);
        solveButton.addActionListener(this);
        buttonsContainer.add(solveButton);
        mainContainer.add(buttonsContainer, BorderLayout.SOUTH);

        this.setContentPane(mainContainer);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == shuffleButton)
        {
            MoveSequence shuffleSeq = new MoveSequence();
            puzzle.shuffle(100, shuffleSeq);
            sequence.add(shuffleSeq);
        }


        if(event.getSource() == solveButton)
        {
            puzzle.execute(sequence.reverseSequence());
            sequence = new MoveSequence();
        }

        repaint();
    }

}
