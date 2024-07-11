import Sort.QuickSort;
import 树.ListNode;

import java.util.*;

public class Test150 {
    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        -5, 4, -2, 3, -2
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        minWindow("ADOBECODEBANC", "ABC");
        addTwoNumbers(ListNode.toListNode(new int[]{9, 9, 9, 9}), ListNode.toListNode(new int[]{9, 9, 9}));
        deleteSameNode(ListNode.toListNode(new int[]{3, 1, 2, 3,5,6,5,4}));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean cnt = false;
        ListNode l3 = new ListNode();
        ListNode l3Head = l3;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2;
            if (cnt) sum++;
            l3.val = sum % 10;
            cnt = sum >= 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 == null && l2 == null) {
                if (cnt) {
                    l3.next = new ListNode();
                    l3.next.val = 1;
                } else {
                    l3 = null;
                }
            } else {
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        return l3Head;
    }

    public static int maxProfit(int[] prices) {
        int maxIncome = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                maxIncome += prices[i + 1] - prices[i];
            }
        }
        return maxIncome;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                startIndex = Math.max(startIndex, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i + 1 - startIndex);
        }
        return result;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int tempSum = 0;
        int tempResult = 0;
        while (endIndex < nums.length) {
            tempSum += nums[endIndex];
            tempResult++;
            while (startIndex < nums.length && tempSum >= target) {
                result = Math.min(result, tempResult);
                tempSum -= nums[startIndex];
                startIndex++;
                tempResult--;
            }
            endIndex++;
        }
        if (result == Integer.MAX_VALUE) result = 0;
        return result;
    }

    public static String minWindow(String s, String t) {
        int startIndex = 0;
        int endIndex = 0;
        String tempResult = "";
        String result = "";
        int resultLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        char[] targetToChars = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        while (endIndex < s.length()) {
            sb.append(s.charAt(endIndex));
            if (map.containsKey(s.charAt(endIndex))) {
                map.put(s.charAt(endIndex), map.get(s.charAt(endIndex)) + 1);
            } else {
                map.put(s.charAt(endIndex), 1);
            }
            while (isInclude(map, targetToChars) == t.length()) {
                tempResult = sb.toString();
                if (resultLength > tempResult.length()) {
                    result = tempResult;
                    resultLength = result.length();
                }
                if (map.containsKey(sb.charAt(0))) {
                    map.put(s.charAt(0), map.get(s.charAt(0)) - 1);
                }
                sb.deleteCharAt(0);
                startIndex++;
            }
            endIndex++;
        }
        if (resultLength == Integer.MAX_VALUE) return "";
        return result;
    }

    private static int isInclude(HashMap<Character, Integer> map, char[] targetToChars) {

        int result = 0;
        for (int i = 0; i < targetToChars.length; i++) {
            if (map.containsKey(targetToChars[i]) && map.get(targetToChars[i]) > 0) {
                result++;
                map.put(targetToChars[i], map.get(targetToChars[i]) - 1);
            }
        }
        return result;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static ListNode deleteSameNode(ListNode node) {
        ListNode temp = node;
        HashMap<Integer, Integer> map = new HashMap();
        while (temp != null) {
            if (map.get(temp.val) == null) {
                map.put(temp.val, 0);
            }
            map.put(temp.val, map.get(temp.val) + 1);
            temp = temp.next;
        }
        ListNode result = new ListNode();
        result.val = -1;
        result.next = node;
        map.put(-1,1);
        temp = result;
        while (temp.next != null) {
            if (map.get(temp.next.val) > 1) {
                temp.next = temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return result.next;
    }
}