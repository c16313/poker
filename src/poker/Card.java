package poker;


public class Card {
    enum Suit{	
        //列挙定数の定義
        DIAMOND("♦", 0), CLUB("♣", 1), SPADE("♠", 2), HEART("♥", 3);

        //フィールド変数
        private final String label;
        private final int id;

        //コンストラクタ
        private Suit(String label, int id){
                this.label = label;
                this.id = id;
        }

        //取得メソッド
        String getSuitLabel(){ return label; }	
        int getSuitNumber(){ return id; }

    };
    enum Rank{

        //列挙定数の定義
        ZERO("0", 0), ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), 
        FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
        TEN("10", 10), JACK("J", 11), QUEEN("Q", 12), KING("K", 13);

        //フィールド変数
        private final String label;
        private final int id;

        //コンストラクタ
        Rank(String label, int id){
            this.label = label;
            this.id = id;
        }

        //取得メソッド
        String getRankLabel(){ return label; }
        int getRankNumber(){ return id; }

    };

    Suit suit;
    Rank rank;

    Card(int suit, int rank){
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }
    
    int getSuit(){
        return suit.getSuitNumber();
    }
    
    int getNumber(){
        return rank.getRankNumber();
    }
    
    @Override
    public String toString(){
        return String.format("%s%s", suit.getSuitLabel(), rank.getRankLabel());
        //(表示例)、♦1
    }
}
