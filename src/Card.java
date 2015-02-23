
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"diamond","club","heart","spade"};
	public static int [][] cardUsed = new int[52][4];
	
	private int cardNum;
	private int cardSuit;
	
	public Card() {
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
	
	public Card(String cardNum, String cardSuit) {
		int i,j;
		for(i=0 ; cardNum != cardNumVar[i] ; i++);
		for(j=0 ; cardSuit != cardSuitVar[j] ; j++);
		this.cardNum = i;
		this.cardSuit = j;
		cardUsed[i][j] = 1;
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
