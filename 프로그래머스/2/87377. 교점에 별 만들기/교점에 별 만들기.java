import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    class Star {
        private long y;
        private long x;

        public Star(long y, long x) {
            this.y = y;
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public long getX() {
            return x;
        }
        
        public String toString() {
            return "(" + y + ", " + x + ")";
        }
    }
    
    public String[] solution(int[][] line) {
        double A, B, C, D, E, F, yf, xf;
        long y, x, max_y = Long.MIN_VALUE, max_x = Long.MIN_VALUE, min_y = Long.MAX_VALUE, min_x = Long.MAX_VALUE;
        List<Star> stars = new ArrayList<>();
        
        for (int i = 0; i < line.length - 1; i++) {
            A = line[i][0];
            B = line[i][1];
            E = line[i][2];
            
            for (int j = i + 1; j < line.length; j++) {
                C = line[j][0];
                D = line[j][1];
                F = line[j][2];
                
                xf = (B * F - E * D) / (A * D - B * C);
                yf = (E * C - A * F) / (A * D - B * C);
                
                if (!(yf % 1 == 0 && xf % 1 == 0))
                    continue;
                
                y = (long) yf;
                x = (long) xf;
                
                max_y = Math.max(y, max_y);
                max_x = Math.max(x, max_x);
                min_y = Math.min(y, min_y);
                min_x = Math.min(x, min_x);
                    
                stars.add(new Star(y, x));
            }
        }
        
        char[][] field = new char[(int)(max_y - min_y) + 1][(int)(max_x - min_x) + 1];
        
        for (int i = 0; i < field.length; i++)
            Arrays.fill(field[i], '.');
        
        for (Star star: stars)
            field[(int)(star.getY() - min_y)][(int)(star.getX() - min_x)] = '*';
        
        String[] answer = new String[field.length];
        
        for (int i = 0; i < field.length; i++)
            answer[field.length - i - 1] = new String(field[i]);
        
        return answer;
    }
}