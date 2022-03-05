import java.util.Arrays;
public class DoNow {
    public static void main(String[] args) {
        int[][] t1 = {{1, 2, 5}, {3, 4, 6}};
        System.out.println("Test 1- Input: ");
        for (int[] row: t1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Expected: false, Result: " + hasDup(t1));
        int[][] t2 = {{1, 2, 3}, {1, 2, 4}};
        System.out.println("Test 2- Input: ");
        for (int[] row: t2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Expected: true, Result: " + hasDup(t2));
        int[][] t3 = {{1, 2, 3, 4}, {4, 3, 2, 1}};
        System.out.println("Test 3- Input: ");
        for (int[] row: t3) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Expected: false, Result: " + hasDup(t3));
        int[][] t4 = {{0, 2, 3}, {1, 2, 8}};
        System.out.println("Test 4- Input: ");
        for (int[] row: t4) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Expected: true, Result: " + hasDup(t4));
        int[][] t5 = {{1, 3, 6}, {2, 4, 7}, {1, 5, 8}}; //BOARD
        System.out.println("Test 5- Input: ");
        for (int[] row: t5) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Expected: true, Result: " + hasDup(t5));
    }
    private static boolean hasDup(int[][] base) {
        String[] columns = new String[base[0].length];
        for (int row = 0; row != base.length; row++) {
            for (int col = 0; col != base[row].length; col++) {
                int num = base[row][col];
                if (columns[col] != null) {
                    if (columns[col].indexOf(num + "") != -1) {
                        return true;
                    }
                }
                columns[col] += num;
            }
        }
        return false;
    }
}
