package poker;

import java.util.Scanner;

public class PokerTester {
	
    static Scanner stdIn = new Scanner(System.in);
	
    static Deck deck;                   // デッキ
    static Dealer dealer;               // ディーラー
    static Table table;                 // テーブル
    static PokerRule pokerRule;		// ポーカールール（役の判定）
    static Player humanPlayer; 		// プレイヤー（人間）
    static Player computerPlayer; 	// プレイヤー（CPU）
	
    static int entryFee = 500;
	
    public static void main(String[] args) {
    
        humanPlayer = new HumanPlayer( "プレイヤー", 10000 );
        computerPlayer = new ComputerPlayer( "コンピューター", 10000 );
        dealer = new Dealer();
        table = new Table();
        pokerRule = new PokerRule();

        while(true){
            System.out.println( "*---ポーカーゲーム---*" );
            System.out.println();
            System.out.println( "アンティ（参加料）として" + entryFee + "コインいただきます" );
            System.out.println( "--参加者--" );
            System.out.println( "1:" + humanPlayer.getName() + "さん" );
            System.out.println( "2:" + computerPlayer.getName() + "さん" );
            System.out.println();
            table.setBetMoney( entryFee*2 );
            humanPlayer.setCoin( humanPlayer.getCoin() - entryFee );
            computerPlayer.setCoin( computerPlayer.getCoin() - entryFee );

            dealer.trumpShuffle();                	// ディーラーがトランプをシャッフルします                            
            dealer.dealCards( humanPlayer );     	// ディーラーがトランプを配ります
            dealer.dealCards( computerPlayer );
            
            // テスト用
            //humanPlayer.testHand();

            // 手札確認
            humanPlayer.displayHand();          

            // コインを賭けるか？
            table.betMoney(humanPlayer);
            table.setBetMoney(computerPlayer.setBetMoney(1000));	// コンピュータプレイヤーは自動で1000コイン賭ける

            // 手札を交換するか？
            dealer.changeCard(humanPlayer);
            //changeCard(computerPlayer);

            // ショーダウン
            table.showDown(humanPlayer, computerPlayer);

            System.out.println("continue(Y/n)?"); String yesno = stdIn.next();
            if(yesno.equals("n")) break;

            System.out.println();

            // ディーラーにトランプを返す
            dealer.collectCards(humanPlayer.getHand());
            dealer.collectCards(computerPlayer.getHand());
        }
    }
}
