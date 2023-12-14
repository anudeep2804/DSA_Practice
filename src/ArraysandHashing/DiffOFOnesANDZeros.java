package ArraysandHashing;

public class DiffOFOnesANDZeros {

    public int[][] onesMinusZeros(int[][] grid) {

        int[][] result = new int[grid.length][grid[0].length];

        int[] sumofonesrows = new int[grid.length];
        int[] sumofonecol = new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            sumofonesrows[i] = calculatesum(grid[i]);
        }

        for(int i=0;i< grid[0].length;i++){ // cols

            int sumcol =0;
            for(int j=0; j< grid.length;j++) { // rows
                sumcol = sumcol + grid[j][i];
            }

            sumofonecol[i] = sumcol;


        }


        for(int i=0;i< grid.length ;i++){
            for(int j=0 ; j<grid[i].length;j++){
                result[i][j] = 2*(sumofonesrows[i] + sumofonecol[j]) - grid.length - grid[0].length;
            }
        }

     return result;
    }

    int calculatesum(int[] arr){
        int sum =0;

        for(int n : arr){
            sum=sum+n;
        }

        return sum;
    }
}
