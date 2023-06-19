package Recursion;

public class RemoveAs {

    public  static String RemoveAllAs ( String s , StringBuilder stringBuilder  , int i ) {

        if(i==s.length()){
            return  stringBuilder.toString();
        }

        if(s.charAt(i)!='a'){
            stringBuilder.append(s.charAt(i));
        }

        return RemoveAllAs(s,stringBuilder,++i);
    }

    public static void main(String[] args) {
        String s = "ababcda";
        StringBuilder stringBuilder = new StringBuilder();
        String ans = RemoveAllAs(s,stringBuilder,0);
        System.out.println(ans);

    }




}

