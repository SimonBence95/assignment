package hu.nye.progtech.foxandhounds.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

    public List<Integer> collectNonZeroValues(List<Integer> integerList) {
        List<Integer> result = new ArrayList<>();

        for (int value : integerList) {
            if (value != 0) {
                result.add(value);
            }
        }

        return result;
    }

    public boolean containsOnlyDistinctValues(List<Integer> integerList) {
        Set<Integer> distinctValues = Set.copyOf(integerList);
        return integerList.size() == distinctValues.size();
    }

}
