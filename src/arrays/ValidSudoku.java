package arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
	public boolean solution(char[][] board) {
        Set<String> seenBefore = new HashSet<String>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char val = board[i][j];
                if(val != '.'){
                   if(!seenBefore.add(val + " is  in row " + i) || 
                        !seenBefore.add(val + " is  in col " + j) ||
                        !seenBefore.add(val + " is  in box " + i/3 + "," +j/3)){
                       return false;
                   }
                }
                
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		ValidSudoku validSudoku = new ValidSudoku();
		
		System.out.println(validSudoku.solution(new char[][]{{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}}));
		
		System.out.println(validSudoku.solution(new char[][]{{'8','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}}));
		
	}
}
