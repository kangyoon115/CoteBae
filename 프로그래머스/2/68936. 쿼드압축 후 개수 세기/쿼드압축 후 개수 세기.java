class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);
        return answer;
    }

    public boolean zip(int[][] arr, int x, int y, int size, int val) {
        // x, y: 현재 탐색 시작 좌표
        // size: 현재 탐색 영역의 크기
        // val: 비교할 기준 값
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                // 하나라도 기준 값과 다르면 false 반환
                if(arr[i][j] != val)
                    return false;
        return true;
    }

    // 쿼드 트리 압축
    public void quad(int[][] arr, int x, int y, int size){
        // 현재 영역이 모두 같은 값인지 확인
        if(zip(arr,x,y,size, arr[x][y])){
            if(arr[x][y] == 1)
                answer[1]++;
            else 
                answer[0]++;
            return ;
        }
        
        // 영역이 같지 않으면 4등분하여 재귀 호출
        quad(arr,x,y, size/2);
        quad(arr,x,y + size/2, size/2);
        quad(arr,x+size/2,y, size/2);
        quad(arr,x+size/2,y + size/2, size/2);
    }

    
}