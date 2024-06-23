package sort;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2024/6/17
 * 排序总结
 */
public class Sort {
    private final static int[] array = {1, 2, 5, 6, -5, 10, 20, 6, 2, 8, 9, 2, 11};

    public static void main(String[] args) {
//        bubbling(array);
//        pick(array);
        insert(array);
        System.out.println(binarySearch(array, 10));
    }

    //冒泡 在于两两比较,
    public static void bubbling(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //选择 将数组看成两个子数组，已排序和未排序的，在未排序的数组中选择一个最小的 并放入已排序中
    public static void pick(int[] array) {
        int length = array.length - 1;

        for (int i = 0; i < length; i++) {
            for (int j = i; j <= length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*插入排序，将数组分成两个区域，已排序和未排序，每次将未排序中的元素放在已排序数组中并排序，遍历完整个数组就是排序好的
    例如 要排序的是i,那么要要对比 i~0位置的元素的大小，将这个有序数组再次有序，之后再选择i；
     */
    public static void insert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    System.out.printf("%d 交换 %d\n", array[j], array[j - 1]);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    二分查找的基础是在已排序的数组中折中对半查找
     */
    public static int binarySearch(int[] array, int num) {
        int right = array.length - 1;
        int left = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (num == array[middle]) {
                return middle;
            } else if (num < array[middle]) {
                right = middle - 1;
            } else if (num > array[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

}
