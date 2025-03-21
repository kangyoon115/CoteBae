class Solution {
    public int solution(int m, int n, String[] board) {
        //2차원 문자배열로 변환
        char[][] map=new char[m][n];
        for(int i=0;i<m;i++){
            map[i]=board[i].toCharArray();
            
        }
        
        int answer = 0;
        boolean hasMatch=true;
        
        // 더이상 제거할 블록이 없을 때까지 반복
        while(hasMatch){
            //제거할 블록을 표시할 배열
            boolean[][] remove=new boolean[m][n];
            hasMatch=false;
            
            //1. 2X2 형태의 블록 찾기
            
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    char current=map[i][j];
                    
                    if(current==' ') continue;
                    
                    if(current==map[i][j+1]&&current==map[i+1][j]&&current==map[i+1][j+1]){
                        remove[i][j]=true;
                        remove[i+1][j]=true;
                        remove[i][j+1]=true;
                        remove[i+1][j+1]=true;
                        hasMatch=true;
                    }
                }
            }
            
            //2. 표시된 블록 제거 및 카운트
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(remove[i][j]){
                        map[i][j]=' ';
                        answer++;
                    }
                }
            }
            
            //3. 중력 적용: 블록 아래로 떨어뜨리기
            for(int j=0;j<n;j++){
                for(int i=m-1;i>=0;i--){
                    if(map[i][j]==' '){
                        //현재 위치가 빈공간이면 위쪽에서 블록을 찾아 내려옴
                        for( int k=i-1;k>=0;k--){
                            if(map[k][j]!=' '){
                                map[i][j]=map[k][j];
                                map[k][j]=' ';
                                break;
                            }
                        }
                    }
                    
                }
            }
            
            
            
        }
        return answer;
    }
}