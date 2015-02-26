
public class Dealer {
	public static String [] combination = {"High Card","Pair","Two Pair","Three Kind","Straight","Flush","Full House","Four Kind","Straight Flush"};
	private static  int numOfPlayer;
	private static Card [][] cardArr;
	private static Card [] communityCards;
	private static int [] playCards;
	public static boolean playerWin;
	
	public Dealer(int numOfPlayer, int [] playerCardNum, int [] playerCardSuit){
		playerWin=true;
		this.numOfPlayer = numOfPlayer;
		cardArr = new Card[numOfPlayer+1][2];
		dealCard(playerCardNum, playerCardSuit);
		playCards = checkCardType(cardArr[0]);
		for(int i=1; i<numOfPlayer+1; i++){
			int [] temp = checkCardType(cardArr[i]);
			if( playCards[0] < temp[0] ){
				playerWin=false;
			}else if(playCards[0] == temp[0]){
				if(playCards[0]==0){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==1){
					if(temp[2] > playCards[2])
						playerWin=false;
				}else if(playCards[0]==2){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==3){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==4){
						if(temp[1] > playCards[1])
							playerWin=false;
				}else if(playCards[0]==5){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==6){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==7){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}else if(playCards[0]==8){
					for(int j=1 ; j<playCards.length ; j++){
						if(temp[j] > playCards[j])
							playerWin=false;
					}
				}
			}
		}
		Card.setCardArr(null); 
	}

	public void dealCard(int [] playerCardNum, int [] playerCardSuit){
		cardArr[0][0] = new Card(playerCardNum[0],playerCardSuit[0]);
		cardArr[0][1] = new Card(playerCardNum[1],playerCardSuit[1]);
		for(int i=1 ; i<numOfPlayer+1 ; i++){
			cardArr[i][0] = new Card();
			cardArr[i][1] = new Card();
		}
		communityCards = new Card [5];
		for(int i=0 ; i<5 ; i++){
			communityCards[i] = new Card();
		}
		//cardTranslate();
	}

	public void cardTranslate(){
		for(int i=0 ; i<5 ; i++){
			System.out.println(Card.cardNumVar[communityCards[i].getCardNum()]+","+communityCards[i].getCardSuit());
		}
			System.out.println("============");
		for(int i=0 ; i<numOfPlayer+1 ; i++){
			System.out.print(Card.cardNumVar[cardArr[i][0].getCardNum()]+","+cardArr[i][0].getCardSuit()+" / ") ;
			System.out.println(Card.cardNumVar[cardArr[i][1].getCardNum()]+","+cardArr[i][1].getCardSuit()) ;
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
			//for(int j=0 ; j<playerCards.length ; j++)
			//	System.out.print(Card.cardNumVar[playerCards[j].getCardNum()]+","+playerCards[j].getCardSuit()+",") ;
		
		int [] check;
		if( (check=checkStraightFlush(cardComb)) != null){
		}else if( (check=checkFourKind(cardComb)) != null){
		}else if( (check=checkFullHouse(cardComb)) != null){
		}else if( (check=checkFlush(cardComb)) != null){
		}else if( (check=checkStraight(cardComb)) != null){
		}else if( (check=checkThreeKind(cardComb)) != null){
		}else if( (check=checkTwoPair(cardComb)) != null){
		}else if( (check=checkPair(6,cardComb)) != null){
		}else if( (check=checkHighCard(cardComb)) != null){
		}
		//System.out.println(" :: "+combination[check[0]]) ;
		return check;
	}

	public int [] checkStraightFlush(Card [] playerCard){ //[type][biggest number]
		int [] tempFlush = checkFlush(playerCard);
		int [] tempStraight = checkStraight(playerCard);
		
		if( tempFlush != null && tempStraight != null ){
			if((tempFlush[1] == tempFlush[2]+1) && (tempFlush[2] == tempFlush[3]+1) 
			&& (tempFlush[3] == tempFlush[4]+1) && (tempFlush[4] == tempFlush[5]+1)){
				int [] temp = new int [2];
				temp[0] = 8;
				temp[1] = tempStraight[1];
				return temp;
			}
		}
		if(tempStraight != null && tempFlush ==null){ 
			return tempStraight;
		}else
			return null;
	}
	
	public int [] checkFourKind(Card [] playerCards){ //type,fourkind,largest
		int i;
		int [] temp = new int[3];
		boolean isFourKind=false;
		for(i=0 ; i<4 ; i++){
			if( playerCards[i].getCardNum() == playerCards[i+1].getCardNum() 
			 && playerCards[i+1].getCardNum() == playerCards[i+2].getCardNum()
			 && playerCards[i+2].getCardNum() == playerCards[i+3].getCardNum()){
				isFourKind=true;
				break;
			}
		}
		if(isFourKind){
			temp[0] = 7;
			temp[1] = playerCards[i].getCardNum();
			if(i==3)
				temp[2] = playerCards[2].getCardNum();
			else
				temp[2] = playerCards[6].getCardNum();
			return temp;
		}else
			return null;
			
	}
	
	public int [] checkFullHouse(Card [] playerCards){ //[type][three kind card][pair]
		int [] temp = new int[3];
		temp[1] = -1;
		for(int i=6 ; i>=2 ; i--){
			if(playerCards[i].getCardNum() == playerCards[i-1].getCardNum() && playerCards[i-1].getCardNum() == playerCards[i-2].getCardNum()){
				temp[1] = playerCards[i].getCardNum();
				break;
			}
		}
		if(temp[1] == -1)
			return checkFlush(playerCards);
		else{
			temp[2] = -1;
			for(int i=6 ; i>=1 ; i--){
				if(playerCards[i].getCardNum() != temp[1] && playerCards[i].getCardNum() == playerCards[i-1].getCardNum()){
					temp[2] = playerCards[i].getCardNum();
					break;
				}
			}
		}
		
		if(temp[2] == -1)
			return null;
		else{
			temp[0] = 6;
			return temp;
		}
	}
	
	public int [] checkFlush(Card [] playerCards){ //[type][biggest card][2nd card][3rd card][4th card][5th card]
		int [] temp = new int[6];
		int [] suit = new int[4];
		int flush=-1;
		for(int i=0 ; i<7 ; i++){
			suit[playerCards[i].getCardSuit()]++;
			if(suit[playerCards[i].getCardSuit()] >=5 ){
				flush=playerCards[i].getCardSuit();
				temp[0]=5;
				break;
			}
		}
		if(flush == -1)
			return null;
		int count=1;
		for(int i=6 ; i>=0 ; i--){
			if( playerCards[i].getCardSuit() == flush ){
				temp[count++]=playerCards[i].getCardNum();
				if(count == 6)
					break;
			}
		}
		
		if(temp[0] != 5)
			return null;
		else
			return temp;
	}

	public int [] checkStraight(Card [] playerCards){ //[type][largest card]
		int [] temp = new int[2];
		int [] trim = new int[7];
		int count=0;
		for(int i=0 ; i<7 ; i++){
			if(i < 6 && (playerCards[i].getCardNum() == playerCards[i+1].getCardNum()))
				continue;
			else
				trim[count++] = playerCards[i].getCardNum();
		}
		
		if( ((trim[3] == 3) && (trim[2] == 2) && (trim[1] == 1) && (trim[0] == 0) && (trim[count-1] == 12)) ){ //A2345
			temp[0] = 4;
			temp[1] = 3;
		}
			
		for(int i=count-1 ; i>=4 ; i--){
			if( ((trim[i] == trim[i-1]+1) && (trim[i-1] == trim[i-2]+1) && (trim[i-2] == trim[i-3]+1) && (trim[i-3] == trim[i-4]+1))
			){
				temp[0] = 4;
				temp[1] = playerCards[i].getCardNum();
				break;
			}
		}
		
		if(temp[0] != 4)
			return null;
		else
			return temp;
	}
	
	public int [] checkThreeKind(Card [] playerCards){ //type,three kind, largest card, 2nd largest card
		int [] temp = new int[4];
		for(int i=6 ; i>=2 ; i--){
			if(playerCards[i].getCardNum() == playerCards[i-1].getCardNum()
			&& playerCards[i-1].getCardNum() == playerCards[i-2].getCardNum()
			){
				temp[0] = 3;
				temp[1] = playerCards[i].getCardNum();
				break;
			}
		}
		if(temp[0] == 3){
			if(playerCards[6].getCardNum() == temp[1]){
				temp[2] = playerCards[3].getCardNum();
				temp[3] = playerCards[2].getCardNum();
			}else if(playerCards[5].getCardNum() == temp[1] && playerCards[6].getCardNum() != temp[1]){
				temp[2] = playerCards[6].getCardNum();
				temp[3] = playerCards[2].getCardNum();
			}else{
				temp[2] = playerCards[6].getCardNum();
				temp[3] = playerCards[5].getCardNum();
			}
			return temp;
		}else
			return null;
	}
	
	public int [] checkTwoPair(Card [] playerCards){ //type,1st pair,2nd pair
		int [] temp = new int [3];
		int [] pair1;
		int [] pair2;

		pair1 = checkPair(6,playerCards);
		if(pair1 == null)
			return null;
		pair2 = checkPair(pair1[1]-1,playerCards);
		
		if(pair2 == null)
			return null;
		else{
			temp[0] = 2;
			temp[1] = pair1[2];
			temp[2] = pair2[2];
			return temp;
		}
	}
	
	public int [] checkPair(int index , Card [] playerCards){ // type,index,cardnum
		int [] temp = new int[3];
		
		for(int i=index ; i>=1 ; i--){
			if( playerCards[i].getCardNum() == playerCards[i-1].getCardNum() ){
				temp[0] = 1;
				temp[1] = i-1;
				temp[2] = playerCards[i].getCardNum();
				break;
			}
		}
		
		if(temp[0] != 1)
			return null;
		else{
			return temp;
		}
	}
	
	public int [] checkHighCard(Card [] playerCards){ // type,1st,2nd,3rd,4th,5th
		int [] temp = {0,playerCards[6].getCardNum(),
							playerCards[5].getCardNum(),
							playerCards[4].getCardNum(),
							playerCards[3].getCardNum(),
							playerCards[2].getCardNum()};
		return temp;
	}
}
