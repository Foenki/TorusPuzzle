package TorusPuzzle;

import java.util.Vector;

public class MoveSequence {

    private Vector<Move> moves;

    public MoveSequence()
    {
        this.moves = new Vector<Move>();
    }

    public String toString()
    {
        String s = new String("[");
        for(int i = 0; i < length(); ++i)
        {
            s += getMove(i).toString() + (i < length()-1 ? " " : "");
        }
        s += "]";
        return s;
    }

    public void add(Move move)
    {
        moves.add(move);
    }

    public void add(MoveSequence sequence)
    {
        for(int i = 0; i < sequence.length(); ++i)
        {
            add(sequence.getMove(i));
        }
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
