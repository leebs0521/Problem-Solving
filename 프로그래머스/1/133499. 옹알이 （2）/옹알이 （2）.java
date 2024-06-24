class Solution {
    public int solution(String[] babbling) {

        String[] isPossible = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String bab : babbling) {
            String temp = bab;
            Boolean isFlag = true;
            for (String possbile : isPossible) {
                if (bab.contains(possbile.repeat(2))) {
                    isFlag = false;
                    break;
                }
                temp = temp.replaceAll(possbile, " ");
            }
            temp = temp.replaceAll(" ","");
            if (temp.equals("") && isFlag)
                answer++;
        }

        return answer;
    }
}