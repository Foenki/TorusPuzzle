package TorusPuzzle;

import java.util.Arrays;

public class TorusPuzzle
{
    private int[][] values;

    public TorusPuzzle(int rowDim, int colDim)
    {
        assert (rowDim > 0);
        assert (colDim > 0);
        this.values = new int[rowDim][colDim];

        for (int i = 0; i < rowDim; ++i)
            for (int j = 0; j < colDim; ++j)
                this.values[i][j] = 1 + i * colDim + j;
    }

    public String toString()
    {
        String s = new String();
        for(int i = 0; i < rowDim(); ++i)
        {
            s += "[";
            for(int j = 0; j < colDim(); ++j)
            {
                s += getValue(i, j) + (j < colDim()-1 ? "," : "");
            }
            s += "]\n";
        }

       return s;
    }

    public int getValue(int i, int j)
    {
        assert (i < rowDim());
        assert (j < colDim());
        return values[i][j];
    }

    public int rowDim()
    {
        return values.length;
    }

    public int colDim()
    {
        return values[0].length;
    }

    public int maxValue()
    {
        return rowDim() * colDim();
    }

    public void shuffle()
    {
        shuffle(100000);
    }

    public void shuffle(int nbMoves)
    {
        for (int i = 0; i < nbMoves; ++i)
        {
            execute(randomMove());
        }
    }

    public void shuffle(int nbMoves, MoveSequence outputSequence)
    {
        for (int i = 0; i < nbMoves; ++i)
        {
            outputSequence.add(randomMove());
        }

        execute(outputSequence);
    }

    public void execute(MoveSequence moveSequence)
    {
        for (int i = 0; i < moveSequence.length(); ++i)
            execute(moveSequence.getMove(i));
    }

    public void execute(Move move)
    {
        switch (move.direction)
        {
            case ROW_LEFT:
                moveRowLeft(move.lineIdx);
                break;
            case ROW_RIGHT:
                moveRowRight(move.lineIdx);
                break;
            case COLUMN_UP:
                moveColumnUp(move.lineIdx);
                break;
            case COLUMN_DOWN:
                moveColumnDown(move.lineIdx);
                break;
            default:
                break;
        }
    }

    private void moveRowLeft(int idx)
    {
        assert (idx < rowDim());
        int shiftedValue = values[idx][0];

        for (int j = 0; j < colDim() - 1; ++j)
        {
            values[idx][j] = values[idx][j + 1];
        }

        values[idx][colDim() - 1] = shiftedValue;
    }

    private void moveRowRight(int idx)
    {
        assert (idx < rowDim());
        int shiftedValue = values[idx][colDim() - 1];

        for (int j = colDim() - 1; j > 0; --j)
        {
            values[idx][j] = values[idx][j - 1];
        }

        values[idx][0] = shiftedValue;
    }

    private void moveColumnUp(int idx)
    {
        assert (idx < colDim());
        int shiftedValue = values[0][idx];

        for (int i = 0; i < rowDim() - 1; ++i)
        {
            values[i][idx] = values[i + 1][idx];
        }

        values[rowDim() - 1][idx] = shiftedValue;
    }

    private void moveColumnDown(int idx)
    {
        assert (idx < colDim());
        int shiftedValue = values[rowDim() - 1][idx];

        for (int i = rowDim() - 1; i > 0; --i)
        {
            values[i][idx] = values[i - 1][idx];
        }

        values[0][idx] = shiftedValue;
    }

    public Move randomMove()
    {
        Move.EDirection d = Move.EDirection.ROW_LEFT;
        int idx = 0;
        double rand = Math.random() * 4;
        if (rand < 1)
        {
            d = Move.EDirection.ROW_LEFT;
            idx = (int)(Math.random() * rowDim());
        }
        else if (rand < 2)
        {
            d = Move.EDirection.ROW_RIGHT;
            idx = (int)(Math.random() * rowDim());
        }
        else if (rand < 3)
        {
            d = Move.EDirection.COLUMN_DOWN;
            idx = (int)(Math.random() * colDim());
        }
        else if (rand < 4)
        {
            d = Move.EDirection.COLUMN_UP;
            idx = (int)(Math.random() * colDim());
        }

        return new Move(idx, d);
    }

}
