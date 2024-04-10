public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i = 0; i < array2d[0].length; i++){
            sum += array2d[0][i];
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static int checknum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public static boolean magicRows(int[][] array2d, int checkSum) {
        for (int i = 0; i < array2d.length; i++){
            int check = checknum(array2d[i]);
            if (check != checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {

        int numRows = array2d.length;
        int numCols = array2d[0].length;

        for (int col = 0; col < numCols; col++) {
            int colSum = 0;
            for (int row = 0; row < numRows; row++) {
                colSum += array2d[row][col];
            }
            if (colSum != checkSum) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {

        int n = array2d.length;
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            firstDiagonalSum += array2d[i][i];
        }

        for (int i = 0; i < n; i++) {
            secondDiagonalSum += array2d[i][n - i - 1];
        }

        return firstDiagonalSum == checkSum && secondDiagonalSum == checkSum;

    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int sum = calculateCheckSum(array2d);
        if(magicRows(array2d, sum) == true && magicColumns(array2d, sum) == true && magicDiagonals(array2d, sum) ==true){
            return true;
        }
        return false;
    }

}
