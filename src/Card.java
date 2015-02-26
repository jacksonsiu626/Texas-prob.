
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"d","c","h","s"};
	public static int [][] cardArr = null;
	public static int index = cardArr.length-1;
	
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
		}
		
		int rand = (int)Math.floor(Math.random()*index);
		this.cardNum = cardArr[rand][0];
		this.cardSuit = cardArr[rand][1];
		cardArr[rand] = cardArr[index];
		cardArr[index][0] = this.cardNum;
		cardArr[index][1] = this.cardSuit;
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
		}
		this.cardNum = cardNum;
		this.cardSuit = cardSuit;
		cardArr[cardNum][cardSuit] = 1;
	}

	public static int[][] getcardArr() {
		return cardArr;
	}

	public static void setcardArr(int[][] cardArr) {
		Card.cardArr = cardArr;
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
