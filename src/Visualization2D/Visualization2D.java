package Visualization2D;

import TorusPuzzle.TorusPuzzle;

public class Visualization2D
{
    public static void main(String[] args)
    {
        TorusPuzzle puzzle = new TorusPuzzle(12,3);
        Window2D window = new Window2D(puzzle);
    }
}
