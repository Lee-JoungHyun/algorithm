package other;

public class BinarySearch_lu {
    static int[] arr1 = {0, 1, 2, 3, 5, 6, 7, 8};
    static int[] arr2 = {0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8};
    public static void main(String[] args) {
        System.out.println("lower_bound, arr1: " + lower_bound(arr1, 4));
        System.out.println("upper_bound, arr1: " + upper_bound(arr1, 4));
        System.out.println("lower_bound, arr2: " + lower_bound(arr2, 4));
        System.out.println("upper_bound, arr2: " + upper_bound(arr2, 4));
    }
    public static int lower_bound(int[]arr, int K) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < K)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
    static int upper_bound(int[] arr, int K) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= K)
                left = mid + 1;
            else
                right = mid;
        }
        return right-1;
    }
}
