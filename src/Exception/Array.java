package Exception;
import java.util.Arrays;

public class Array {

    /**
     * Method to search x in the array a
     * @param a the array where to search
     * @param x the int to search in the array
     * @return the position i so a[i] = x
     * @throws NullPointerException when a is null
     * @throws NotFoundException when x is not in a
     */
    public static int search(int[] a, int x) throws NullPointerException, NotFoundException {
        assert (a != null) : "array does not have elements";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
            else
                i++;
        }
        throw new NotFoundException("The element is not in the array");
    }

    /**
     * Method to search x when the given array a is sorted increasingly
     * @param a the array where to search
     * @param x the int to search in the array
     * @return the position i so a[i] = x
     * @throws NullPointerException when a is null
     * @throws NotFoundException when x is not in the array
     */
    public static int searchSorted(int[] a, int x) throws NullPointerException, NotFoundException {
        Arrays.sort(a);
        try {
            int e = search(a, x);
        } catch (NullPointerException npe) {
            System.err.print("Array is null");
        } catch (NotFoundException nfe) {
            System.err.print("The element is not in the array");
        }
        return search(a, x);
    }

    public static void main(String[] args) throws NotFoundException {
        int[] a = {12,34,16,56,78,23};
        int[] b = null;
        int x = 13;
        System.out.println(search(a, x));
        System.out.println(searchSorted(b, x));
    }
}
