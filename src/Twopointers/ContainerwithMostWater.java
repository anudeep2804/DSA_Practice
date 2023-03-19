package Twopointers;

public class ContainerwithMostWater {
    public static int maxArea(int[] height) {

        int i=0;
        int j=height.length-1;

        int maxarea=0;
        int currentarea=1;

        while(i<=j){

            int width=j-i;
            int heightdiff=Math.min(height[j],height[i]);

            currentarea=heightdiff*width;

            if(height[i]<=height[j]){
                i++;
            }

            else if(height[i]>height[j]){
                j--;
            }

            if(maxarea<currentarea){
                maxarea=currentarea;
            }
        }


        return maxarea;
    }

    public static void main(String[] args) {
        int[] input = {0,2};
        int ans= maxArea(input);
        System.out.println(ans);
    }
}
