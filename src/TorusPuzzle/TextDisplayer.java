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
}
