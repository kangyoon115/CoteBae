// 개미 남은 체력 hp, 개미 수 ant(답)
// 체력에다가 각각 5,3,1 순으로 크기가 큰 순서대로 나누기
// 몫이 바로 개미수 ant에 순차적으로 저장
// 남은 체력같은 경우 hp % (해당 개미 수 5,3,1)

class Solution {
    public int solution(int hp) {
        int ant=0;
        
        ant = ant + (hp/5);
        hp=hp%5;
        
        ant = ant +(hp/3);
        hp=hp%3;
        
        ant = ant +(hp/1);
        
        return ant;
    }
}