
public class Card {
	public static String [] cardNumVar = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuitVar = {"diamond","club","heart","spade"};
	public static int [][] cardUsed;
	
	private String [] cardNum;
	private String [] cardSuit;
	
	public Card(String cardNum1, String cardSuit1, String cardNum2, String cardSuit2) {
		cardNum[0] = cardNum1;
		cardNum[1] = cardNum2;
		cardSuit[0] = cardSuit1;
		cardSuit[1] = cardSuit2;
		int i,j;
		for(i=0 ; cardNum1 != cardNumVar[i] ; i++);
		for(j=0 ; cardSuit1 != cardSuitVar[j] ; j++);
		cardUsed[i][j] = 1;
		for(i=0 ; cardNum2 != cardNumVar[i] ; i++);
		for(j=0 ; cardSuit2 != cardSuitVar[j] ; j++);
		cardUsed[i][j] = 1;
	}
	
	public Card() {
		int cardNum1;
		int cardNum2;
		int cardSuit1;
		int cardSuit2;
		do{
			cardNum1 = (int)Math.floor(Math.random()*13);
			cardSuit1 = (int)Math.floor(Math.random()*4);
		}while(cardUsed[cardNum1][cardSuit1] != 1);
		do{
			cardNum2 = (int)Math.floor(Math.random()*13);
			cardSuit2 = (int)Math.floor(Math.random()*4);
		}while(cardUsed[cardNum2][cardSuit2] != 1);
		cardNum[0] = cardNumVar[cardNum1];
		cardNum[1] = cardNumVar[cardNum2];
		cardSuit[0] = cardNumVar[cardSuit1];
		cardSuit[1] = cardNumVar[cardSuit2];
		cardUsed[cardNum1][cardSuit1] = 1;
		cardUsed[cardNum2][cardSuit2] = 1;
	}
	
	public String [] getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum1, String cardNum2) {
		cardNum[0] = cardNum1;
		cardNum[1] = cardNum2;
	}
	public String [] getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(String cardSuit1, String cardSuit2) {
		cardSuit[0] = cardSuit1;
		cardSuit[1] = cardSuit2;
	}
	
	
}
