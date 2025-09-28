package collections.sets;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {

        final List<Integer> listA = new ArrayList<>(List.of(1, 2, 2, 3, 4, 4, 5));
        final List<Integer> listB = new ArrayList<>(List.of(2, 2, 3, 5, 5, 6));
        Set<Integer> inter = intersectionUnique(new HashSet<>(listA), new HashSet<>(listB));
        List<Integer> interMult = intersectionMultiset(listA, listB);

        if (!inter.equals(Set.of(2, 3, 5))) {
            throw new RuntimeException("intersectionUnique expected {2, 3, 5} and was " + inter);
        } else if (!interMult.equals(List.of(2, 2, 3, 5))) {
            throw new RuntimeException("intersectionMultiset expected [2, 2, 3, 5] and was " + interMult);
        } else {
            System.out.println("IntersectionUnique: " + inter);
            System.out.println("IntersectionMultiset: " + interMult);
        }
    }

    static @NotNull Set<Integer> intersectionUnique(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    static @NotNull List<Integer> intersectionMultiset(List<Integer> a, List<Integer> b) {

        Collections.sort(a);
        Collections.sort(b);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).equals(b.get(j))) {
                result.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }

        }
        return result;
    }
}
