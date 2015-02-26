
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"d","c","h","s"};
	public static int [][] cardArr = null;
	public static int index;
	
	private int cardNum;
	private int cardSuit;
	
	public Card() {
		if(cardArr == null){
			cardArr = new int [52][2];
			int count =0;
			for(int i=0 ; i<13 ; i++){
				for(int j=0 ; j<4 ; j++){
					cardArr[count][0]=i;
					cardArr[count++][1]=j;
				}
			}
			index = cardArr.length-1;
		}
		//Swapping
		int rand = (int)Math.floor(Math.random()*index);
		System.out.println("Before: "+cardArr[index][0] +","+cardArr[index][1]+"  "+index);
		this.cardNum = cardArr[rand][0];
		this.cardSuit = cardArr[rand][1];
		cardArr[rand] = cardArr[index];
		cardArr[index][0] = this.cardNum;
		cardArr[index][1] = this.cardSuit;
		//End Swapping
		System.out.println("Card: "+cardArr[index][0] +","+cardArr[index][1]+"  "+index);
		if(index > 0)
			index--;
	}
	
	public Card(int cardNum, int cardSuit) {
		if(cardArr == null){
			cardArr = new int [52][2];
			int count =0;
			for(int i=0 ; i<13 ; i++){
				for(int j=0 ; j<4 ; j++){
					cardArr[count][0]=i;
					cardArr[count++][1]=j;
				}
			}
			index = cardArr.length-1;
		}
	
		//Swapping
		this.cardNum = cardNum;
		this.cardSuit = cardSuit;
		cardArr[cardNum*4 + cardSuit] = cardArr[index];
		cardArr[index][0] = cardNum;
		cardArr[index][1] = cardSuit;
		//End Swapping
		
		if(index > 0){
			index--;
		}
	}

	public static String[] getCardNumVar() {
		return cardNumVar;
	}

	public static void setCardNumVar(String[] cardNumVar) {
		Card.cardNumVar = cardNumVar;
	}

	public static String[] getCardSuitVar() {
		return cardSuitVar;
	}

	public static void setCardSuitVar(String[] cardSuitVar) {
		Card.cardSuitVar = cardSuitVar;
	}

	public static int[][] getCardArr() {
		return cardArr;
	}

	public static void setCardArr(int[][] cardArr) {
		Card.cardArr = cardArr;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Card.index = index;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public int getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(int cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	
}
