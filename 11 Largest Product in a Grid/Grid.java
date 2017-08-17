public class Grid {
    private int[][] grid;

    public Grid(int [][] grid) {
        this.grid = grid;
    }

    public int getMaxProduct() {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (getDiagonalProduct(i, j) > max) {
                    max = getDiagonalProduct(i, j);
                }
                if (getVertikalProduct(i, j) > max) {
                    max = getVertikalProduct(i, j);
                }
                if (getHorizontalProduct(i, j) > max) {
                    max = getHorizontalProduct(i, j);
                }
                if (getDiagonalProductBackwards(i, j) > max) {
                    max = getDiagonalProductBackwards(i, j);
                }
            }
        }

        return max;
    }

    private int getDiagonalProduct(int i, int j) {
        try {
            int prod = 1;
            for (int k = 0; k < 4; k++) {
                prod *= grid[i+k][j+k];
            }
            return prod;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    private int getDiagonalProductBackwards(int i, int j) {
        try {
            int prod = 1;
            for (int k = 0; k < 4; k++) {
                prod *= grid[i+k][j-k];
            }
            return prod;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    private int getVertikalProduct(int i, int j) {
        try {
            int prod = 1;
            for (int k = 0; k < 4; k++) {
                prod *= grid[i+k][j];
            }
            return prod;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    private int getHorizontalProduct(int i, int j) {
        try {
            int prod = 1;
            for (int k = 0; k < 4; k++) {
                prod *= grid[i][j+k];
            }
            return prod;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i= 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] /10 < 1) {
                    str += "  " + grid[i][j];
                } else {
                    str += " "+grid[i][j];
                }
            }
            str+= "\n";
        }
        return str;
    }
}