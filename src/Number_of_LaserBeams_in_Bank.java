public class Number_of_LaserBeams_in_Bank {

    public int numberOfBeams(String[] bank) {

        int result=0;

        int currentrowcount =0;

        int prevrowcount=0;

        for(int i=0;i<bank.length;i++){
            char[] temp = bank[i].toCharArray();

            currentrowcount=0;

            for(int j=0; j<temp.length; j++){
                if(temp[j]=='1'){
                    currentrowcount= currentrowcount+1;
                }


            }

            if(currentrowcount==0){
                continue;
            }

            result=result+ currentrowcount*prevrowcount;

            prevrowcount=currentrowcount;
        }

        return result;

    }

}
