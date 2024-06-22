class Solution {
    public String solution(int a, int b) {
        int month = 1;
        int day = 1;
        int[] lastDayMonth = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int daysIdx = 0;
        while (month != a || day != b) {
            if (lastDayMonth[month] == day) {
                month++;
                day = 1;
            } else {
                day++;
            }
            daysIdx = (daysIdx + 1) % 7 ;
        }
        String answer = days[daysIdx];

        return answer;
    }
}