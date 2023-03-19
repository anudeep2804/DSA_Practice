package ArraysandHashing;

import java.util.HashMap;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // checking horizantal rows
        for(int i=0;i<9;i++){
            HashMap<Character,Integer> map= new HashMap<>();
        for(int j=0;j<9;j++){
            if(board[i][j]=='.'){
                continue;
            }
            if(map.containsKey(board[i][j])){
                return false;

            }
            else{
                map.put(board[i][j],1);
            }
        }
        }

        // checking vertical rows
        for(int j=0;j<9;j++){
            HashMap<Character,Integer> map= new HashMap<>();
            for(int i=0;i<9;i++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(map.containsKey(board[i][j])){
                    return false;
                }
                else{
                    map.put(board[i][j],1);
                }
            }
        }

        // check 3*3 bits

        int a=0,b=0;

        while(a<9&&b<9){

            HashMap<Character,Integer> hashMap=new HashMap<>();
            for(int i=a;i<3+a;i++) {

                for(int j=b;j<b+3;j++){
                    if(board[i][j]=='.'){
                        continue;
                    }
                    if(hashMap.containsKey(board[i][j])){
                        return false;
                    }
                    else{
                        hashMap.put(board[i][j],1);
                    }
                }

            }

            b=b+3;
            if(b==9){
                b=0;
                a=a+3;
            }

        }

        return true;
    }
}
