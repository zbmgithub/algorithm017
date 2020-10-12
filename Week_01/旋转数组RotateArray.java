//方法二 创建一个新的数组，将移动后的位置拷贝到新的数组（不符合题意，空间复杂度超标）

class Solution {
    public void rotate(int[] nums, int k) {//方法四 模拟换座位，每次移动一个元素，一直换到与开始的位置重复，移动下一个元素
        //首先k %= len;
        //首先从0号元素开始，它将移到k下标的位置，而k号元素将移到2k%len下标位置
        //直至等于0下标或者已经移动n个元素了
        //若等于0下标，则从1号元素开始，依次类推
        int len = nums.length;
        k %= len;
        int count = 0;//计数，移动了多少个元素
        for (int i = 0; count < len; i++) {
            {    //逻辑一 是每次先找到下一位置，直到要换的位置已经是之前找到过的位置了
                // int next = (i + k) % len;
                // int outseat = nums[i];
                // do{ 
                //     int temp = nums[next];
                //     nums[next] = outseat;
                //     outseat = temp;
                //     next = (next + k) % len;
                //     count++;
                // }while(next != (i + k) % len);
            }
            //逻辑二 找到当前位置，与下一位置交换，直到当前位置已经被交换过
            int cur = i;
            int outseat = nums[i];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = outseat;
                outseat = temp;
                cur = next;
                count ++;
            } while(cur != i);
        }
    }

    public void rotate3(int[] nums, int k) {//方法三 三次翻转，逆转所有元素，逆转前k个， 再逆转后n-k个
        int len = nums.length;
        k %= len;
        reverse2(nums, 0, len-1);
        reverse2(nums, 0, k-1);
        reverse2(nums, k, len-1);
    }
    public void reverse2(int[]nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {//方法一 暴力法 一次移动一位，移动k次 O(KN)
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[len-1];
            for(int j = len-1; j > 0; j--)
                nums[j] = nums[j-1];
            nums[0] = temp;
        }
    }
}