package com.learn.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

    @Test
    public void testStrToListStr() {
        String str = "[\"un\",\"iq\",\"ue\"]";
        List<String> actual = Utils.strToListStr(str);
        List<String> expected = new ArrayList<>();
        expected.add("un");
        expected.add("iq");
        expected.add("ue");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnPacking() {
        Assert.assertEquals("un", Utils.unPacking("\"un\""));
        Assert.assertEquals("un", Utils.unPacking("[[un]]", 2));
    }

}