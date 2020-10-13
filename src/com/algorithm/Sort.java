package com.algorithm;

import java.util.Arrays;

/**
 * @author wgz
 * @description
 * @date 2020/10/13 10:44
 */
public class Sort {

    /**
     * 二分法查找
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组 升序且不重复数组
     * @param key int整型 查找值
     * @return int
     */
    public static int dichotomy(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序
     * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3、针对所有的元素重复以上的步骤，除了最后一个；
     * 4、重复步骤1~3，直到排序完成。
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @return int[]
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @return int[]
     */
    public static int[] selectionSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //找到最小的数
                if (arr[j] < arr[minIndex]) {
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 插入排序
     * 1、从第一个元素开始，该元素可以认为已经被排序；
     * 2、取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3、如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5、将新元素插入到该位置后；
     * 6、重复步骤2~5。
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @return int[]
     */
    public static int[] insertionSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 希尔排序
     * 分块儿进行的插入排序
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @return int[]
     */
    public static int[] ShellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }

    /**
     * 归并排序
     * 1、把长度为n的输入序列分成两个长度为n/2的子序列；
     * 2、对这两个子序列分别采用归并排序；
     * 3、将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @return int[]
     */
    public static int[] MergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序
     * 将两段排序好的数组结合成一个排序数组
     *
     * @author wgz
     * @date 2020/10/13
     * @param left int整型一维数组
     * @param right int整型一维数组
     * @return int[]
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序方法
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @param start 外部调用时，传入数组第一位索引0
     * @param end 外部调用时，传入数组最后一位索引arr.length - 1
     * @return int[]
     */

    public static int[] QuickSort(int[] arr, int start, int end) {
        if (arr.length < 1 || start < 0 || end >= arr.length || start > end) {
            return null;
        }
        int smallIndex = partition(arr, start, end);
        if (smallIndex > start) {
            QuickSort(arr, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(arr, smallIndex + 1, end);
        }
        return arr;
    }
    /**
     * 快速排序算法——partition
     * 1、从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @param start 开始索引
     * @param end 结束索引
     * @return int
     */
    public static int partition(int[] arr, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(arr, pivot, end);
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(arr, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @author wgz
     * @date 2020/10/13
     * @param arr int整型一维数组
     * @param i 索引
     * @param j 索引
     */

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 声明全局变量，用于记录数组array的长度；
     */
    private static int len;

    /**
     * 堆排序算法
     * @author wgz
     * @date 2020/10/13
     * @param array int整型一维数组
     * @return int[]
     */
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) {
            return array;
        }
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     * @author wgz
     * @date 2020/10/13
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    /**
     * 调整使之成为最大堆
     * @author wgz
     * @date 2020/10/13
     * @param arr
     * @param i
     */
    public static void adjustHeap(int[] arr, int i) {
        int maxIndex = i;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && arr[i * 2] > arr[maxIndex]) {
            maxIndex = i * 2;
        }
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(arr, maxIndex, i);
            adjustHeap(arr, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 9, 4, 2, 15, 6, 3, 2, 8 };
//        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(QuickSort(arr, 0, arr.length - 1)));
    }
}
