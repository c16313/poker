package poker;

import java.util.Stack;
import java.util.Collections;

public class Deck extends Stack<Card>{
	
    //空のスタックを生成
    public Deck(){
        
    }
	
    //シャッフル
    public void shuffle(){
        Collections.shuffle(this);
    }
    
    /*
    public void printDeck(){
        while(!this.isEmpty())
            System.out.println(this.pop());
        System.out.println(this.elementCount);
    }
    */
            
}
