package Tests;

import TorusPuzzle.TorusPuzzle;
import TorusPuzzle.Move;
import TorusPuzzle.MoveSequence;
import TorusPuzzle.TextDisplayer;

import javax.xml.soap.Text;

public class TestBasicOperations {

    public static void main(String[] args)
    {
        TorusPuzzle puzzle = new TorusPuzzle(3,6);

        TextDisplayer.display(puzzle);

        MoveSequence sequence = new MoveSequence();
        sequence.add(new Move(1, Move.EDirection.ROW_LEFT));
        sequence.add(new Move(0, Move.EDirection.COLUMN_DOWN));

        puzzle.execute(sequence);
        TextDisplayer.display(puzzle);
        puzzle.execute(sequence.reverseSequence());
        TextDisplayer.display(puzzle);

        MoveSequence seq = new MoveSequence();
        puzzle.shuffle(5, seq);
        TextDisplayer.display(seq);
        TextDisplayer.display(puzzle);

        MoveSequence reverse = seq.reverseSequence();
        TextDisplayer.display(reverse);
        puzzle.execute(reverse);
        TextDisplayer.display(puzzle);

    }
}
