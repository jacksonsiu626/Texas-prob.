
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"diamond","club","heart","spade"};
	public static int [][] cardUsed = new int[52][4];
	
	private int cardNum [] = new int[2];
	private int cardSuit [] = new int[2];
	
	public Card() {
		int cardNum1;
		int cardNum2;
		int cardSuit1;
		int cardSuit2;
		do{
			cardNum1 = (int)Math.floor(Math.random()*13);
			cardSuit1 = (int)Math.floor(Math.random()*4);
		}while(cardUsed[cardNum1][cardSuit1] == 1);
		cardNum[0] = cardNum1;
		cardSuit[0] = cardSuit1;
		cardUsed[cardNum1][cardSuit1] = 1;
		do{
			cardNum2 = (int)Math.floor(Math.random()*13);
			cardSuit2 = (int)Math.floor(Math.random()*4);
		}while(cardUsed[cardNum2][cardSuit2] == 1);
		cardNum[1] = cardNum2;
		cardSuit[1] = cardSuit2;
		cardUsed[cardNum2][cardSuit2] = 1;
	}
	
	public Card(String cardNum1, String cardSuit1, String cardNum2, String cardSuit2) {
		int i,j;
		for(i=0 ; cardNum1 != cardNumVar[i] ; i++);
		for(j=0 ; cardSuit1 != cardSuitVar[j] ; j++);
		cardNum[0] = i;
		cardSuit[0] = j;
		cardUsed[i][j] = 1;
		for(i=0 ; cardNum2 != cardNumVar[i] ; i++);
		for(j=0 ; cardSuit2 != cardSuitVar[j] ; j++);
		cardNum[1] = i;
		cardSuit[1] = j;
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

	public int[] getCardNum() {
		return cardNum;
	}

	public void setCardNum(int[] cardNum) {
		this.cardNum = cardNum;
	}

	public int[] getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(int[] cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	
}
