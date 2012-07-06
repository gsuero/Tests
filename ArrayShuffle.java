
/**
 *
 * @author Garis M. Suero
 */
public class ArrayShuffle {

    public static String[] shuffleArray(String[] value) {
        if (value == null) {
            return null;
        }

        int length = value.length - 1;
        String[] newArray = new String[value.length];
        for (int a = 0; a < value.length; a++) {
            newArray[length--] = value[a];
        }
        return newArray;
    }
    
    public static void main(String[] args) {
        String[] values = {"test", "amazon", "interview", "oh!"};
        System.out.println(shuffleArray(values));
    }
    
}
