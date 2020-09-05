package com.learn.leetcode._257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/4 21:31
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    /**
     * 深度优先搜索
     *  1）将当前节点的值添加到已经遍历的路径中
     *  2）如果结点左右子树有值，则遍历左右子树，
     *  否则，结束当前路径遍历，将路径添加到结果路径中
     *
     * @param root  遍历的结点
     * @param path  当前路径遍历过的值
     * @param paths 路径集合
     */
    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(sb.toString());  // 把路径加入到答案中
            } else {
                sb.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, sb.toString(), paths);
                constructPaths(root.right, sb.toString(), paths);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Solution solution = new Solution();
        List<String> strings = solution.binaryTreePaths(root);
        strings.forEach(System.out::println);
    }

}
