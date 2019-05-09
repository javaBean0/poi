package sort;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/8
 **/
public class BubbleSort {

    //冒泡排序
    public static void sort1(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < source[i]) {
                    swap(source, j, i);
                }
            }
        }
    }

    //选择排序
    public static void sort2(int[] source) {
        for (int i = source.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (source[j] > source[i]) {
                    swap(source, j, i);
                }
            }
        }
    }

    //插入排序
    public static void sort3(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = i; j > 0 && source[j] < source[j - 1]; j--) {
                swap(source, j, j - 1);
                //continue;
            }
        }
    }

    //希尔排序

    //二分排序
    //看不太明白
    public static void sort4(int[] source) {
        int i, j;
        int low, high, mid;
        int temp;
        for (i = 1; i < source.length; i++) {
            temp = source[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (source[mid] > temp)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (j = i - 1; j > high; j--) {
                source[j + 1] = source[j];
            }
            source[high + 1] = temp;
        }

    }

    //快速排序

    public static void quickSort(int[] source, int low, int high) {
        int i, j, x;
        if(low <high){
            i = low;
            j = high;
            x = source[i];
            while (i<j){
                while(i<j && source[j] >x)
                    j--;

                if(i<j){
                    source[i] = source[j];
                    i++;
                }
                while (i<j && source[i] < x)
                    i++;
                if(i<j){
                    source[j] = source[i];
                    j--;
                }
            }
            source[i] =x;
            quickSort(source, low, i-1);
            quickSort(source, i+1, high);
        }

    }

    //归并排序

    //交换方法
    private static void swap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }

    public static void main(String[] args) {
        int[] source = new int[100];
        for (int i = 0; i < source.length; i++) {
            source[i] = (int) ((int)(Math.random()* 100));
        }


        //quickSort(source, 0 ,source.length-1);
        sort4(source);

        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
            if ((i + 1) % 25 == 0) {
                System.out.println();
            }
        }

    }

}
