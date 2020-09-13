package com.learn.leetcode._79_word_search;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/word-search/submissions/
 * date: 2020/9/13 20:29
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    boolean[][] bs;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        this.board = board;
        this.word = word;

        bs = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            bs[i] = new boolean[board[i].length];
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    bs[i][j] = true;
                    if (exist(1, i, j)) {
                        return true;
                    }
                    bs[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean exist(int idx, int x, int y) {
        if (idx >= word.length()) {
            return true;
        }

        char curr = word.charAt(idx);

        return checkItem(idx, x - 1, y, curr) ||
                checkItem(idx, x, y - 1, curr) ||
                checkItem(idx, x + 1, y, curr) ||
                checkItem(idx, x, y + 1, curr);
    }

    private boolean checkItem(int idx, int x, int y, char curr) {
        x = (x + board.length) % board.length;
        y = (y + board[x].length) % board[x].length;
        if (!bs[x][y]) {
            if (curr == board[x][y]) {
                bs[x][y] = true;
                if (exist(idx + 1, x, y)) {
                    return true;
                }
                bs[x][y] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Solution solution = new Solution();
        System.out.println(solution.exist(chars, "SSFDB"));
        chars = new char[][]{{'a', 'a', 'a'}, {'a', 'b', 'b'}, {'a', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}, {'a', 'a', 'a'}, {'b', 'b', 'b'}, {'a', 'b', 'b'}, {'a', 'a', 'b'}, {'a', 'b', 'a'}};

        System.out.println(solution.exist(chars, "aabaaaabbb"));

        System.out.println("[[\"a\",\"a\",\"a\"],[\"a\",\"b\",\"b\"],[\"a\",\"b\",\"b\"],[\"b\",\"b\",\"b\"],[\"b\",\"b\",\"b\"],[\"a\",\"a\",\"a\"],[\"b\",\"b\",\"b\"],[\"a\",\"b\",\"b\"],[\"a\",\"a\",\"b\"],[\"a\",\"b\",\"a\"]]"
                .replaceAll("\\[", "{")
                .replaceAll("]", "}")
                .replaceAll("\"", "'"));

    }


}
