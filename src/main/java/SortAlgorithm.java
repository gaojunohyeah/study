import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 * Title:排序算法
 * </p>
 * Description:
 * <p>
 *
 * @author jerry
 * @version Date: 2019/2/25
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = {323, 4534, 234, 43, 3, 234, 943, 5272, 8642, 3242};

        for (int b : a) {
            System.out.printf(" " + b);
        }

        System.out.println();

        for (int b : radixSort(a)) {
            System.out.printf(" " + b);
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; i++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }

        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (temp > array[j]) {
                    temp = array[j];
                    index = j;
                }
            }

            array[index] = array[i];
            array[i] = temp;
        }

        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int idx = i;
            while (idx >= 0 && current < array[idx]) {
                System.out.println("idx = " + idx);
                array[idx + 1] = array[idx];
                idx--;
            }
            array[idx + 1] = current;
        }

        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int gap = array.length / 2;
        int temp;
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < array.length - gap; j = j + gap) {
                    temp = array[j + gap];
                    int idx = j;
                    while (idx >= 0 && temp < array[idx]) {
                        array[idx + gap] = array[idx];
                        idx -= gap;
                    }
                    array[idx + gap] = temp;
                }
            }

//            for (int x = 0; x < gap; x++) {
//                System.out.println("x = " + x);
//                for (int i = x + gap; i < array.length; i = i + gap) {
//                    System.out.println("i = " + i);
//                    temp = array[i];
//                    int j;
//                    for (j = i - gap; j >= 0 && array[j] > temp; j = j - gap) {
//                        System.out.println("j = " + j);
//                        array[j + gap] = array[j];
//                    }
//                    array[j + gap] = temp;
//                }
//            }

//            for (int i = gap; i < array.length; i++) {
//                System.out.println("i = " + i);
//                temp = array[i];
//                int preIndex = i - gap;
//                System.out.println("preindex + " + preIndex);
//                while (preIndex >= 0 && array[preIndex] > temp) {
//                    System.out.println("preindex + " + preIndex);
//                    array[preIndex + gap] = array[preIndex];
//                    preIndex -= gap;
//                }
//                array[preIndex + gap] = temp;
//            }

            gap /= 2;
        }

        return array;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int[] arrayA = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] arrayB = Arrays.copyOfRange(array, array.length / 2, array.length);

        return merge(mergeSort(arrayA), mergeSort(arrayB));
    }

    /**
     * 归并排序 合并两个有序数组为一个有序数组
     *
     * @param arrayA
     * @param arrayB
     * @return
     */
    private static int[] merge(int[] arrayA, int[] arrayB) {
        int[] array = new int[arrayA.length + arrayB.length];

        int aIdx = 0;
        int bIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (aIdx < arrayA.length && bIdx < arrayB.length) {
                if (arrayA[aIdx] <= arrayB[bIdx]) {
                    array[i] = arrayA[aIdx++];
                } else {
                    array[i] = arrayB[bIdx++];
                }
            } else if (aIdx < arrayA.length) {
                array[i] = arrayA[aIdx++];
            } else if (bIdx < arrayB.length) {
                array[i] = arrayB[bIdx++];
            }
        }

        return array;
    }

    /**
     * 快速排序
     *
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 2) {
            return array;
        }

        int index = partition(array, start, end);

        if (index > start) {
            quickSort(array, start, index - 1);
        }

        if (index < end) {
            quickSort(array, index + 1, end);
        }

        return array;
    }

    /**
     * 快速排序 分治
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
//        int rnd = (int) (start + Math.random() * (end - start + 1));
//        swap(array, rnd, start);
//        int index = start;
//        int i = start;
//        int j = end;
//
//        while (i < j){
//            while(j > index){
//                if (array[j] < array[index]){
//                    swap(array, j, index);
//                    index = j;
//                    break;
//                }
//                j--;
//            }
//
//            while(i < index){
//                if (array[i] > array[index]){
//                    swap(array, i, index);
//                    index = i;
//                    break;
//                }
//                i++;
//            }
//        }
//
//        return index;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    public static int[] heapSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        buildMaxHeap(array);
        int current = array.length - 1;
        while (current > 0) {
            swap(array, 0, current);
            current--;
            adjustHeap(array, 0, current);
        }

        return array;
    }

    /**
     * 构建大顶堆
     *
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        int lastLeaf = array.length / 2 - 1;
        for (int i = lastLeaf; i >= 0; i--) {
            adjustHeap(array, i, array.length - 1);
        }
    }

    /**
     * 堆适应，调整结构以符合大顶堆
     *
     * @param array
     * @param i
     */
    private static void adjustHeap(int[] array, int i, int end) {
        int maxIndex = i;
        int leftLeaf = 2 * i + 1;
        int rightLeaf = 2 * i + 2;

        // 左叶子
        if (leftLeaf <= end && array[leftLeaf] > array[maxIndex]) {
            maxIndex = leftLeaf;
        }
        // 右叶子
        if (rightLeaf <= end && array[rightLeaf] > array[maxIndex]) {
            maxIndex = rightLeaf;
        }

        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex, end);
        }
    }

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int min = array[0];
        int max = array[0];
        for (int n : array) {
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }

        int[] C = new int[max - min + 1];
        Arrays.fill(C, 0);
        for (int n : array) {
            C[n - min]++;
        }

        int j = 0;
        for (int i = 0; i < C.length; i++) {
            while (C[i] > 0) {
                array[j] = i + min;
                j++;
                C[i]--;
            }
        }

        return array;
    }

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static int[] bucketSort(int[] array, int bucketSize) {
        if (array.length < 2) {
            return array;
        }

        Integer[] array1 = ArrayUtils.toObject(array);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array1));
        list = bucket(list, bucketSize);

        Integer[] a = list.toArray(new Integer[list.size()]);

        return ArrayUtils.toPrimitive(a);
    }

    /**
     * 桶排序-递归方法
     *
     * @param list
     * @param bucketSize
     * @return
     */
    private static ArrayList<Integer> bucket(ArrayList<Integer> list, int bucketSize) {
        if (list == null || list.size() < 2) {
            return list;
        }

        int min = list.get(0);
        int max = list.get(0);
        for (int n : list) {
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }

        if (max == min ){
            return list;
        }

        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buclist = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buclist.add(new ArrayList<>());
        }
        for (int n : list) {
            buclist.get((n - min) / bucketSize).add(n);
        }

        ArrayList<Integer> reArray = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            if (bucketCount == 1)
                bucketSize--;
            ArrayList<Integer> l = bucket(buclist.get(i), bucketSize);
            reArray.addAll(l);
        }

        return reArray;
    }

    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array){
        if(array.length < 2){
            return array;
        }

        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j : array) {
                int num = (j % mod) / div;
                bucketList.get(num).add(j);
            }
            int index = 0;
            for (ArrayList<Integer> j : bucketList) {
                for (int k : j)
                    array[index++] = k;
                j.clear();
            }
        }
        return array;
    }
}
