package MaxArraySum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxArraySum {
    static boolean checkIndexes(List<Integer> usedIndexes, int index) {
        for (Integer usedIndex : usedIndexes) {
            if (Math.abs(usedIndex - index) < 2)
                return false;
        }
        return true;
    }

    public static int maxSubsetSum(List<Integer> arr) {
        IndexedValue[] indexedArray = new IndexedValue[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            indexedArray[i] = new IndexedValue(arr.get(i), i);
        }

        Arrays.sort(indexedArray, new Comparator<IndexedValue>() {
            @Override
            public int compare(IndexedValue o1, IndexedValue o2) {
                return Integer.compare(o2.value(), o1.value());
            }
        });
        List<Integer> usedIndexes = new ArrayList<>();
        int maxSum = 0;
        int number = indexedArray[0].value();
        int index;
        int i = 0;
        while (number > 0 && i < indexedArray.length) {
            number = indexedArray[i].value();
            index = indexedArray[i].index();
            if (checkIndexes(usedIndexes, index)) {
                maxSum += number;
                usedIndexes.add(index);
            }
            i++;


        }

        return maxSum;
    }
}
