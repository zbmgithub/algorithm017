//还有一种质数相乘法 风险时 容易溢出 
// 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。
//故可以利用 每个字母用不同的质数表示，字符串的键值为 质数之积 来表示


class Solution {//按计数分类
//构建一个StringBuilder类型变量作为 key 值 #a#b#c#d.....#z
//每个字母的位置存储对应字母的出现次数，依次分类
//利用一个哈希表存储分类的结果，最后返回
// // 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
// // 空间复杂度：O(NK)，排序存储在 res 中的全部信息内容
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List> res = new HashMap<String,List>();
        for (String s : strs) {
            int[] arr = new int[26];
            for (char ch : s.toCharArray()) {
                arr[ch - 'a']++;
            }
            StringBuilder temp = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                temp.append('#');
                temp.append(arr[i]);
            }
            String key = temp.toString();
            if (!res.containsKey(key)) res.put(key, new ArrayList<String>());
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
}

// class Solution {//排序字符串解法，利用哈希表存储分类后的字符串
// //创建一个 Map<String,List> 哈希表存储 分类结果
// //每次遍历strs,将其转化为字符数组再排序，判断排序好的作为key查询是否存在在hash表中
// //存在即添加到value-List中，不存在则将该key值与value存进去
// // 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。

// // 空间复杂度：O(NK)，排序存储在 res 中的全部信息内容。
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList<>();
//         Map<String,List> res = new HashMap<String,List>();
//         for (String s : strs) {
//             char[] ch = s.toCharArray();
//             Arrays.sort(ch);
//             String key = String.valueOf(ch);//将字符数组转化为字符串
//             if (!res.containsKey(key)){
//                 res.put(key, new ArrayList<String>());
//             }
//             res.get(key).add(s);
//         }
//         return new ArrayList(res.values());
//     }
// }


// class Solution {//暴力法
// //遍历每个元素 与其后面元素比较，如果相等就加入一个List，最后一起加入string[][]中
// //再继续访问下一个元素
// //创建一个辅助boolean类型数组，用来判断元素是否已经访问过
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> res = new ArrayList<>();//创建结果数组
//         boolean[] used = new boolean[strs.length];
//         for (int i = 0; i < strs.length; i++) {
//             List<String> temp = null;
//             if (!used[i]) {
//                 temp = new ArrayList<String>();
//                 temp.add(strs[i]);
//                 for (int j = i+1; j < strs.length; j++) {
//                     if (!used[j] && equals(strs[i], strs[j]) ) {
//                         temp.add(strs[j]);
//                         used[j] = true;
//                     }
//                 }
//             }
//             if (temp != null) res.add(temp);
//             used[i] = true;
//         }
//         return res;
//     }
//     public boolean equals(String s1, String s2) {
//         if(s1.length() != s2.length()) return false;
//         int[] alphabet = new int[26];
//         for (char ch : s1.toCharArray()) {
//             alphabet[ch - 'a']++;
//         }
//         for (char ch : s2.toCharArray()) {
//             alphabet[ch - 'a']--;
//             if (alphabet [ch - 'a'] < 0) return false;
//         }
//         return true;
//     }
// }