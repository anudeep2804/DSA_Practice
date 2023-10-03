package Strings;

public class RemoveColoredPieces {

    /*

    Started in the wrong direction overthinking of recursion to remove the char each item and play again ,
     the simplest solution would be just couting the number of oppurtunities for both alice and bob and see
     who has greater chance of picks
    StringBuffer tempstring = new StringBuffer();
    boolean alicepicked = false;
    boolean bobpicked= false;

    int positionofapick=1;

    int positionofbpick=1;
    
    public boolean pickingchanceofAlice(String colors , int pickpos){

        if(colors == null || colors.length()<=2){
            return false;
        }
        
        tempstring = new StringBuffer(colors);
        alicepicked=false;
        
        for(int i=positionofapick;i<tempstring.length()-1;i++) {
            char prevchar = tempstring.charAt(i - 1);
            char currentchar = tempstring.charAt(i);
            char nextchar = tempstring.charAt(i + 1);

            if (prevchar == 'A' && currentchar == 'A' && nextchar == 'A') {
                tempstring.deleteCharAt(i);
                positionofapick=i;
                alicepicked=true;
                break;
            }
        }
        
        if(alicepicked == true){
           return pickingchanceofbob(tempstring.toString(), positionofbpick-1);
        }

        return false;
        
    }
    public boolean pickingchanceofbob(String colors , int pickpos){

        if(colors == null || colors.length()<=2){
            return true;
        }

        tempstring = new StringBuffer(colors);
        bobpicked=false;
        for(int i=positionofbpick;i<tempstring.length()-1;i++) {
            char prevchar = tempstring.charAt(i - 1);
            char currentchar = tempstring.charAt(i);
            char nextchar = tempstring.charAt(i + 1);

            if (prevchar == 'B' && currentchar == 'B' && nextchar == 'B') {
                tempstring.deleteCharAt(i);
                positionofbpick=i;
                  bobpicked=true;
                break;
            }
        }

       if(bobpicked==true){
           return pickingchanceofAlice(tempstring.toString() , positionofbpick-1);
       }

       return true;

    }
    public boolean winnerOfGame(String colors) {
        boolean result= pickingchanceofAlice(colors , positionofapick);
        return result;
    } */

    public boolean winnerofGame(String colors){
        int counter_aliceschances =0;
        int counter_bobchances=0;

        if(colors == null || colors.length()<=2){
            return false;
        }

        for(int i=1;i<colors.length()-1;i++){
            char currentchar= colors.charAt(i);
            char prevchar= colors.charAt(i-1);
            char nextchar = colors.charAt(i+1);

            if(currentchar=='A'){
                if(prevchar=='A' && nextchar=='A')
                    counter_aliceschances++;
            }

            if(currentchar=='B'){
                if(prevchar=='B' && nextchar=='B')
                    counter_bobchances++;
            }
        }

        if(counter_aliceschances > counter_bobchances){
            return true;
        }

        else {
            return false;
        }
    }
}
