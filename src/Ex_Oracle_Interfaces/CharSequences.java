package Ex_Oracle_Interfaces;

public class CharSequences implements CharSequence{
    /** MISSION
     * Provide an implementation for CharSequence interface
     * Given a String object, it returns the reversed String
     */
    private String s;

    /** CONSTRUCTOR */
    public CharSequences(String s) {
        this.s = s;
    }

    /**auxiliary method to return the index from the end */
    private int fromEnd(int i) {
        return s.length() - 1 - i;
    }

    @Override
    /**
     * return the char at given index, starting from the end
     */
    public char charAt(int index) {
        if (index < 0 || index >= s.length())
            throw new StringIndexOutOfBoundsException();
        return s.charAt(fromEnd(index));
    }

    @Override
    /** return the length of the string */
    public int length() {
        return s.length();
    }

    @Override
    /** return the subsequence starting from start to end, but in reversed order */
    public CharSequence subSequence(int start, int end) {
        if (start < 0)
            throw new StringIndexOutOfBoundsException();
        if (end > s.length())
            throw new StringIndexOutOfBoundsException();
        if (start > end)
            throw new StringIndexOutOfBoundsException();

        StringBuilder sb = new StringBuilder(s.subSequence(fromEnd(end), fromEnd(start)));
        return sb.reverse();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        CharSequences cs = new CharSequences("Write a class that implements the CharSequence interface found in the java.lang package.");

        /** test for charAt and length */
        for (int i = 0; i < cs.length(); i++) {
            System.out.print(cs.charAt(i));

        }
        System.out.println();

        /** test for subsequence and length */
        int start = (int) Math.round(Math.random() * (cs.length() - 1));
        int end = (int) Math.round(Math.random() * (cs.length() - 1 - start) + start);
        System.out.print(cs.subSequence(start, end));

    }
}
