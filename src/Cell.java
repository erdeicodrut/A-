enum state{
    WALL,
    ROAD
}

public class Cell {
    int val;
    int x, y;
    state content;
    Cell prev;
    public Cell(int x,int y) {
        this.x = x;
        this.y = y;
        this.content = state.ROAD;
    }

    public static int getDist(int destinationX, int destinationY, int x, int y) {
        return (int) Math.sqrt((double) (Math.abs((destinationX- x)*(destinationX- x))+
                                        Math.abs((destinationY- y)*(destinationY- y))));
    }

    public void calculateVal() {
        val = this.content == state.ROAD ? getDist(Main.wantedX, Main.wantedY, x, y) : 9;
    }
}
