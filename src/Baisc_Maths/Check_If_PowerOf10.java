package Baisc_Maths;

public class Check_If_PowerOf10 {

    static boolean isPowerOf10( int x){
        if(x<10 || x%10 !=0){
            return false;
        }

        while(x % 10 ==0){
            x=x/10;
        }

        return (x==1) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf10(200));
    }
}
