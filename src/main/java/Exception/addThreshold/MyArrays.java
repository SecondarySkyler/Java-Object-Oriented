package Exception.addThreshold;

public class MyArrays {

    /**
     * Method to increment every single element of a, by x, unless the result is bigger then b
     * @param a the array where to retrieve the element. MODIFY a so that a_post[i] = a[i] + x when a[i]+x <= b
     * @param x the value to add at every single element
     * @param b the threshold not to be exceeded
     * @throws TrespassedThresholdException when taken and element i of the array, i + x > 30 (b)
     */
    public static void addWithThreshold(int[] a, int x, int b) throws TrespassedThresholdException {

        for(int i = 0; i < a.length; i++) {
            if (a[i] + x <= b){
                a[i] = a[i] + x;
            }else
                throw new TrespassedThresholdException();
        }
    }
}
