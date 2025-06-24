import java.util.*;

class Solution {
    // stack: int, answer = 0
    // for i = 0 ... moves.length
    //  for j = 0 ... boards.length 
    //    if board[i][j] != 0
    //        if stack.peek == baord[i][j]:
    //          stack.pop
    //          answer += 2;
    //        else: stack.push(board[i][j]);
    //    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1; // 열 번호
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}