package Exception.Matrici;

public class Matrices {

    /**
     * Method to transpose a matrix
     * @param m the matrix to be transposed
     * @return the transposed matrix
     * @throws InvalidMatrixException when the matrix is empty
     */
    public static float[][] matrixTranspose (float[][] m) throws InvalidMatrixException {
        float[][] transposed;
        if (m.length ==  1 && m[0].length == 1) {
            transposed = m;
        }else if (m.length >  1 || m[1].length > 1) {
            transposed = transpose(m);
        }else {
            throw new InvalidMatrixException("Matrix should contain at least 1 element");
        }
        return transposed;
    }


    /**
     * Method to transpose a matrix, so an element (i, j) => (j, i)
     * @param m the matrix to be transposed
     * @return the transposed matrix
     */
    public static float[][] transpose (float[][] m) {
        int rowSize = m.length;
        int colSize = m[1].length;
        float[][] transposed = new float[colSize][rowSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                transposed[j][i] = m[i][j];
            }
        }
        return transposed;
    }

    public static float[][] multiplyMatrix(float[][] m1, float[][] m2) throws Exception {
        int numOfCol = m1[1].length;
        float[][] result = new float[m1.length][m2[1].length];
        if ( numOfCol == m2.length) {
            result = multiply(m1, m2);
        }else {
            throw new InvalidMatrixException("Wrong dimension");
        }
        return result;
    }

    private static float[][] multiply(float[][] m1, float[][] m2) {
        int rowM1 = m1.length;
        int colM2 = m2[1].length;
        int rowM2 = m2.length;
        float[][] result = new float[rowM1][colM2];
        for (int i = 0; i < rowM1; i++) {
            for (int j = 0; j < colM2; j++) {
                for (int k = 0; k < rowM2; k++)
                    result[i][j] += m1[i][k] * m2[k][j];
            }
        }
        return result;
    }

    /**
     * Method used to print the matrix
     * @param m the matrix to print
     */
    private static void printMatrix(float[][] m) {
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++) {
                System.out.println(m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        float[][] arr1 = { { 1,2,3,4},{11,12,13,14}, {21,22,23,24}};
        float[][] arr2 = { { 1,1},{2,2},{3,3},{0,0}};
        float[][] arr3 = { {1,1}, {2,2}};
        float[][] arr4 = { {1} };

        float[][] res = transpose(arr1);
        printMatrix(res);
        float[][] result = multiplyMatrix(arr1, arr3);
        printMatrix(result);
        float[][] r = matrixTranspose(arr4);
        printMatrix(r);
    }
}
