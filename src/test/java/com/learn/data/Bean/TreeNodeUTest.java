package com.learn.data.Bean;

import com.learn.data.bean.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: TreeNodeUTest
 * Description:
 * date: 2020/9/27 21:18
 *
 * @author zhy
 * @since JDK 1.8
 */
public class TreeNodeUTest {

    @Test
    public void valuesArrayUTest() {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node6.left = node2;
        node6.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;

        Assert.assertArrayEquals(node6.valuesArray(), new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

    }

    @Test
    public void createUTest() {
        Integer[] values = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};

        TreeNode node = TreeNode.create(values);
        Assert.assertNotNull(node);

        Assert.assertArrayEquals(values, node.valuesArray());

    }
}
