import java.util.Scanner;


public class Main {
	public static String [] cardNum = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public static String [] cardSuit = {"D","C","H","S"};
	public static int numOfCase = 1;
	
	public static void main(String args[] ){
		//YourCard yourCard = new YourCard("A","spade","K","spade");
		String [][] card = new String[52][2];

		Scanner read = new Scanner(System.in);
		String str;
		int numOfPlayer=0;
		
		while(numOfPlayer<=0 || numOfPlayer>=1000 ){
			System.out.println("Num Of player(not include yourself): ");
			str = read.nextLine();
			numOfPlayer = Integer.parseInt(str);
		}

		 //long begintime = System.currentTimeMillis();
		int sum=0;
		/*
		for(int i=0 ; i<Card.cardNumVar.length ; i++){
			for(int j=i ; j<Card.cardNumVar.length ; j++){
				System.out.println(Card.cardNumVar[i]+" - "+Card.cardNumVar[j]);
			}
		}*/
		
		int [] sameSuit={0,0};
		int [] diffSuit={1,3};
		for(int k=0 ; k<1 ; k++){
			for(int j=k ; j<1 ; j++){
				int [] num={k,j};
				if(k != j){
					for(int i=0 ; i<numOfCase ; i++){
						Dealer dealer = new Dealer(numOfPlayer,num,sameSuit);
						if(Dealer.playerWin)
							sum++;
					}
				}
				System.out.print(Card.cardNumVar[num[0]]+","+Card.cardSuitVar[sameSuit[0]]+","+Card.cardNumVar[num[1]]+","+Card.cardSuitVar[sameSuit[1]]);
				System.out.printf(",%.2f percent\n",(double)sum*100/numOfCase);
				sum=0;
				for(int i=0 ; i<numOfCase ; i++){
					Dealer dealer = new Dealer(numOfPlayer,num,diffSuit);
					if(Dealer.playerWin)
						sum++;
				}
				System.out.print(Card.cardNumVar[num[0]]+","+Card.cardSuitVar[diffSuit[0]]+","+Card.cardNumVar[num[1]]+","+Card.cardSuitVar[diffSuit[1]]);
				System.out.printf(",%.2f percent\n",(double)sum*100/numOfCase);
				sum=0;
			}
		}

		
		int count=0;
		for(int i=0 ; i<13 ; i++){
			for(int j=0 ; j<4 ; j++){
				card[count][0] = cardNum[i];
				card[count][1] = cardSuit[j];
				count++;
			}
		}

		 // long endtime=System.currentTimeMillis();

		  //long costTime = (endtime - begintime);
			//System.out.print(costTime);
		int numOfCard = 5;
		/*
		testThreeSuit(numOfCard);
		testFourSuit(numOfCard);
		test56Straight(numOfCard);
		//test57StraightWithSix();
		test58Straight(numOfCard);
		test59Straight(numOfCard);
		*/
	}
	
	public static void testThreeSuit(int numOfCard){
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int m=0;
			for(int j=0; j<numOfCard ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][1] == "club")
					m++;
			}
			if(m>=3)
				sum++;
		}
		System.out.println("Tested P(Three card same suit)= "+(double)sum/numOfCase);
	}
	
	public static void testFourSuit(int numOfCard){
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int m=0;
			for(int j=0; j<5 ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][1] == "club")
					m++;
			}
			if(m>=4)
				sum++;
		}
		System.out.println("Tested P(Four card same suit)= "+(double)sum/numOfCase);
	}

	public static void test56Straight(int numOfCard){
		//Assume you get 5,6. You need 2,3,4 || 3,4,7 || 4,7,8 || 7,8,9
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int [] comp2347 ={0,0,0,0};
			int [] countUsed = {0,0,0,0,0,0}; //2,3,4,7,8,9
			for(int j=0; j<numOfCard ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][0] == "2" && countUsed[0] == 0){
					comp2347[0]++;
					countUsed[0]++;
				}else if(showCard[j][0] == "3" && countUsed[1] == 0){
					comp2347[0]++;
					comp2347[1]++;
					countUsed[1]++;
				}else if(showCard[j][0] == "4" && countUsed[2] == 0){
					comp2347[0]++;
					comp2347[1]++;
					comp2347[2]++;
					countUsed[2]++;
				}else if(showCard[j][0] == "7" && countUsed[3] == 0){
					comp2347[1]++;
					comp2347[2]++;
					comp2347[3]++;
					countUsed[3]++;
				}else if(showCard[j][0] == "8" && countUsed[4] == 0){
					comp2347[2]++;
					comp2347[3]++;
					countUsed[4]++;
				}else if(showCard[j][0] == "9" && countUsed[5] == 0){
					comp2347[3]++;
					countUsed[5]++;
				}
			}
			if(comp2347[0]>=3 || comp2347[1] >= 3 || comp2347[2] >= 3 || comp2347[3] >= 3)
				sum++;
		}
		System.out.printf("Tested P(When you got consec, get addition straight)= %.5f\n",(double)sum/numOfCase);
	}

	public static void test57Straight(int numOfCard){
		//Assume you get 5,7. You need 3,4,6 || 4,6,8 || 6,8,9
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int [] comp346 ={0,0,0};
			int [] countUsed = {0,0,0,0,0}; //3,4,6,8,9
			for(int j=0; j<numOfCard ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][0] == "3" && countUsed[0] == 0){
					comp346[0]++;
					countUsed[0]++;
				}else if(showCard[j][0] == "4" && countUsed[1] == 0){
					comp346[0]++;
					comp346[1]++;
					countUsed[1]++;
				}else if(showCard[j][0] == "6" && countUsed[2] == 0){
					comp346[0]++;
					comp346[1]++;
					comp346[2]++;
					countUsed[2]++;
				}else if(showCard[j][0] == "8" && countUsed[3] == 0){
					comp346[1]++;
					comp346[2]++;
					countUsed[3]++;
				}else if(showCard[j][0] == "9" && countUsed[4] == 0){
					comp346[2]++;
					countUsed[4]++;
				}
			}
			if(comp346[0]>=3 || comp346[1] >= 3 || comp346[2] >= 3)
				sum++;
		}
		System.out.printf("Tested P(57, get addition straight)= %.5f\n",(double)sum/numOfCase);
	}
	
	public static void test58Straight(int numOfCard){
		//Assume you get 5,8. You need 4,6,7 || 6,7,9
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int [] comp46 ={0,0};
			int [] countUsed = {0,0,0,0}; //4,6,7,9
			for(int j=0; j<numOfCard ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][0] == "4" && countUsed[0] == 0){
					comp46[0]++;
					countUsed[0]++;
				}else if(showCard[j][0] == "6" && countUsed[1] == 0){
					comp46[0]++;
					comp46[1]++;
					countUsed[1]++;
				}else if(showCard[j][0] == "7" && countUsed[2] == 0){
					comp46[0]++;
					comp46[1]++;
					countUsed[2]++;
				}else if(showCard[j][0] == "9" && countUsed[3] == 0){
					comp46[1]++;
					countUsed[3]++;
				}
			}
			if(comp46[0]>=3 || comp46[1] >= 3)
				sum++;
		}
		System.out.printf("Tested P(58, get addition straight)= %.5f\n",(double)sum/numOfCase);
	}
	public static void test59Straight(int numOfCard){
		//Assume you get 5,9. You need 6,7,8
		int sum=0;
		String [][] showCard = new String[7][2];
		for(int i = 0 ; i< numOfCase ; i++){
			int [] comp6 ={0};
			int [] countUsed = {0,0,0}; //6,7,8
			for(int j=0; j<numOfCard ; j++){
				showCard[j][0] = cardNum[(int)Math.floor(Math.random()*13)];
				showCard[j][1] = cardSuit[(int)Math.floor(Math.random()*4)];
				if(showCard[j][0] == "6" && countUsed[0] == 0){
					comp6[0]++;
					countUsed[0]++;
				}else if(showCard[j][0] == "7" && countUsed[1] == 0){
					comp6[0]++;
					countUsed[1]++;
				}else if(showCard[j][0] == "8" && countUsed[2] == 0){
					comp6[0]++;
					countUsed[2]++;
				}
			}
			if(comp6[0]>=3)
				sum++;
		}
		System.out.printf("Tested P(59, get addition straight)= %.5f\n",(double)sum/numOfCase);
	}
}
