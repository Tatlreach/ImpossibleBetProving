import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class main {

	public static void main(String[] args) {
		float trialCount = 30;
		float successCount = 0;
		
		for(int i = 1; i <= trialCount; i++){
			if(impossibleGambling(100, 50)){
				successCount++;
			}
		}

		//float successRate = (successCount/trialCount);
		System.out.println("successRate: "+successCount+"/"+trialCount);
	}
	
	public static boolean impossibleGambling(int playerCount, int turnCount){
		ArrayList<Integer>	boxes = new ArrayList<>();
		ArrayList<Integer>	playerNumbers = new ArrayList<>();
		

		for(int i =0; i <= playerCount; i++){
			boxes.add(i);
			playerNumbers.add(i);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(boxes, new Random(seed));
		
		
		
		
		for( Integer playeNumber : playerNumbers ){
			if( !followTheirNumber( playeNumber, boxes) ){
				return false;
			}
		}

		//System.out.println(boxes.toString());
		//System.out.println(playerNumbers.toString());
		return true;
		
	}
	
	
	
	public static boolean followTheirNumber( int playerNumber, ArrayList<Integer> boxes ){
		int currentLookingBox = playerNumber;
		int turns = 50;
		int currentLookingBoxValue;
		//ArrayList<Integer> availableBoxes = new ArrayList<>(playerNumbers);
		//Random randomGenerator = new Random();
		//randomGenerator.nextInt(boxes.size());
		
		while( turns > 0 ){
			currentLookingBoxValue = boxes.get(currentLookingBox);
			if( currentLookingBoxValue == playerNumber ){
				//System.out.println("SUCCESS: playerNumber "+playerNumber+", currentLookingBox: "+currentLookingBox+", currentLookingBoxValue: "+currentLookingBoxValue);
				return true;
			}
			
			//availableBoxes.remove(currentLookingBox);

			//System.out.println("FAILURE: currentLookingBox: "+currentLookingBox+", currentLookingBoxValue: "+currentLookingBoxValue);
			currentLookingBox = currentLookingBoxValue;
			
//			while(currentLookingBoxValue < 0){
//				currentLookingBoxValue = randomGenerator.nextInt(boxes.size());
//			}
//			
			turns--;
		}
		
		return false;
	}
	
	

}
