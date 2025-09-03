import java.util.*;
class Solution {
    public int[] solution(String[] grid) {
        int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}}; //오,왼,아래,위
        int lengthX = grid.length;
        int lengthY = grid[0].length();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[][][] checked = new boolean[lengthX ][lengthY][dir.length];

        for(int i=0; i<lengthX; i++) {
            for(int j=0; j<lengthY; j++) {
                int pos[] = {i,j};

                for(int k=0; k<dir.length; k++) {
                    int lightDir = k;
                    int cnt = 0; // 사이클 길이
                    do {
                        if(checked[pos[0]][pos[1]][lightDir]) {
                            cnt=0;
                            break;
                        }
                        checked[pos[0]][pos[1]][lightDir] = true;
                        cnt++;
                        char direction = grid[pos[0]].charAt(pos[1]); // 현재 칸의 방향
                        lightDir = trans(direction,lightDir); // 빛의 방향

                        pos[0] = movePos(pos[0], dir[lightDir][0], lengthX);
                        pos[1] =movePos(pos[1], dir[lightDir][1], lengthY);

                    }while(!(pos[0]==i && pos[1]==j && lightDir==k));

                    if(cnt>0) {
                        list.add(cnt);
                    }
                }
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i <list.size(); i++) {
            answer[i] = list.get(i); 
        }
        return answer;
    }

    public int trans(char direction , int light) { //빛의 방향 변환
        if(direction=='R') {
            if(light==0) {
                light = 2;
            }else if(light==1){
                light = 3;
            }else if(light==2){
                light = 1;
            }else {
                light = 0;
            }
        }else if(direction=='L') {
            if(light==0) {
                light = 3;
            }else if(light==1){
                light = 2;
            }else if(light==2){
                light = 0;
            }else {
                light = 1;
            }
        }

        return light;
    }

    public int movePos(int pos, int move , int max){ //빛의 방향에 따른 칸 이동
        pos = pos + move;
        if(pos < 0) {
            return max-1;
        }else if(pos >= max) {
            return 0;
        }
        return pos;
    }
}