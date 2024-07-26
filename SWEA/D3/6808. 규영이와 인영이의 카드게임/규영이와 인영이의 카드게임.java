import java.io.*;
import java.util.StringTokenizer;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int kyuWinCnt;
    static boolean[] used;
    static int[] kyuCards;
    static int[] inCardDeck;
    static int[] inCards;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        int idx = 1;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            kyuCards = new int[9];
            inCards = new int[9];
            inCardDeck = new int[9];
            boolean[] bArr = new boolean[19];

            for (int i = 0; i < 9; i++)
                kyuCards[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 9; i++)
                bArr[kyuCards[i]] = true;

            int inIdx = 0;
            for(int i=1; i<19; i++)
                if(!bArr[i])
                    inCardDeck[inIdx++] = i;

            kyuWinCnt = 0;
            int gameCnt = 362880;
            used = new boolean[9];

            perm(0);
            bw.write("#" + (idx++) + " " + kyuWinCnt + " " + (gameCnt - kyuWinCnt) + "\n");
        }

        bw.flush();
    }

    static void perm(int depth) {
        if (depth == 9) {
            int kyuScore = 0;
            int inScore = 0;

            for (int i = 0; i < 9; i++) {
                int kyuCard = kyuCards[i];
                int inCard = inCards[i];
                if(kyuCard > inCard)
                    kyuScore += kyuCard + inCard;
                else
                    inScore += kyuCard + inCard;
            }

            if(kyuScore > inScore) kyuWinCnt++;

            return;
        }

        for (int i = 0; i < 9; i++) {
            if(used[i]) continue;
            inCards[depth] = inCardDeck[i];
            used[i] = true;
            perm(depth + 1);
            used[i] = false;
        }
    }
}