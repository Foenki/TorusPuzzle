package Tests;

import TorusPuzzle.TorusPuzzle;
import TorusPuzzle.Move;
import TorusPuzzle.TextDisplayer;

import javax.xml.soap.Text;

public class TestBasicOperations {

    public static void main(String[] args)
    {
        TorusPuzzle puzzle = new TorusPuzzle(8,6);

        TextDisplayer.display(puzzle);

        puzzle.execute(new Move(1, Move.EDirection.ROW_LEFT));

        TextDisplayer.display(puzzle);

        puzzle.execute(new Move(0, Move.EDirection.COLUMN_DOWN));

        TextDisplayer.display(puzzle);

        puzzle.execute(new Move(0, Move.EDirection.COLUMN_UP));

        TextDisplayer.display(puzzle);

        puzzle.execute(new Move(1, Move.EDirection.ROW_RIGHT));

        TextDisplayer.display(puzzle);

    }
}
