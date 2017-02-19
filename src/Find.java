public class Find {

    static Cell path_from(int x, int y) {
        if (Main.matrix[x][y].val == 0) {
            return Main.matrix[x][y];
        } else /*if (Main.matrix[x][y].val < Main.size) */{
            Cell bn = best_neighbour(x, y);
            bn.prev = Main.matrix[x][y];
            bn.prev.val = 100;
            return path_from(bn.x, bn.y);
        }
        return Main.matrix[Main.wantedX][Main.wantedY];
    }



    public static Cell best_neighbour(int x, int y) {
        Cell up, down, left ,right;

        if (x < Main.matrix.length && y < Main.matrix.length && x > 0 && y > 0) {
            up = Main.matrix[x - 1][y];
            down = Main.matrix[x + 1][y];
            left = Main.matrix[x][y - 1];
            right = Main.matrix[x][y + 1];
        } else {
            up = null;
            down = null;
            left = null;
            right = null;
        }
        Cell[] dir = {up, down, left, right};
        Cell min = new Cell(0,0);
        min.val = 100;
        for (Cell curr : dir) {
            if (curr.val < min.val && state.WALL != curr.content && curr != null) {
                min = curr;
            }
        }
        return min;
    }
}