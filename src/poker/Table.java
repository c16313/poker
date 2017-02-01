package poker;

import java.util.Scanner;

public class Table {
	static Scanner stdIn = new Scanner(System.in);
	
	PokerRule pokerRule = new PokerRule();

	private int betMoney = 0;
	
	public Table(){
		
	}
	
	public int getBetMoney(){
		return this.betMoney;
	}
	
	public void setBetMoney(int betMoney){
		this.betMoney += betMoney;
	}
	
	public void betMoney(Player player){

		String yesno = "n";
		int bet;
		boolean flg = false;
		
		System.out.println(player.getName() + "さんの資金" + player.getCoin() + "コイン");
		if(player.getCoin() == 0) 
			System.out.println("資金がないためコインを賭けることができません");
		else 
			System.out.print("コインを賭けますか(Y/n)"); yesno = stdIn.next();
		if(yesno.equals("y")){
			do{
				System.out.println();
				System.out.print("ベットする額："); bet = stdIn.nextInt();
				if(bet <= player.getCoin())
					flg = true;
				else 
					System.out.println("ベットする額が多すぎます");
			}while(!flg);
			System.out.println();
			betMoney += bet;
			player.setCoin(player.getCoin() - bet);
		}
	}
	
	public void showDown(Player p1, Player p2){
		int p1Point = 0, p2Point = 0;
		
		System.out.println("---/ショーダウン/---");
		System.out.println("-----------------");
		p1.displayHand();
		System.out.print("役:");
		p1Point = pokerRule.decision(p1.getHand());
		System.out.println("-----------------");
		System.out.println();
		System.out.println("-----------------");
		p2.displayHand();
		System.out.print("役:");
		p2Point = pokerRule.decision(p2.getHand());
		System.out.println("-----------------");
		System.out.println();
		System.out.println("-----/結果/-------");
		if(p1Point > p2Point){
			System.out.println(p1.getName() + "さんの勝ち");
			System.out.println(betMoney + "コイン獲得");
			p1.setCoin(p1.getCoin() + betMoney);
		}else if(p1Point < p2Point){
			System.out.println(p2.getName() + "さんの勝ち");
			p2.setCoin(p2.getCoin() + betMoney);
		}else{
			System.out.println("引き分け");
		}
		System.out.println();
		
		//|¯àð0Éß·
		betMoney = 0;
	}
	
}
