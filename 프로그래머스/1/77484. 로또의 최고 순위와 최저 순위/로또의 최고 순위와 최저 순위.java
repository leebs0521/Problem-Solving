import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zeroCnt = 0;
        int sameCnt = 0;
        int idxLottos = 0;
        int idxWins = 0;
        while (true) {

            if(idxWins == win_nums.length || idxLottos == lottos.length) {
                break;
            }

            if(lottos[idxLottos] == 0) {
                zeroCnt++;
                idxLottos++;
            } else {
                if (lottos[idxLottos] == win_nums[idxWins]) {
                    sameCnt++;
                    idxLottos++;
                    idxWins++;
                } else if (lottos[idxLottos] > win_nums[idxWins]) {
                    idxWins++;
                } else {
                    idxLottos++;
                }
                
            }

        }


        int[] answer = {check(zeroCnt+sameCnt), check(sameCnt) };
        return answer;
    }

    static int check(int num) {
        return switch (num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}