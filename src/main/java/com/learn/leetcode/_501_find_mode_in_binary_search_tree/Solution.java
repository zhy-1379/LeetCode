package com.learn.leetcode._501_find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/24 21:50
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> items;
    private int maxCount;
    private int curCount;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        items = new ArrayList<>();
        // 这里设置为1是因为 在递归中 BST中最左边的结点被跳过了，作为初状态 该结点值出现一次，记录的出现最多次数一开始也为1
        maxCount = 1;
        curCount = 1;
        midTraversal(root);
        // 最右端结点的处理，从递归中看，最后一个结点与前一个结点相等只更新了curCount的值；不相等则只考虑到倒数第二个结点。
        if (curCount > maxCount) {
            return new int[]{pre.val};
        }

        if (curCount == maxCount) {
            items.add(pre.val);
        }
        int[] res = new int[items.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = items.get(i);
        }
        return res;
    }

    private void midTraversal(TreeNode x) {
        if (x == null) return;
        midTraversal(x.left);
        if(pre != null){
            if(x.val != pre.val){ // 说明上一个值的结点数量已经统计完成 要看出现次数的情况
                if(curCount > maxCount){ // 出现次数更多，清空之前的出现少的数，更新最大出现次数
                    maxCount = curCount;
                    items.clear();
                    items.add(pre.val);
                }
                else if(curCount == maxCount){ // 不止一个众数
                    items.add(pre.val);
                }
                curCount = 1; // 当前值与上一个结点值不同，重置计数
            }
            else curCount++; // 当前值与上一个结点值相同，当前值的出现次数增加。
        }
        pre = x;
        midTraversal(x.right);
    }




    // public int[] findMode(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     Map<Integer, Integer> numsMap = new HashMap<>();
    //
    //     computeNum(numsMap, root);
    //     int asInt = numsMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    //
    //     List<Integer> collect = numsMap
    //             .entrySet()
    //             .stream()
    //             .filter(e -> e.getValue().equals(asInt))
    //             .map(Map.Entry::getKey)
    //             .collect(Collectors.toList());
    //     int[] res = new int[collect.size()];
    //     for (int i = 0; i < collect.size(); i++) {
    //         res[i] = collect.get(i);
    //     }
    //     return res;
    //
    // }
    //
    // private void computeNum(Map<Integer, Integer> numsMap, TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //
    //     if (!numsMap.containsKey(root.val)) {
    //         numsMap.put(root.val, 0);
    //     }
    //     numsMap.put(root.val, numsMap.get(root.val) + 1);
    //
    //     computeNum(numsMap, root.left);
    //     computeNum(numsMap, root.right);
    // }

}
