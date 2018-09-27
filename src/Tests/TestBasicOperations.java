package Tests;

import TorusPuzzle.TorusPuzzle;
import TorusPuzzle.Move;
import TorusPuzzle.MoveSequence;

public class TestBasicOperations {

    public static void main(String[] args)
    {
        TorusPuzzle puzzle = new TorusPuzzle(8,5);

        System.out.println(puzzle.toString());

        MoveSequence sequence = new MoveSequence();
        sequence.add(new Move(1, Move.EDirection.ROW_LEFT));
        sequence.add(new Move(0, Move.EDirection.COLUMN_DOWN));

        puzzle.execute(sequence);
        System.out.println(puzzle.toString());
        puzzle.execute(sequence.reverseSequence());
        System.out.println(puzzle.toString());

        MoveSequence seq = new MoveSequence();
        puzzle.shuffle(30, seq);
        System.out.println(seq.toString());
        System.out.println(puzzle.toString());

        MoveSequence reverse = seq.reverseSequence();
        System.out.println(reverse.toString());
        puzzle.execute(reverse);
        System.out.println(puzzle.toString());
    }
}
