package TorusPuzzle;

import java.util.Vector;

public class MoveSequence {

    private Vector<Move> moves;

    public MoveSequence()
    {
        this.moves = new Vector<Move>();
    }

    public void add(Move move)
    {
        moves.add(move);
    }

    public int length()
    {
        return moves.size();
    }

    public Move getMove(int idx)
    {
        assert(idx < length());
        return moves.get(idx);
    }

    public MoveSequence reverseSequence()
    {
        MoveSequence sequence = new MoveSequence();

        for(int i = moves.size()-1; i >= 0; --i)
            {
            sequence.add(getMove(i).reverseMove());
        }

        return sequence;
    }
}
