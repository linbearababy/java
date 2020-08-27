day 04
08/26/2020

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I


Notes: 

interval = 2*n -2(每一个整列的index） （n是行数）
step：interval - 2*i 每一个中间的数字和他整列的差（i是现在行数）





class Solution {
    public String convert(String s, int numRows) {
        String world = "";
        if (s.length() < numRows || numRows == 1) {
            world += s;
            return world;
        }
        // int count ;
        int interval = 2*numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int step = interval - 2*i;
            for (int j = i; j < s.length(); j+=interval) {
                world += s.charAt(j);
                if (step > 0 && step < interval && step+j < s.length()) {
                    world += s.charAt(j+step);
                }
            }
        }
        return world;
    }
}
