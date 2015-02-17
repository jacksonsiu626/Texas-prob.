
public class Card {
	private String [] cardNum;
	private String [] cardSuit;
	
	public Card(String cardNum1, String cardSuit1, String cardNum2, String cardSuit2) {
		cardNum[0] = cardNum1;
		cardNum[1] = cardNum2;
		cardSuit[0] = cardSuit1;
		cardSuit[1] = cardSuit2;
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
