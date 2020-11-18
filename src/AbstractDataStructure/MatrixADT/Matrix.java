package AbstractDataStructure.MatrixADT;

import javax.naming.SizeLimitExceededException;

public class Matrix {

    /**
     * Constructor, create a matrix with n rows m column, filled by 0
     * @param n number of rows. REQUIRE n > 0
     * @param m number of column. REQUIRE m > 0
     * @throws IllegalArgumentException if n or m are < 0
     * n or m can't be 0 at the same time, but one can be 0 if the other is != 0,
     * in that case the constructor will return a matrix with 1 row or 1 column.
     */
    public Matrix (int n, int m) throws IllegalArgumentException {

    }

    /**
     * Constructor, create a matrix with n rows m column, filled by elements of a.
     * The matrix will be filled by rows, repeating elements from a
     * @param n number of rows. REQUIRE n > 0
     * @param m number of column. REQUIRE m > 0
     * @param a the array of elements to use for filling the matrix
     * @throws IllegalArgumentException if n <= 0
     * @throws SizeLimitExceededException if n < a.length
     */
    public Matrix (int n, int m, float[] a) throws IllegalArgumentException, SizeLimitExceededException {

    }

    /**
     * Method to insert x in the matrix in [i][j], MODIFY the matrix
     * @param i index of the row
     * @param j index of the column
     * @param x key to insert
     * @throws IllegalArgumentException if i or j are out of bound
     */
    public void insert (int i, int j, float x) throws IllegalArgumentException {

    }
}
