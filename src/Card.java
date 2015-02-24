
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"d","c","h","s"};
	public static int [][] cardUsed;
	
	private int cardNum;
	private int cardSuit;
	
	public Card() {
		cardUsed= new int[52][4];
		int cardNum;
		int cardSuit;
		do{
			cardNum = (int)Math.floor(Math.random()*13);
			cardSuit = (int)Math.floor(Math.random()*4);
		}while(cardUsed[cardNum][cardSuit] == 1);
		this.cardNum = cardNum;
		this.cardSuit = cardSuit;
		cardUsed[cardNum][cardSuit] = 1;
	}
	
	public Card(int cardNum, int cardSuit) {
		cardUsed= new int[52][4];
		this.cardNum = cardNum;
		this.cardSuit = cardSuit;
		cardUsed[cardNum][cardSuit] = 1;
	}

	public static int[][] getCardUsed() {
		return cardUsed;
	}

	public static void setCardUsed(int[][] cardUsed) {
		Card.cardUsed = cardUsed;
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
