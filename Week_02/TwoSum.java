// 已知每种输入只会对应一个答案

//方法一 O(n^2) 暴力法 nums[i] + nums[j] == target 
//方法二 两遍哈希表
//方法三 一遍哈希表


class Solution {
    // public int[] twoSum2(int[] nums, int target) {//两遍哈希法
    // //将所有值 以及下标存入哈希表中
    // //再次遍历，判断是否存在 key 值为 target-num[i] 且 value值不等于本身的i的元素
    // //如果有相同key值的元素，后面会取代前面的,多个重复元素时，最后结果会输出最前面与最后面的元素下标
    //     Map<Integer,Integer> res = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) res.put(nums[i], i);
    //     for (int i = 0; i < nums.length; i++) {
    //         if (res.containsKey(target - nums[i]) && res.get(target - nums[i]) != i)
    //             return new int[]{i, res.get(target-nums[i])};
    //     }
    //     return new int[0];
    // }

    public int[] twoSum(int[] nums, int target) {//一遍哈希法
    //遍历数组 每次哈希查询是否存在这样的 key 值= target - num[i], 有就说明找到目标值了
    //返回 new  int {hash.get(target-num[i]),i};
    //否则 将num[i]的值 以及下标 i 存入哈希表中
        Map<Integer,Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i]))
                return new int[] {res.get(target-nums[i]), i};
            res.put(nums[i], i);
        }
        return new int[0];
    }

    // public int[] twoSum1(int[] nums, int target) {//暴力法
    //     for (int i = 0; i < nums.length-1; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return null;
    // }
    
}