class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {//方法三 尾部插法，双指针
        //从nums1尾部开始，i指针指向m-1，j指针指向n-1,从尾部插入，这样不用担心覆盖到nums1的元素
        int i = m - 1, j = n - 1;
        for( ; i >= 0 && j >= 0; ) {
            if (nums1[i] <= nums2[j]) nums1[i + j + 1] = nums2[j--];
            else nums1[i + j + 1] = nums1[i--];
        }
        while (j >= 0) {
            nums1[i + j + 1] = nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {//方法二 额外数组O(m+n) O(m+n)
        {
            // int[] nums = new int[m+n];
            // int i = 0, j = 0;
            // while (i < m && j < n) {
            //     if (nums1[i] < nums2[j]) nums[i+j] = nums1[i++];
            //     else nums[i+j] = nums2[j++];
            // }
            // while (i < m) {
            //     nums[i+j] = nums1[i++];
            // }
            // while (j < n) {
            //     nums[i+j] = nums2[j++];
            // }
            // for (int k = 0; k < m+n; k++)
            //     nums1[k] = nums[k];
        }
        //优化版 O(m+n) O(m)
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);//nums1从0开始拷贝到nums1_copy从0开始长度为m
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1_copy[i] < nums2[j]) nums1[i+j] = nums1_copy[i++];
            else nums1[i+j] = nums2[j++];
        }
        if (i < m) System.arraycopy(nums1_copy, i, nums1, i + j, m + n - i - j);
        if (j < n) System.arraycopy(nums2, j, nums1, i + j, m + n - i -j);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {//方法一 直接nums2插入到num1尾部,再sort
    //O(mlogm) O(1)
        for (int i = 0; i < n; i++)
            nums1[m+i] = nums2[i];
        Arrays.sort(nums1);
    }

}