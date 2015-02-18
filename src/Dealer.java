
public class Dealer {
	private static  int numOfPlayer;
	
	public Dealer(int numOfPlayer){
		this.numOfPlayer = numOfPlayer;
	}
	
	public Card [] dealCard(){
		Card [] cardArr = new Card[numOfPlayer+1];
		for(int i=1 ; i<numOfPlayer+1 ; i++){
			cardArr[i] = new Card();
		}
		return cardArr;
	}
}
