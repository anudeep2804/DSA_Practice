package BinarySearch;

public class Capacity_To_Ship_Packages_WithinDdays {

        public int shipWithinDays(int[] weights, int days) {

            int left = 0;
            int right =0;

            for(int weight : weights){

                left = Math.max(left , weight);
                right = right+weight;
            }

            while(left<=right){

                int mid = left + (right-left)/2;

                if(checkLimit(weights, days, mid)){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }

            return left;
        }

        public boolean checkLimit(int[] weights, int days, int limit)
        {
            int sum=0;
            int count=1;
            for(int i=0;i<weights.length;i++)
            {
                if(count > days) return false;
                if(sum+weights[i]>limit)
                {
                    count+=1;
                    sum=0;
                }
                sum+=weights[i];
            }

            //  System.out.println(count + " ," + limit);
            return (days>=count);
        }

}
