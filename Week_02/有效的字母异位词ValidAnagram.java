class Solution {
    public boolean isAnagram1(String s, String t) {//方法一利用(哈希)辅助数组 O(n) O(1)
    //遍历s,将每个出现过的元素在对应辅助数组中++
    //遍历t,将每个出现过的元素在对应辅助数组置--，如果有某个元素小于0就返回false
    //返回true
    //hash算法的概念 Hash: 一般翻译做“散列”，也有直接音译为“哈希”的，就是把任意长度的输入（又叫做预映射， pre-image），通过散列算法，变换成固定长度的输出，该输出就是散列值。 ... 简单的说就是一种将任意长度的消息压缩到某一固定长度的消息摘要的函数。
        if(s.length() != t.length()) return false;
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            hash[ch - 'a']--;
            if(hash[ch - 'a'] < 0) return false;
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {//方法二 排序 O(nlogn) O(1)n为s的长度
    //将两个字符串排序，再进行比较equals
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
}