package com.learn.leetcode._841_keys_and_rooms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 *      https://leetcode-cn.com/problems/keys-and-rooms/
 *
 * date: 2020/8/31 21:25
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {
    boolean[] isAccessible;
    List<List<Integer>> roomList;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomList = rooms;
        isAccessible = new boolean[rooms.size()];
        isAccessible[0] = true;
        access(0);
        for (boolean b : isAccessible) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /**
     * 进入第 i 个房间并拿到第 i 个房间的钥匙
     *
     * @param i
     */
    private void access(int i) {
        for (int j = 0; j < roomList.get(i).size(); j++) {
            int romm = roomList.get(i).get(j);
            // 还未进入第 romm 个房间
            if (!isAccessible[romm]) {
                isAccessible[romm] = true;
                access(romm);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "[[1],[2],[3],[]]";
        JSONArray jsonArray = JSON.parseArray(str);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            lists.add(jsonArray.getJSONArray(i).toJavaList(Integer.class));
        }
        boolean b = solution.canVisitAllRooms(lists);
        System.out.println(b);

    }


}
