package ArraysandHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeString {
    final char Delimiter='#';
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            sb.append(s.length());
            sb.append(Delimiter);
            sb.append(s);
        }

        return  sb.toString();
    }


    public List<String> decode(String s) {

        ArrayList<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();

        int Integervalue= Integer.valueOf(arr[0]);

        int i=1;
        int j=0;

        while (i< arr.length){
            if(arr[i]==Delimiter){
                Integervalue=(Integer.valueOf(arr[i-1]))-'0';
            }


            StringBuilder str= new StringBuilder();

            for( j=i+1;j<Integervalue+i+1;j++){
                str.append(arr[j]);
            }



            res.add(str.toString());
            i=j+1;


        }

        return res;
    }

    public static void main(String[] args) {
        List<String> input= new ArrayList<>();
        input.add("Hello");
        input.add("World");
        input.add("Anudeep");

        EncodeandDecodeString encodeandDecodeString= new EncodeandDecodeString();
        String output= encodeandDecodeString.encode(input);
        System.out.println(output);
        List<String> output_decode= encodeandDecodeString.decode(output);
        System.out.println(output_decode);

    }
}
