package poker;

public class ComputerPlayer extends Player{

	public ComputerPlayer(String name, int coin){
		
		super(name, coin);
		
	}
        
        public int setBetMoney(int coin){
		this.setCoin(this.getCoin() - coin);
		return coin;
	}
	
}
