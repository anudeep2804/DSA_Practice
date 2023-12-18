package ArraysandHashing;

public class FindIndexOfFirstOccurrence {

    public int strStr( String haystack , String needle){
        if(needle.length() > haystack.length()){
            return -1;
        }

        for( int i=0 ; i<=haystack.length()-needle.length();i++){
            // System.out.println(haystack.substring(i, i+needle.length()));
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }

        return  -1;
    }
}
