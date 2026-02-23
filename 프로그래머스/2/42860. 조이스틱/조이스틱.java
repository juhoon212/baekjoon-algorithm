class Solution {
    public int solution(String name) {
        // A-Z
        // A에서 아랫쪽으로 이동하면 Z
        // 맨 처음은 name의 갯수에 따라서 ex) 3글자면 AAA
        // J 까지는 위로 9번 조작하여 J를 완성 가능
        char[] c = name.toCharArray();
        // ABCDEFGHIJKLMNOPQRSTUVWXYZ 총 26개
        // B와 Z 사이를 나누면 J까지가 가운데
        //System.out.println('J' - 'A'); 
        
        int currentCursor = 0;
        int move = c.length-1;
        for (int i=0; i<c.length; ++i) {
            // 현재 커서
            currentCursor += min(c[i]);
            
            int nextCursor = i+1;
            while (nextCursor < c.length && c[nextCursor] == 'A') {
                nextCursor++;
            }
            
            move = Math.min(move, (c.length - nextCursor) + (i * 2));
            move = Math.min(move, (c.length - nextCursor) * 2 + i);
        }
        
        return currentCursor + move;
    }
    
    int min(char c) {
        if (c - 'A' < 'Z' - c+1) {
            return c - 'A';
        } else {
            return 'Z' - c + 1;
        }
    }
}