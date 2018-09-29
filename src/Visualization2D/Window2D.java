package Visualization2D;

import TorusPuzzle.TorusPuzzle;
import TorusPuzzle.MoveSequence;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class Window2D extends JFrame implements ActionListener
{
    public static final int CASE_DIMENSION = 50;
    private static final int SHIFT_X_BORDER = 7;
    private static final int SHIFT_Y_BORDER = 36;
    private static final int SHIFT_Y_BUTTONS = 45;
    private TorusPuzzle puzzle;
    private TorusPanel torusPanel;
    private JButton shuffleButton = new JButton("Shuffle");
    private JButton solveButton = new JButton("Solve");
    private MoveSequence sequence = new MoveSequence();

    public Window2D(TorusPuzzle puzzle)
    {
        this.puzzle = puzzle;
        this.setTitle("TorusPuzzle");
        this.setResizable(false);
        this.setSize(puzzle.colDim() * CASE_DIMENSION + SHIFT_X_BORDER, puzzle.rowDim() * CASE_DIMENSION + SHIFT_Y_BORDER + SHIFT_Y_BUTTONS);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());

        torusPanel = new TorusPanel(puzzle);
        mainContainer.add(torusPanel, BorderLayout.CENTER);

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
        else if(event.getSource() == solveButton)
        {
            puzzle.execute(sequence.reverseSequence());
            sequence = new MoveSequence();
        }

        repaint();
    }
}
