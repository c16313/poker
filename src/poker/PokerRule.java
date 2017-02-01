package poker;

import java.util.ArrayList;

public class PokerRule {

    ArrayList<Card> copyHand = new ArrayList<>();
    
    public PokerRule(){
        
    }
    
    public int decision(ArrayList<Card> playerHand){
    	
    	if(isRoyalStraightFlush(playerHand)){
    		System.out.println( "ロイヤルストレートフラッシュ" );
    		return 1000;
    	}else if(isStraightFlush(playerHand)){
    		System.out.println( "ストレートフラッシュ" );
    		return 900;
    	}else if(isFourOFaKind(playerHand)){
    		System.out.println( "フォーカード" );
    		return 800;
    	}else if(isFullHouse(playerHand)){
    		System.out.println( "フルハウス" );
    		return 700;
    	}else if(isFlush(playerHand)){
    		System.out.println( "フラッシュ" );
    		return 600;
    	}else if(isStraight(playerHand)){
    		System.out.println( "ストレート" );
    		return 500;
    	}else if(isTreeOFaKind(playerHand)){
    		System.out.println( "スリーカード" );
    		return 400;
    	}else if(isTwoPair(playerHand)){
    		System.out.println( "ツーペア" );
    		return 300;
    	}else if(isOnePair(playerHand)){
    		System.out.println( "ワンペア" );
    		return 200;
    	}else{
    		System.out.println( "ハイカード:" + playerHand.get(0) );
    		return isHighCard(playerHand);
    	}
    	
    }
    
    // 
    public boolean isRoyalStraightFlush(ArrayList<Card> hand){
        
        copyHand = (ArrayList<Card>) hand.clone();
        int count = 0;
        
        //X[cª·×Ä¯¶©`FbN
        if(!suitCheck(copyHand)) return false;
        
        for(int i = 9; i <= 13; i++){
            for(int j = 0; j < copyHand.size(); j++){
                //Xg[g»è
                if(copyHand.get(j).getNumber() == i){
                    copyHand.remove(j);
                    count++;
                }
            }
            if(copyHand.isEmpty())break;
        }
        
                
        return count == 5;
        
    }
    
    
    //Xg[gtbVÌ»è
    public boolean isStraightFlush(ArrayList<Card> hand){
        
        int count = 0;
        
        //X[cª·×Ä¯¶©`FbN
        if(!suitCheck(hand)) return false;
        
        for(int i = 0; i < hand.size(); i++){
            if(i >= 1 && (hand.get(i-1).getNumber()- 1) == hand.get(i).getNumber())
            	count++;
        }
                
        return count == 4;
    }
    
    //4J[h»è
    public boolean isFourOFaKind(ArrayList<Card> hand){
        
        int count, checkNumber;
        
        for(int i = 0; i < hand.size(); i++){
        	count = 0;
        	checkNumber = hand.get(i).getNumber();
        	for(int j = 0; j < hand.size(); j++){
        		if(checkNumber == hand.get(j).getNumber())
        			count++;
        	}
        	if(count == 4) return true;
        }
    	
        return false;
    }
    
    //tnEX`FbN
    public boolean isFullHouse(ArrayList<Card> hand){
        
    	int[] num = new int[5];
    	for(int i = 0; i < hand.size(); i++){
    		num[i] = hand.get(i).getNumber();
    	}
    	
    	int checkNum1 = num[0], checkNum2 = num[4];
    	int count1 = 0, count2 = 0; 
    	
    	for(int i = 0; i < hand.size(); i++){
    		if(num[i] == checkNum1) count1++;
    		if(num[i] == checkNum2) count2++;
    	}
    	
    	return (count1 == 3 && count2 == 2) || (count1 ==2 && count2 == 3);
    	
    }
    
    //tbV`FbN
    public boolean isFlush(ArrayList<Card> hand){
        
        return suitCheck(hand);
        
    }
    
    //Xg[g`FbN
    public boolean isStraight(ArrayList<Card> hand){
        
        int count = 0;
        
        for(int i = 0; i < hand.size(); i++){
            if(i >= 1 && (hand.get(i-1).getNumber()- 1) == hand.get(i).getNumber())
            	count++;
        }
                
        return count == 4;
    	
    }
    
    //X[J[h`FbN
    public boolean isTreeOFaKind(ArrayList<Card> hand){
        
        int count, checkNumber;
        
        for(int i = 0; i < hand.size(); i++){
        	count = 0;
        	checkNumber = copyHand.get(i).getNumber();
        	for(int j = 0; j < hand.size(); j++){
        		if(checkNumber == hand.get(j).getNumber())
        			count++;
        	}
        	if(count == 3) return true;
        }
    	
        return false;
    	
    }
    
    //c[J[h`FbN
    public boolean isTwoPair(ArrayList<Card> hand){
    	
    	/* num{1,1,2,2,3}
    	 * num{1,1,2,3,3}
    	 * num{1,2,2,3,3}
    	 */
    	
    	int[] num = new int[5];
    	for(int i = 0; i < hand.size(); i++){
    		num[i] = hand.get(i).getNumber();
    	}
    	
    	int checkNum1 = num[0], checkNum2 = num[2], checkNum3 = num[4];
    	int count1 = 0, count2 = 0, count3 = 0; 
    	
    	for(int i = 0; i < hand.size(); i++){
    		if(num[i] == checkNum1) count1++;
    		if(num[i] == checkNum2) count2++;
    		if(num[i] == checkNum3) count3++;
    	}
    	
    	return (count1 == 2 && count2 == 2) || (count1 ==2 && count3 == 2) || (count2 == 2 && count3 ==2);
        
    }
    
    //yA`FbN
    public boolean isOnePair(ArrayList<Card> hand){
        
        int count, checkNumber;
        
        for(int i = 0; i < hand.size(); i++){
        	count = 0;
        	checkNumber = hand.get(i).getNumber();
        	for(int j = 0; j < hand.size(); j++){
        		if(checkNumber == hand.get(j).getNumber())
        			count++;
        	}
        	if(count == 2) return true;
        }
    	
        return false;
    }
    
    public int isHighCard(ArrayList<Card> hand){
        
    	int suitNum = hand.get(0).getSuit();
    	int rankNum = hand.get(0).getNumber();
    	
        return suitNum + rankNum;
    }
    
    //X[c`FbN\bh
    private boolean suitCheck(ArrayList<Card> hand){
    	
    	int suit = hand.get(0).getSuit();
    	
    	for(int i = 0; i < hand.size(); i++){
    		if(hand.get(i).getSuit() != suit)
    			return false;
    	}
    	
    	return true;
    }
}