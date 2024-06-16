package Sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 6, 3, 1, 7, 8, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("��������");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = cut(arr, left, right); // �����黮��Ϊ�����֣������ػ��ֵ������

            quickSort(arr, left, partitionIndex - 1); // �ݹ�������������
            quickSort(arr, partitionIndex + 1, right); // �ݹ�������������
        }
    }

    // ���ֺ���,Ŀ���Ƕ���һ��ָ������indexΪleft��right��Χ������
    // ͨ����������任Ϊ���ڻ�׼arr[right]��arr[right]��ߵ����ݶ�����С��arr[right]�ұߵ����ݶ�������
//    ������base������
    public static int cut(int[] arr, int left, int right) {
//        ��׼ֵ��һ��Ҫ�ȱ�����������Ȼ���潻��Ԫ�ػ��
        int base = arr[right];
//        i��¼���ǻ�׼ֵ����λ�ã���ʼֵΪleft
        int baseFinalIndex = left;
//        ����߿�ʼ���������һ��Ԫ��ǰһ������ʱ�������һ��
        for (int j = left; j < right; j++) {
            if (arr[j] <= base) {
//                baseFinalIndex��Ϊһ�����˵�ָ�룬������ǰ����б�baseС�Ľ�����ָ���λ��
                swap(arr,baseFinalIndex, j); // ������СԪ���뵱ǰԪ��
//                ��¼��׼ֵ��index
                baseFinalIndex++;
            }
        }
//        forѭ����ɺ��Ѿ�����ȷ��baseFinalIndexָ��һ�������Ԫ�ض���baseС��+1��λ�ã����ʱ����԰����һ��Ԫ�ؽ���������
        swap(arr,baseFinalIndex, right);
//        ���ؽ������׼�������
        return baseFinalIndex;
    }

//    ����һ��Ҫ����д������ֱ�Ӱ�ֵ������
    public static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


