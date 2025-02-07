class Solution {
    public boolean exists(char[][] board, int i, int j, char[] word, int idx) {
        // Base case to check if we're out of bounds or character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*' || board[i][j] != word[idx]) {
            return false;
        }

        // If we match all characters in word, return true
        if (idx == word.length - 1) {
            return true;
        }

        // Temporarily mark the cell as visited
        char ch = board[i][j];
        board[i][j] = '*';

        // Recursively check all 4 possible directions
        boolean res = exists(board, i + 1, j, word, idx + 1) ||  // Move down
                      exists(board, i - 1, j, word, idx + 1) ||  // Move up
                      exists(board, i, j + 1, word, idx + 1) ||  // Move right
                      exists(board, i, j - 1, word, idx + 1);    // Move left

        // Restore the cell for other potential paths
        board[i][j] = ch;

        return res;
    }

    public boolean exist(char[][] board, String word) {
        char[] word_arr = word.toCharArray();

        // Iterate over the board to find the first character of the word
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches and the word exists, return true
                if (board[i][j] == word_arr[0] && exists(board, i, j, word_arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}