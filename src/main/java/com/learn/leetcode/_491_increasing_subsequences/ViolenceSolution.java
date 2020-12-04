package com.learn.leetcode._491_increasing_subsequences;

import java.security.SecureRandom;
import java.util.*;

/**
 * ClassName: ViolenceSolution
 * Description:
 * date: 2020/8/25 22:04
 *
 * @author seaxll
 * @since JDK 1.8
 */
class ViolenceSolution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }

    public static void main(String[] args) {
        ViolenceSolution solution = new ViolenceSolution();

        Random random = new SecureRandom();
        int[] nums = new int[random.nextInt(20)];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = random.nextInt(100);
        }
        System.out.println(">>> " + Arrays.toString(nums) + "的递增子序列为：");
        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        subsequences.forEach(System.out::println);

    }

}

