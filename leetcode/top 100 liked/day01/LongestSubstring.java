LongestSunstring 
Day 3
08/25/2020




Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
             
             
#method 1:       just fix the example 1:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int cur = 0;
        String st = "";
        //int size =0;
        for (int i = 0; i < s.length(); i++) {
            if (!this.isContain(st,s.charAt(i))) {
                st += s.charAt(i);
                longest ++;
                //cur ++;
                if (longest > cur) {
                    cur = longest;
                }
            }
            //cur = size;
            
            else if (this.isContain(st,s.charAt(i))) {
                st = "";
                st += s.charAt(i);
                longest = 1;
            }
        }
        return cur;
    }
    
    public boolean isContain(String a, char b) {
        boolean word = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b) {
                word = true;
            }
        }
        return  word;
    }
}




#method 2       fix all the examples.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
