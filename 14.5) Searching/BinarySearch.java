public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = binarySearch(arr, 13);
        System.out.println(target);
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if (nums[0] == target)
            return 0;
        if (nums.length > 1 && nums[nums.length - 1] == target)
            return nums.length - 1;
        while (right - left != 1) {
            mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid;
            else
                left = mid;
        }
        return -1;
    }
}
