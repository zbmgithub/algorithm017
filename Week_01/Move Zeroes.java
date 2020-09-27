class Solution {
    // public void moveZeroes(int[] nums) {
    //     int j = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != 0) {
    //             nums[j] = nums[i];
    //             if(i != j){
    //                 nums[i] = 0;
    //             }
    //             j++;
    //         }
    //     }
    // }
     //暴力法o(n*n)
    //双指针
    public void moveZeroes(int[] nums) {
        for (int i = 0,j = 0; j < nums.length ; j++) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                if(i != j){
                    nums[j] = 0;
                }
                i++;
            }
        
        }

    }
}
//方法一 挨着挨着移动
//方法二 开新数组记录零点的位置，再操作原数组，最后补零
//***方法三 index增加一个j来记录下一个非零元素位置，遇到非零元素交换元素，一次遍历即可
//***方法四 两次遍历，第一次把所有非零元素移到规定位置，第二次遍历把剩下的元素置零