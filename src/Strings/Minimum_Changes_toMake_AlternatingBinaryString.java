package Strings;

public class Minimum_Changes_toMake_AlternatingBinaryString {

    public int minOperations(String s) {
        int with_startzero =0;
        int with_startone=0;

        for(int i=0 ; i<s.length(); i++){

            if(i%2==0 && s.charAt(i)!='0') with_startzero++;
            else  if (i%2!=0 && s.charAt(i)!='1') with_startzero++;
        }

        System.out.println(with_startzero);

        for(int i=0 ; i<s.length(); i++){
            if(i%2==0 && s.charAt(i)!='1') with_startone++;
            else if (i%2!=0 && s.charAt(i)!='0') with_startone++;
        }

        return Math.min(with_startone , with_startzero);
    }

}
