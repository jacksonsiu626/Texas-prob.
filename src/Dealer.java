
public class Dealer {
	private static  int numOfPlayer;
	
	public Dealer(int numOfPlayer){
		this.numOfPlayer = numOfPlayer;
		dealCard();
	}
	
	public Card [] dealCard(){
		Card [] cardArr = new Card[numOfPlayer+1];

		cardArr[0] = new Card("A","diamond","A","club");
		for(int i=1 ; i<numOfPlayer+1 ; i++){
			cardArr[i] = new Card();
		}
		cardTranslate(cardArr);
		return cardArr;
	}
	
	public void cardTranslate(Card [] cardArr){
		for(int i=0 ; i<numOfPlayer+1 ; i++){
			System.out.print(Card.cardNumVar[cardArr[i].getCardNum()[0]]+" - "+Card.cardSuitVar[cardArr[i].getCardSuit()[0]]+" / ") ;
			System.out.println(Card.cardNumVar[cardArr[i].getCardNum()[1]]+" - "+Card.cardSuitVar[cardArr[i].getCardSuit()[1]]) ;
		}
	}
}
