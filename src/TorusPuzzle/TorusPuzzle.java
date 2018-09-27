package TorusPuzzle;

public class TorusPuzzle {

    private int[][] values;

    public TorusPuzzle(int rowDim, int colDim)
    {
        assert(rowDim > 0);
        assert(colDim > 0);
        this.values = new int[rowDim][colDim];

        for(int i = 0; i < colDim; ++i)
            for(int j = 0; j < rowDim; ++j)
                this.values[i][j] = i * colDim + j;
    }

    public int maxValue()
    {
        return values.length * values[0].length;
    }

    public void shuffle()
    {

    }

    public void execute(MoveSequence moveSequence)
    {
        for(int i = 0; i < moveSequence.length(); ++i)
            execute(moveSequence.getMove(i));
    }

    public void execute(Move move)
    {

    }

}
