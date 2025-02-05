class ZeroOneKnapsackProblem {
    public static void main(String... args) {
        KnapsackItem[] items = new KnapsackItem[2];
        int[] value = { 25, 32 };
        int[] weight = { 5, 7 };
        for (int i = 0; i < items.length; i++) {
            items[i] = new KnapsackItem(i + 1, value[i], weight[i]);
        }
        System.out.println((new Solution()).solution(items, 0, 0, 7));
    }
}

class KnapsackItem {

    private int value;
    private int weight;

    public KnapsackItem() {

    }

    public KnapsackItem(int index, int value, int weight) {

        this.value = value;
        this.weight = weight;

    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}

class Solution {
    public int solution(KnapsackItem[] items, int weight, int index, int capacity) {
        if (index >= items.length)
            return 0;
        else if (weight + items[index].getWeight() > capacity)
            return 0;
        else {
            int case1 = items[index].getValue()
                    + solution(items, weight + items[index].getWeight(), index + 1, capacity);
            int case2 = solution(items, weight, index + 1, capacity);
            System.out.println(case1 + " " + case2);
            return case1 > case2 ? case1 : case2;
        }
    }
}