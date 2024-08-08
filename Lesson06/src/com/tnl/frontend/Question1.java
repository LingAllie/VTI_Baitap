package com.tnl.frontend;

public class Question1 {
    public static void main(String[] args) {
        int[] numbers = {-1, 1, 3, 5, -5, -8};
        int maxValue = getMaxValue(numbers);
        int minValue = getMinValue(numbers);

        System.out.println("Max Value: " + maxValue);
        System.out.println("Min Value: " + minValue);
    }

    // i = 4, maxValue = -1
    // i = 4, set maxValue = 5, numbers[4] = -5
    // i = 5, maxValue = -8 => numbers[5] = -8, do if number[5] < max (-8 < 5) thi chuyen max = num[i] => doi dau dieu kien if
    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
//        	if(i == 4) {
//        		maxValue = 5;
//        	}
//        	if (numbers[i] < maxValue) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    // numbers.length = 6, trong vong lap de numbers.length - 1 = 5, => i di tu 1 > 5
    // i chua chay den gia tri cuoi cung trong mang numbers nen chua xet den gia tri -8 ma chi moi xet den -5 la ket thuc vong lap
    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
//        for (int i = 1; i < numbers.length - 1; i++) {
        	for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}

