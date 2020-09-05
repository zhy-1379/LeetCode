package com.learn.leetcode._322_reconstruct_itinerary;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * ClassName: Solution
 * Description:
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * date: 2020/8/27 20:34
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {

    Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.forEach(ticket -> ticketMap.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>()).offer(ticket.get(1)));
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    public void dfs(String place) {
        while (ticketMap.get(place) != null && !ticketMap.get(place).isEmpty()) {
            dfs(ticketMap.get(place).poll());
        }
        res.add(place);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]";
        // String s = str.replaceAll("\\[", "{").replaceAll("]", "}");
        // System.out.println(s);

        // String[][] strings = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        // List<List<String>> tickets = new ArrayList<>();
        // Stream.of(strings).forEach(e -> tickets.add(new ArrayList<>(Arrays.asList(e))));
        // List<String> itinerary = solution.findItinerary(tickets);
        // System.out.println(itinerary);

        JSONArray jsonArray = JSON.parseArray(str);
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            lists.add(jsonArray.getJSONArray(i).toJavaList(String.class));
        }
        List<String> res = solution.findItinerary(lists);
        System.out.println(res);


    }

}
