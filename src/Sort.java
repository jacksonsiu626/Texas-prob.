public class Sort {
     
    private static Card[] array;
    private static Card[] tempMergArr;
    private static int length;
     
    public static Card [] sort(Card [] playerComb) {
        array = playerComb;
        length = playerComb.length;
        tempMergArr = new Card[length];
        doMergeSort(0, length - 1);
        return array;
    }
 
    private static void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i].getCardNum() < tempMergArr[j].getCardNum()) {
                array[k] = tempMergArr[i];
                i++;
            }else if(tempMergArr[i].getCardNum() == tempMergArr[j].getCardNum()) {
            	if(tempMergArr[i].getCardSuit() < tempMergArr[j].getCardSuit()) {
	                array[k] = tempMergArr[i];
	                i++;
            	}else{
                    array[k] = tempMergArr[j];
                    j++;
            	}
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}
