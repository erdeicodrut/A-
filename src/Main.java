import java.util.Random;

public class Main {

    public static int size = 7, wantedX = size - 1, wantedY = size - 1;

    public static Cell[][] matrix = new Cell[size][size];

    static Cell fin;

    public static void main(String[] args) {

        int numberOfWalls = 10;

        form_terrain(wantedX, wantedY, matrix);

        build_walls(numberOfWalls, matrix);

        give_values();

        fin = Find.path_from(5, 5);

        Dprint_matrix(matrix);

    }

    private static void Dprint_matrix(Cell[][] matrix) {
        track();
        show_matrix_walls(matrix);
        show_matrix_vals(matrix);
    }

    private static void give_values() {
        for (Cell[] j : matrix) {
            for (Cell i : j) {
                i.calculateVal();
            }
        }
    }


    public static void build_walls(int numberOfWalls, Cell[][] matrix) {

        Random rand = new Random();

        for (int i = 0; i < numberOfWalls; i++) {
            int x = rand.nextInt(size - 1) + 1;
            int y = rand.nextInt(size - 1) + 1;

            matrix[x][y].content = state.WALL;
        }
    }


    private static void form_terrain(int wantedX, int wantedY, Cell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    private static void show_matrix_vals(Cell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].val == 9 ? "■ " : matrix[i][j].val + " ");
            }
            System.out.println();
        }
    }

    private static void show_matrix_walls(Cell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].content == state.WALL ? "■ " : "  ");
            }
            System.out.println();
        }
    }

    private static void track() {
        Cell f = fin;
        while (f.prev != null) {
            f.val = -1;
            f = f.prev;
        }
    }
}
