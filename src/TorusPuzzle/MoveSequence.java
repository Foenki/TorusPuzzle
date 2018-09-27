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
}
