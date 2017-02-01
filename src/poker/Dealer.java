package poker;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {
	static Scanner stdIn = new Scanner(System.in);
	
	private static Deck deck = new Deck();
	
	public Dealer(){
		
		this.deck = Cards.newCards();       		//�V�����g�����v������
		
	}
	
	public Deck getDeck(){
		return this.deck;
	}
	
	public void trumpShuffle(){
		this.deck.shuffle();
	}
	
	
	//�J�[�h��z�郁�\�b�h
	public void dealCards(Player player){
		for (int i = 0; i < 5; i++) {
			player.drawIn(deck.pop());
		}
		player.sortHand();

	}
	
	//�J�[�h���������郁�\�b�h
	public void changeCard(Player player){
		
		System.out.print("カードを交換しますか?(Y/n):"); String yesno = stdIn.next();
		if(yesno.equals("y")){
			System.out.print("何枚のカードを交換しますか:"); int changeCount = stdIn.nextInt();
			System.out.println("交換するカードの左の番号を１枚ずつ入力してください");
			System.out.println();
			for(int i = 1; i <= changeCount; i++){
				System.out.print(i + "枚目:"); int index = stdIn.nextInt();
				deck.add(player.getHand().get(index-1));
				player.getHand().remove(index-1);
				deck.shuffle();
				player.drawIn(index-1, deck.pop());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//�J�[�h���W�߂郁�\�b�h
	public void collectCards(ArrayList<Card> playerHand){
		
		for(int i = 0; i < 5; i++){
			deck.add(playerHand.get(i));
		}
		playerHand.clear();
		
	}
	
}
