package com.learn.temp;

import org.junit.Test;

/**
 * ClassName: TempTest
 * Description:
 * date: 2020/8/10 11:03
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class TempTest {

    @Test
    public void classTest () {
        System.out.println(double[][].class.getComponentType());
    }

    @Test
     public void className() {
        String name = "binary-tree-level-order-traversal-ii";
        name = "top-k-frequent-elements";
        name = "average-of-levels-in-binary-tree";
        name = name.replaceAll("-", "_");
        System.out.println("_" + name);
    }
}
