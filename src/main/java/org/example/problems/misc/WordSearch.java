package org.example.problems.misc;
/*
   https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(0 == m || word == null){
            return false;
        }
        int n = board[0].length;

        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && visited[i][j]!=1){
                    if(checkWordExist(i,j, board,word, visited,0, m, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWordExist(int i, int j, char[][] board, String word,int visited[][],
                                   int index, int m, int n){
        int directions[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        if(index>= word.length()){
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] == 1){
            return false;
        }
        if(word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = 1;
        boolean flag = false;
        for(int it=0;it<directions.length;it++){
            flag = flag || checkWordExist(i+directions[it][0], j+directions[it][1], board, word, visited, index+1, m, n);
        }
        if(!flag){
            visited[i][j] = 0;
        }
        return flag;
    }
}


