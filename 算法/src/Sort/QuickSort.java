package Sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 6, 3, 1, 7, 8, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = cut(arr, left, right); // 将数组划分为两部分，并返回划分点的索引

            quickSort(arr, left, partitionIndex - 1); // 递归排序左子数组
            quickSort(arr, partitionIndex + 1, right); // 递归排序右子数组
        }
    }

    // 划分函数,目标是对于一个指定左右index为left和right范围的数据
    // 通过交换将其变换为对于基准arr[right]，arr[right]左边的数据都比它小，arr[right]右边的数据都比它大
//    并返回base的索引
    public static int cut(int[] arr, int left, int right) {
//        基准值，一定要先保存下来，不然后面交换元素会变
        int base = arr[right];
//        i记录的是基准值最后的位置，初始值为left
        int baseFinalIndex = left;
//        从左边开始遍历到最后一个元素前一个，暂时不动最后一个
        for (int j = left; j < right; j++) {
            if (arr[j] <= base) {
//                baseFinalIndex作为一个搬运的指针，任务就是把所有比base小的交换到指针的位置
                swap(arr,baseFinalIndex, j); // 交换较小元素与当前元素
//                记录基准值的index
                baseFinalIndex++;
            }
        }
//        for循环完成后已经可以确保baseFinalIndex指向一个【左边元素都比base小】+1的位置，这个时候可以把最后一个元素交换过来了
        swap(arr,baseFinalIndex, right);
//        返回交换后基准点的索引
        return baseFinalIndex;
    }

//    这里一定要这样写，不能直接把值传进来
    public static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


