//方法一 按行求
//方法二 按列求
//方法三 动态规划
//方法四 双指针
//方法五 栈
//方法六 固定最高的柱子，左右双指针夹逼法
//方法七 数学解法 
class Solution {
    public int trap(int[] height) { //方法七 数学解法
    //从左到右遍历出最高左边高度
    //以及从右遍历出最高右边高度
    //减去柱子的高度
        int max_left = -1, max_right = -1;
        int sum = 0, sum1 = 0, sum2 = 0;
        int len = height.length;
        // int sum3 = 0;

        for (int i = 0; i < len; i++) {
            if(height[i] > max_left)
                max_left = height[i];
            if(height[len-i-1] > max_right)
                max_right = height[len - i - 1];
            sum1 += max_left;
            sum2 += max_right;
            sum -= height[i];
        }
        sum += sum1 + sum2 - max_left * len;
        return sum;
    }
    public int trap6(int[] height) { //方法六 固定最高柱子
        int max_height = -1;
        int max_index = 0;
        int sum = 0, max_left = 0, max_right = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max_height) {
                max_height = height[i];
                max_index = i;
            }
        }
        for (int i = 0 ; i < max_index; i++) {
            if (height[i] > max_left)
                max_left = height[i];
            else
                sum += max_left - height[i];
        }
        for (int i = height.length-1; i > max_index; i--) {
            if (height[i] > max_right)
                max_right = height[i];
            else
                sum += max_right - height[i];
        }
        return sum;
    }
    public int trap5(int[] height) { //方法五 栈
    //创建一个栈，只要有比当前栈顶小或相等的就入栈，当遇见比栈顶大的时就说明可以确定中间的水量了
    //栈不为空且大于栈顶元素才可以开始出栈
    //如果出栈后栈空了就不用继续计算雨量了
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int h = stack.pop();
                if(stack.empty())
                    break;
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                sum += distance * (min - height[h]);
            }
            stack.push(i);
        } 
        return sum;
    } 
    public int trap4(int[] height) { //方法四 双指针 O(n) O(1) 通过判断max_left与max_right来改变遍历顺序
    //与动态规划类似，不过进行优化，这样在遍历的时候更新max_left与max_right
    //省去了O(n)的空间
        int sum = 0;
        int max_left = -1, max_right = -1;
        int left = 1, right = height.length - 2;
        while (left <= right) {
            if(height[left-1] < height[right+1]) {
                max_left = Math.max(max_left, height[left-1]);
                if (max_left > height[left])
                    sum += max_left - height[left];
                left++;
            } else {
                max_right = Math.max(max_right, height[right+1]);
                if (max_right > height[right])
                    sum += max_right - height[right];
                right--;
            }
        }
        return sum;
    }
    public int trap3(int[] height) { //方法三 动态规划 O(n) O(n)
    //我们发现按列求每次遍历左右最大值有些耗费时间，可以利用一个数组存储当前的最大值，避免重复操作
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        int sum = 0;
        for (int i = 1; i < height.length; i++)
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        for (int i = height.length - 2; i >= 0; i--)
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        for (int i = 1; i < height.length; i++) {
            int min = max_left[i] < max_right[i] ? max_left[i] : max_right[i];
            if(min > height[i])
                sum += min - height[i];
        }
        return sum;
    }

    public int trap2(int[] height) { //方法二 按列求 O(n^2)
    //从第1列开始直到length-2列结束，因为第0列和length-1列不可能存有雨水
    //每次遍历找出左边最高以及右边最高的的
    //取min 雨水量 += min - height[i]
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = -1;
            for (int k = i - 1; k >= 0; k--) 
                left_max = Math.max(left_max, height[k]);
            int right_max = -1;
            for (int k = i + 1; k < height.length; k++)
                right_max = Math.max(right_max, height[k]);
            int min = left_max < right_max ? left_max : right_max;
            if(min > height[i])
                sum += min - height[i];
        }
        return sum;
    }
    
    public int trap1(int[] height) { //方法一 按行求 O(m*n) m为最大高度
    //找出最大高度，根据最大高度确定遍历层数
    //从第一层水开始
    //如果有start && height[j] < i ,temp++
    //如果有height[j] >= i ,开始计数 start = true, sum += temp, temp = 0
        int max_height = -1;
        int sum = 0;
        for (int i = 0; i < height.length; i++)
            max_height = Math.max(max_height, height[i]);
        for (int i = 1; i <= max_height; i++) { //i代表雨的层数
            boolean start = false;
            int temp = 0;
            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < i)
                    temp++;
                if (height[j] >= i) {
                    start = true;
                    sum += temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }
}