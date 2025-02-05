/*
 Given N number of houses with the amount in each house, find the highest amount that can be stolen with the following catch : 
-> Stealing from adjacent houses alerts the Police.
 */

public class HouseRobberProblem {
    public static void main(String... args) {
        int[] arr = { 5, 6, 7, 50, 33, 18, 19, 45 };
        System.out.println((new HouseRobber()).houseRobber(arr, 0));
    }
}

class HouseRobber {
    public int houseRobber(int[] arr, int current) {
        if (current == arr.length - 1) {
            return arr[arr.length - 1];
        }
        if (current >= arr.length) {
            return 0;
        }
        return houseRobber(arr, current + 1) > arr[current] + houseRobber(arr, current + 2)
                ? houseRobber(arr, current + 1)
                : arr[current] + houseRobber(arr, current + 2);
    }
}

// return arr[arr.length -2] > arr[arr.length-1] ? arr[arr.length-2] :
// arr[arr.length-1];