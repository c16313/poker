package poker;

import java.util.ArrayList;
import java.util.Arrays;

public  class Player {	
	
	private String name;                        //名前
	private int coin;                           //コイン
	private ArrayList<Card> hand = new ArrayList<>();   //手札
	
	//コンストラクタ
	public Player(String name, int coin){
	    this.name = name;
	    this.coin = coin;
	}
        
        public ArrayList<Card> getHand(){
		return this.hand;
	}
        
        public String getName(){
		return this.name;
	}
        
        public int getCoin(){
		return this.coin;
	}
        
        public void setCoin(int coin){
		this.coin = coin;
	}
	
	//手札を表示
	public void displayHand(){
		
            System.out.println(this.name + "さんの手札");
            for(int i = 0; i < hand.size(); i++){
                    System.out.println( i+1 + ":" + hand.get(i));
            }
            System.out.println();
	}
	
        //Rankの大きい順にソート
        public void sortHand(){
            ArrayList<Card> copyHand = new ArrayList<>();
            int[] number = new int[5];
            
            copyHand = ( ArrayList<Card> )hand.clone();
            hand.clear();
            
            for(int i=0; i < 5; i++){
                number[i] = copyHand.get(i).getNumber();
            }
            
            Arrays.sort(number);
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < copyHand.size(); j++){
                    if(number[4-i] == copyHand.get(j).getNumber()){
                        hand.add(i, copyHand.get(j));
                        copyHand.remove(j);
                    }
                }
            }
	}
        
        //カードを引く
	public void drawIn(Card card){
		hand.add(card);
	}
        
        public void drawIn(int index, Card card){
		hand.add(index, card);
	}
        
        public int setBetMoney(int coin){return coin;}
        
        //テスト用手札
        public void testHand(){
            hand.add(new Card(3,10));
            hand.add(new Card(1,9));
            hand.add(new Card(3,11));
            hand.add(new Card(3,12));
            hand.add(new Card(3,13));
            
            sortHand();
        }
        
}
