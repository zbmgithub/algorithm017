//普通情况直接digits[digits.length-1]++即可
//当为 19，29，39，等等时上一位也需要加一
//当为 9 ， 99， 999 等等时需要进位,以前的数组将不够用

//模拟操作，从最后一位加起，直至上一位没有9

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while (i >= 0) {
            if(digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i]++;
                break;//优化为 return digits;
            }
            i--;
        }
        if (i < 0) {//优化后 可以忽略此if判断
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}