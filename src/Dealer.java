
public class Dealer {
	private static  int numOfPlayer;
	private static Card [][] cardArr;
	private static Card [] communityCards;
	private static int [][] playerComp;
	
	public Dealer(int numOfPlayer){
		this.numOfPlayer = numOfPlayer;
		playerComp = new int [numOfPlayer+1][5];
		cardArr = new Card[numOfPlayer+1][2];
		dealCard();
		for(int i=0; i<numOfPlayer+1; i++)
			checkCardType(cardArr[i]);
	}
	
	public Card [][] dealCard(){
		communityCards = new Card [5];
		cardArr[0][0] = new Card("A","diamond");
		cardArr[0][1] = new Card("A","club");
		for(int i=1 ; i<numOfPlayer+1 ; i++){
			cardArr[i][0] = new Card();
			cardArr[i][1] = new Card();
		}
		for(int i=0 ; i<5 ; i++){
			communityCards[i] = new Card();
		}
		cardTranslate();

		return cardArr;
	}

	public void cardTranslate(){
		for(int i=0 ; i<5 ; i++){
			System.out.println(Card.cardNumVar[communityCards[i].getCardNum()]+" - "+Card.cardSuitVar[communityCards[i].getCardSuit()]);
		}
			System.out.println("============");
		for(int i=0 ; i<numOfPlayer+1 ; i++){
			System.out.print(Card.cardNumVar[cardArr[i][0].getCardNum()]+" - "+Card.cardSuitVar[cardArr[i][0].getCardSuit()]+" / ") ;
			System.out.println(Card.cardNumVar[cardArr[i][1].getCardNum()]+" - "+Card.cardSuitVar[cardArr[i][1].getCardSuit()]) ;
		}
	}

	public int [] checkCardType(Card [] playerCards){
		
	}
	
	public int [] checkStraightFlush(Card [] playerCard){ //[type][biggest number][flush]
		int checkFlush(playerCard);
		if( checkFlush() != null && checkStraight() !=null)
			return true;
		else
			return false;
	}
	
	public int [] checkFourKind(Card [] playerCards){
		
	}
	
	public int [] checkFullHouse(Card [] playerCards){
		
	}
	
	public int [] checkFlush(Card [] playerCards){
		
	}

	public int [] checkStraight(Card [] playerCards){
		
	}
	
	public int [] checkThreeKind(Card [] playerCards){
		
	}
	
	public int [] checkTwoPair(Card [] playerCards){
		
	}
	
	public int [] checkPair(Card [] playerCards){
		
	}
	
	public int [] checkHighCard(Card [] playerCards){
		
	}
}
