//方法一 暴力法 挨着挨着移动
//方法二 交换法 双指针，cur指向当前非零位置，i遍历，如果当前有非零元素那么就放到cur位置，当前元素变成0，cur++,i继续++
//方法三 两次遍历法 第一次把所有非零元素移到规定位置，第二次遍历把剩下的元素置零

class Solution {
    // public void moveZeroes(int[] nums) {
    //     int cur = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if(nums[i] != 0) {
    //             nums[cur] = nums[i];
    //             if(i != cur) {//简化交换，同时避免一开始ij相等时被置为0
    //                 nums[i] = 0;
    //             }
    //             cur++;
    //         }
    //     }
    // }
    public void moveZeroes(int[] nums) {//方法三
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        while(cur < nums.length) {
            nums[cur++] = 0;
        }
    }
}