package TorusPuzzle;

public class TextDisplayer {

    public static void display(TorusPuzzle puzzle)
    {
        String s = new String();
        for(int i = 0; i < puzzle.rowDim(); ++i)
        {
            s += "[";
            for(int j = 0; j < puzzle.colDim(); ++j)
            {
                s += puzzle.getValue(i, j) + (j < puzzle.colDim()-1 ? "," : "");
            }
            s += "]\n";
        }

        System.out.println(s);
    }

    public static void display(Move move)
    {
        String s = new String();
        switch(move.direction)
        {
            case ROW_LEFT:
                s += "R" + move.lineIdx + "-";
                break;
            case ROW_RIGHT:
                s += "R" + move.lineIdx + "+";
                break;
            case COLUMN_UP:
                s += "C" + move.lineIdx + "-";
                break;
            case COLUMN_DOWN:
                s += "C" + move.lineIdx + "+";
                break;
        }
        System.out.print(s);
    }

    public static void display(MoveSequence sequence)
    {
        System.out.print("[");
        for(int i = 0; i < sequence.length(); ++i)
        {
            display(sequence.getMove(i));
            System.out.print(i < sequence.length()-1 ? " " : "");
        }
        System.out.println("]");
    }
}
