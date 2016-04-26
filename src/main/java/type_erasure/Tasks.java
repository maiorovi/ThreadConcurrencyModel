package type_erasure;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Tasks {

    //Write a generic method to count the number of elements in a collection that have a
    // specific property (for example, odd integers, prime numbers, palindromes).

    public <T> int findMatch(Collection<? extends T> collection, Predicate<T> condition) {
        return (int) collection.stream().filter(condition).count();
    }


    //Write a generic method to exchange the positions of two different elements in an array.
    public <T> T[] swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        return array;
    }

//  Q: Will the following method compile? If not, why? A: Will compile as this method implemented correctly
    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    // Q: What is the following method converted to after type erasure?
    public static <T extends Comparable<T>> int findFirstGreaterThan(T[] at, T elem) {
        // ...
        return 0;
    }

    //A: It will be converted to:
//    public static int findFirstGreaterThan(Comparable[] at, Object elem) {
//        return 0;
//    }

}
