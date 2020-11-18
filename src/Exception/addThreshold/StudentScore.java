package Exception.addThreshold;
import java.util.Arrays;

public class StudentScore {

    public static void main(String[] args) throws TrespassedThresholdException {
        int[] arr = {18,20,19,25,16,21};

        try {
            MyArrays.addWithThreshold(arr,5,30);
        } catch (TrespassedThresholdException tte) {
            System.err.print("Exceeded from the threshold (30)");
        } finally {
            System.out.println(Arrays.toString(arr));
        }
    }
}
