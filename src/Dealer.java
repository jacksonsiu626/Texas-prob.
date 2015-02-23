
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
		System.out.println("===== After sorting ======");
	}

	public int [] checkCardType(Card [] playerCards){
		Card [] cardComb = new Card[7];
		cardComb[0] = playerCards[0];
		cardComb[1] = playerCards[1];
		for(int i=2 ; i<cardComb.length ; i++){
			cardComb[i] = communityCards[i-2];
		}
		playerCards = Sort.sort(cardComb);
			for(int j=0 ; j<playerCards.length ; j++)
				System.out.print(Card.cardNumVar[playerCards[j].getCardNum()]+Card.cardSuitVar[playerCards[j].getCardSuit()]+" / ") ;
			System.out.print("\n") ;

		return checkStraightFlush(cardComb);
	}

	public int [] checkStraightFlush(Card [] playerCard){ //[type][biggest number][flush]
		int [] tempFlush = checkFlush(playerCard);
		int [] tempStraight = checkStraight(playerCard);
		if( tempFlush[0] > 0 && tempStraight[0] > 0){
			int [] temp = new int [2];
			temp[0] = 8;
			temp[1] = tempStraight[1];
			return temp;
		}else if(tempStraight[0] > 0){
			return tempStraight;
		}else
			return checkFourKind(playerCard);
	}
	
	public int [] checkFourKind(Card [] playerCards){
		
	}
	
	public int [] checkFullHouse(Card [] playerCards){
		
	}
	
	public int [] checkFlush(Card [] playerCards){ //[type][biggest card][2nd card][3rd card][4th card][5th card]
		
	}

	public int [] checkStraight(Card [] playerCards){ //[type][biggest card]
		int i,j;
		for(i=0 ; i < 3 ; i++){
			for(j=0 ; j<4 ; j++)
				if( (playerCards[j].getCardNum()+1) != playerCards[j+1].getCardNum())
					break;
			if(j>=4)
				break;
		}
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
