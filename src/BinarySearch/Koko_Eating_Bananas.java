package BinarySearch;

class Koko_Eating_Bananas {

    /*
     K will always be in the range of [1,max(piles)] , so assuming an array of
     elements from 1,max(piles) for k try binary search and see if the selected
     value would satisfy the requirement of hours

     for ex: k=3 cannot satisfy the hours and need more hours so anything less than 3 would not work , so accordingly keep moving mid to find the required answer
    */
    public int minEatingSpeed(int[] piles, int h) {
        int min=1,max=0,mid=0;
        for (int pile : piles)
            max=Math.max(pile,max);

        while(min<=max)
        {
            mid=((max-min)/2+min);
            if (checkIfTrue(piles, h, mid))
                max=mid-1;
            else
                min=mid+1;
        }
        return min;
    }

    public boolean checkIfTrue(int[] piles,int h,int mid)
    {
        int i=0,count=0;
        for(int pile:piles)
        {
            if(count>h) return false;
            count+=pile/mid;
            if (pile%mid!=0) count++;
        }

        if (count<=h)
            return true;
        return false;
    }
}
