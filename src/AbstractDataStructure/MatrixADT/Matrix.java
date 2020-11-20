package AbstractDataStructure.MatrixADT;

import javax.naming.SizeLimitExceededException;
import java.util.Arrays;


public class Matrix {

    float[][] matrix;

    /**
     * Constructor, create a matrix with n rows m column, filled by 0
     * @param n number of rows. REQUIRE n > 0
     * @param m number of column. REQUIRE m > 0
     * @throws IllegalArgumentException if n or m are < 0
     * n or m can't be 0 at the same time, but one can be 0 if the other is != 0,
     * in that case the constructor will return a matrix with 1 row or 1 column.
     */
    public Matrix (int n, int m) throws IllegalArgumentException {
        if (n < 0 && m < 0) {
            throw new IllegalArgumentException();
        }
        matrix = new float[n][m];
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }
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
        if (n < 0 && m < 0) {
            throw new IllegalArgumentException();
        }
        float[][] matrix = new float[n][m];
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = a[col];
            }
        }
    }

    /**
     * Method to insert x in the matrix in [i][j], MODIFY the matrix
     * @param i index of the row
     * @param j index of the column
     * @param x key to insert
     * @throws IllegalArgumentException if i or j are out of bound
     */
    public void insert (int i, int j, float x) throws IllegalArgumentException {
        try {
            matrix[i][j] = x;
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            throw new ArrayIndexOutOfBoundsException("the index inserted is out of bound");
        }
    }

    /**
     * Method to multiply 2 matrices, return a new one
     * @param m1 first matrix
     * @param m2 second matrix
     * @return a new matrix m3 that is the result of m1 * m2
     * @throws InvalidMatrixDimension if the numbers of column of m1 != number of rows of m2
     */
//    public Matrix multiply (Matrix m1, Matrix m2) throws InvalidMatrixDimension {
//
//    }

    /**
     * Method to transpose a matrix so the rows and column gets swapped
     * @param m the matrix to be transposed
     */
    public void transpose (Matrix m) {

    }

    /**
     * Method to sum 2 matrices
     * @param m1 first matrix
     * @param m2 second matrix
     * @return a new matrix m3 that is the sum m1 and m2 for every single cells
     * @throws InvalidMatrixDimension if the numbers of column of m1 != number of rows of m2
     */
//    public Matrix add (Matrix m1, Matrix m2) throws InvalidMatrixDimension {
//
//    }

    /**
     * Method to multiply every elements of m by x
     * @param x the terms to multiply
     * @param m the matrix to apply the scalar product
     */
    public void scalarProduct (int x, Matrix m) {

    }

//    public void extractVector( , int i) {
//
//    }

    /**
     * Method to print the matrix
     */
    public void print () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 5);
        m.insert(1,1,1.2f);
        m.print();
    }
}
