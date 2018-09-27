package TorusPuzzle;

public class Move {

    enum EDirection
    {
        ROW_LEFT,
        ROW_RIGHT,
        COLUMN_UP,
        COLUMN_DOWN
    };

    EDirection direction;
    int lineIdx;

    public Move(int lineIdx, EDirection direction)
    {
        this.direction = direction;
        this.lineIdx = lineIdx;
    }

    public Move reverseMove()
    {
        EDirection d = EDirection.ROW_LEFT;
        switch(this.direction)
        {
            case ROW_LEFT:
                d = EDirection.ROW_RIGHT;
                break;
            case ROW_RIGHT:
                d = EDirection.ROW_LEFT;
                break;
            case COLUMN_UP:
                d = EDirection.COLUMN_DOWN;
                break;
            case COLUMN_DOWN:
                d = EDirection.COLUMN_UP;
                break;
            default:
                assert(false);
                break;
        }

        return new Move(this.lineIdx, d);
    }
}
