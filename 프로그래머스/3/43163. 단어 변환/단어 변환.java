import java.util.*;

class Solution {
    
    static class Node {
        String word;
        int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (begin.equals(target)) return 1;
        // begin -> target
        // 가장 짧은 변환
        
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.word.equals(target)) {
                return now.depth;
            }
            
            for (int i=0; i<words.length; ++i) {
                if (!visited[i] && check(now.word, words[i])) {
                    q.add(new Node(words[i], now.depth+1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    boolean check(String begin, String target) {
        char[] a = begin.toCharArray();
        char[] b = target.toCharArray();
        
        int cnt=0;
        for (int i=0; i<a.length; ++i) {
            if (a[i] == b[i]) cnt++;
        }
        
        if (cnt == a.length-1) return true;
        return false;
    }
}