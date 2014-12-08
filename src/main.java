import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class main {

	public static void main(String[] args) {
		float trialCount = 10000;
		int playerCount = 100;
		int turnCount = 50;
		float successCount = 0;
		
		for(int i = 1; i <= trialCount; i++){
			if(impossibleGambling(playerCount, turnCount)){
				successCount++;
			}
		}

		float successRate = (successCount/trialCount);
		System.out.println("successRate: "+successRate);//successCount+"/"+trialCount);
	}
	
	
	
	public static boolean impossibleGambling(int playerCount, int turnCount){
		ArrayList<Integer>	boxes = new ArrayList<>();
		ArrayList<Integer>	playerNumbers = new ArrayList<>();
		

		for(int i =0; i < playerCount; i++){
			boxes.add(i);
			playerNumbers.add(i);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(boxes, new Random(seed));
		
		
		
		
		for( Integer playeNumber : playerNumbers ){
			if( !followTheirNumber( playeNumber, boxes, turnCount) ){
				return false;
			}
		}

		//System.out.println(boxes.toString());
		//System.out.println(playerNumbers.toString());
		return true;
		
	}
	
	
	
	public static boolean followTheirNumber( int playerNumber, ArrayList<Integer> boxes, int turnCount ){
		int currentLookingBox = playerNumber;
		int turns = turnCount;
		int currentLookingBoxValue;
		
		while( turns > 0 ){
			currentLookingBoxValue = boxes.get(currentLookingBox);
			if( currentLookingBoxValue == playerNumber ){
				//System.out.println("SUCCESS: playerNumber "+playerNumber+", currentLookingBox: "+currentLookingBox+", currentLookingBoxValue: "+currentLookingBoxValue);
				return true;
			}

			//System.out.println("FAILURE: currentLookingBox: "+currentLookingBox+", currentLookingBoxValue: "+currentLookingBoxValue);
			currentLookingBox = currentLookingBoxValue;
			turns--;
		}
		
		return false;
	}
	
	

}
