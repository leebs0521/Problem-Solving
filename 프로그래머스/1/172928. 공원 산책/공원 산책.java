class Solution {


    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        boolean isFind = false;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    isFind = true;
                    break;
                }
                if(isFind)
                    break;
            }
        }
        for (String order : routes) {
            String op = order.substring(0, 1);
            int move = Integer.parseInt(order.substring(2));
            int cnt = 0;
            Boolean possible = true;
            // 서쪽
            if(op.equals("N")) {
                if (x - move >= 0) {
                    for (int i=1; i <= move; i++) {
                        if(park[x-i].charAt(y) == 'X'){
                            possible = false;
                            break;
                        }
                    }
                    if(possible){
                        x = x - move;
                    }
                } 
            }

            if(op.equals("S")) {
                if (x + move < park.length) {
                    for (int i = 1; i <= move; i++) {
                        if (park[x + i].charAt(y) == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        x = x + move;
                    }
                }
            }

            if(op.equals("W")) {
                if (y - move >= 0) {
                    for (int i = 1; i <= move; i++) {
                        if (park[x].charAt(y - i) == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        y -= move;
                    }
                }
            }

            if(op.equals("E")) {
                if (y + move < park[0].length()) {
                    for (int i = 1; i <= move; i++) {
                        if (park[x].charAt(y + i) == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        y += move;
                    }
                }
            }
        }

        return new int[]{x, y};
    }
}