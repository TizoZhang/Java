
/**
 * 排序算法
 * 1.冒泡排序
 * 2.插入排序
 * 3.选择排序
 * 4.快速排序
 */

public class Sort {

    /*冒泡排序*/
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  //执行n-1次之后剩下一个元素不需要排序,只需要对前n-1个元素进行比较,即n个元素的数组总共有n-1个元素需要排序,从0下标执行到n-1下标结束
            for (int j = 0; j < arr.length - i - 1; j++) {  //每次循环结束,待排数组的最后一个元素为有序
                if (arr[j] > arr[j + 1]) {
                    swapArr(arr, j, j + 1);  //前一个元素比后一个元素大就进行交换
                }
            }
        }
    }

    /*插入排序*/
    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {  //默认第一个元素有序，从第二个元素向后依次进行插入排序
            if (arr[i - 1] > arr[i]) {   //如果之前的元素已经有序则不需要进行排序
                int temp = arr[i];  //把待排序的元素保存下来
                int k = i - 1;  //从待插入元素向左一位开始判断
                for (int j = k; (j >= 0) && (arr[j] > temp); j--) { //判断大小进行插入直到数组的下界为止
                    arr[j + 1] = arr[j];    //如果该位数比待排序的数大,就把该数赋值给待排序数的位置
                    k--;    //用于找到待插入元素的最后插入位置
                }
                arr[k + 1] = temp;  //在此处插入待排序元素
            }
        }
    }

    /*选择排序*/
    public static void select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  //执行n-1次之后所有元素已经有序
            int min = i;    //min用以记录待排数组中最小的元素
            for (int j = i + 1; j < arr.length; j++) {  //从第二个元素开始，比较与前一个元素大小
                if (arr[min] > arr[j]) {
                    min = j;    //记录较小元素的下标
                }
            }
            if (min != i) {
                swapArr(arr, min, i); //如果记录最小元素下标不是待排数组的第一个元素下标则交换位置
            }
        }
    }

    /*快速排序*/
    public static void quick(int[] arr, int left, int right) { //输入数组和左右边界
        if (left >= right) {    //递归时如果基准值某一边的元素为0或1个时结束当前递归
            return;
        }
        int pivot = arr[left];   //定义基准数
        int i = left; //定义左哨兵
        int j = right;    //定义右哨兵
        while (i < j) {    //重复交换
            while (pivot <= arr[j] && i < j) {
                j--;    //从右向左找到比基准数小的数,并把下标赋值给j
            }
            while (pivot >= arr[i] && i < j) {
                i++;    //从左向右找到比基准数大的数,并把下标赋值给i
            }
            if (i < j) {
                swapArr(arr, i, j);   //如果在两边找到相应的数，进行交换
            }
        }
        arr[left] = arr[i];   //在一次交换完成之后，把哨兵所在位置的值赋给原基准值所在位置(传入的左边界)
        arr[i] = pivot;   //把基准值赋给哨兵所在的位置
        quick(arr, left, i - 1);    //对基准值左边的数组进行递归排序
        quick(arr, i + 1, right);   //对基准值右边的数组进行递归排序
    }

    /*数组交换元素*/
    private static void swapArr(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
