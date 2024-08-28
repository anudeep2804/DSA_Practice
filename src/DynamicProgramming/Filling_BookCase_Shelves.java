package DynamicProgramming;

public class Filling_BookCase_Shelves {

    public int minHeightShelves(int[][] books, int shelfWidth) {

        if(books == null || books.length<1){
            return -1;
        }

        if(books[0][0]> shelfWidth) return -1;

        if(books.length == 1) return books[0][0];

        int[] dp_put = new int[books.length];
        int[] dp_DonotPut = new int[books.length];

        dp_put[0]=books[0][1];
        dp_DonotPut[0] = books[0][1];

        int currentShelfWidth = shelfWidth - books[0][0];

        for(int i=1; i<books.length; i++){

             currentShelfWidth = shelfWidth - books[i][0] - currentShelfWidth;

            if (currentShelfWidth < 0){
                dp_put[i]= dp_put[i-1]+ books[i-1][1];
                dp_DonotPut[i]= dp_DonotPut[i-1]+ books[i-1][1];
                currentShelfWidth = shelfWidth;
            }

            else {
                dp_put[i] = Math.max(books[i][1] , dp_put[i-1]);
                dp_DonotPut[i] = dp_DonotPut[i-1]+books[i][1];
            }
        }


return 0;
    }
}
