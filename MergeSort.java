import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{1,2,1,1,2,3})));
    }

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) return arr;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
        return arr;
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int [] left = Arrays.copyOfRange(arr,L,M+1);
        int [] right = Arrays.copyOfRange(arr,M+1,R+1);
        int i = L,j=0,k=0;
        while (j < left.length && k < right.length) {
            if (left[j]<=right[k]) {
                arr[i] = left[j];
                j += 1;
            } else {
                arr[i] = right[k];
                k += 1;
            }
            i += 1;
        }
        while (j < left.length) {
            arr[i] = left[j];
            j += 1;
            i += 1;
        }
        while (k < right.length) {
            arr[i] = right[k];
            k += 1;
            i += 1;
        }
    }

}
