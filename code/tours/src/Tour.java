package ia.org.knightstour;
import java.util.ArrayList;
import java.util.Iterator;


public class Tour extends Thread {

	public Tour() {
		
		
	}
	
	public Tour(Board theBoard, int x, int y) {
		
		this.theBoard = theBoard;
		
		
		startingX = x;
		startingY = y;
	}
	
	public void setCurrentAlgo(String algo) {
		
		this.currentAlgo = algo;
	}
	
	
	public void run() {
		Main.debug("blam!" + startingX + startingY );
		theBoard.clearBoard();
//		theBoard.setVisible( true );
		int curr = (startingY) * theBoard.getWidth() + (startingX);
		
		completeList = new ArrayList<Integer>();
		
		time = System.currentTimeMillis();
		TourWindow.log( ""+ time );
		
		
		
		if( currentAlgo.equals(BRUTE_FORCE) )
			tryMove( curr, 1 );
		else
			tryMoveWarnsdorff( curr, 1 );
		
		
		
		Main.debug("we're done..");
	}
	
	private void tryMove( int currentLoc, int stepNum ) {
		
		int step = stepNum;
		theBoard.coverSpace( currentLoc, step );
		
		if( ! theBoard.isCovered() ) {
			
//			TourWindow.log("trying move: " + currentLoc );
			ArrayList<Integer> possibleMoves = getAllMoves(currentLoc);
			
			Iterator<Integer> iter = possibleMoves.iterator();
			while( iter.hasNext() ) {
				
				int nextLoc = iter.next();
				//Main.debug( "move: " + nextLoc );
				
				if ( isValidMove(nextLoc, currentLoc) ) {
//					if( step < 10 )
						//System.out.println("valid move: " + nextLoc + ", " + step);
					
					tryMove( nextLoc, step + 1 );
					
				}
				
			}
			theBoard.uncoverSpace( currentLoc );
			
		}
		else {
			TourWindow.log( "holy shit we covered the board! " + step  );
			theBoard.setVisible( true );
			return;
			
		}
	}
	
	private void tryMoveWarnsdorff( int currentLoc, int stepNum ) {
				
		int step = stepNum;
		theBoard.coverSpace( currentLoc, step );
		
		if( ! theBoard.isCovered() ) {
			
//			TourWindow.log("trying move: " + currentLoc );
			ArrayList<Integer> possibleMoves = getValidMoves(currentLoc);
			
			int nextMove = nextBestMove(possibleMoves, currentLoc);
//			Iterator<Integer> iter = possibleMoves.iterator();
//			while( iter.hasNext() ) {
//				
//				int nextLoc = iter.next();
//				//Main.debug( "move: " + nextLoc );
//				
//				if ( isValidMove(nextLoc, currentLoc) ) {
////					if( step < 10 )
						//System.out.println("valid move: " + nextLoc + ", " + step);
					if( nextMove < 0) {
						TourWindow.log("Well.. we haven't found a new location after " + currentLoc / theBoard.getWidth() + ", " + currentLoc % theBoard.getWidth() + ".  Try a different position" );
						return;
					}
					completeList.add(currentLoc);
					tryMoveWarnsdorff( nextMove, step + 1 );
					
//				}
//				
//			}
			//theBoard.uncoverSpace( currentLoc );
			
		}
		else {
			TourWindow.log( "holy shit we covered the board! " + step  );
			time = System.currentTimeMillis() - time;
			TourWindow.log( "Total Time (in ms): " + time );
			theBoard.setVisible( true );
			
			Iterator iter = completeList.iterator();
			while( iter.hasNext() )
				TourWindow.logg( iter.next() + " " );
			
			return;
			
		}
		
		
	}

	private int nextBestMove( ArrayList<Integer> possibleMoves, int currentLoc ) {
		
		//order based on W's heuristic
		int bestSoFar = 100;
		int bestLoc = -1;
		Iterator<Integer> iter = possibleMoves.iterator();
		while(iter.hasNext() ) {
		
			int loc = iter.next();
			int temp = (getValidMoves( loc )).size() - 1;
			if( temp < bestSoFar ) {
				bestSoFar = temp;
				bestLoc = loc;
			}
		} 
			
		return bestLoc;
		
	}
	
	//Always start with x when building the int.  Start at 12'oclock and go clockwise..
	private ArrayList<Integer> getAllMoves( int currentLoc ) {
	
		//Main.debug("getting moves..");
		
		ArrayList<Integer> moves = new ArrayList<Integer>();
	
		int up2right1 = currentLoc + theBoard.getWidth() * 2 + 1;
		moves.add( up2right1 );
		int up1right2 = currentLoc + theBoard.getWidth() + 2;
		moves.add( up1right2 );
		int down1right2 = currentLoc - theBoard.getWidth() + 2;
		moves.add( down1right2 );
		int down2right1 = currentLoc - theBoard.getWidth() * 2 + 1;
		moves.add( down2right1 );
		int down2left1 = currentLoc - theBoard.getWidth() * 2 - 1;
		moves.add( down2left1 );
		int down1left2 = currentLoc - theBoard.getWidth() - 2;
		moves.add( down1left2 );
		int up1left2 = currentLoc + theBoard.getWidth() - 2;
		moves.add( up1left2 );
		int up2left1 = currentLoc + theBoard.getWidth() * 2 - 1;
		moves.add( up2left1 );
		
		return moves;
		
	}
	
	private ArrayList<Integer> getValidMoves( int currentLoc ) {
		
		ArrayList<Integer> moves = new ArrayList<Integer>();
		
		int up2right1 = currentLoc + theBoard.getWidth() * 2 + 1;
		if( theBoard.isValid(up2right1,currentLoc))
			moves.add( up2right1 );
		
		int up1right2 = currentLoc + theBoard.getWidth() + 2;
		if( theBoard.isValid(up1right2,currentLoc))
			moves.add( up1right2 );
		
		int down1right2 = currentLoc - theBoard.getWidth() + 2;
		if( theBoard.isValid(down1right2,currentLoc))
			moves.add( down1right2 );
		
		int down2right1 = currentLoc - theBoard.getWidth() * 2 + 1;
		if( theBoard.isValid(down2right1,currentLoc))
			moves.add( down2right1 );
		
		int down2left1 = currentLoc - theBoard.getWidth() * 2 - 1;
		if( theBoard.isValid(down2left1,currentLoc))
			moves.add( down2left1 );
		
		int down1left2 = currentLoc - theBoard.getWidth() - 2;
		if( theBoard.isValid(down1left2,currentLoc))
			moves.add( down1left2 );
		
		int up1left2 = currentLoc + theBoard.getWidth() - 2;
		if( theBoard.isValid(up1left2,currentLoc))
			moves.add( up1left2 );
		
		int up2left1 = currentLoc + theBoard.getWidth() * 2 - 1;
		if( theBoard.isValid(up2left1,currentLoc))
			moves.add( up2left1 );
		
		return moves;
		
	}
	
	public boolean isValidMove( int nextLoc, int prevLoc ) {
		
		return theBoard.isValid(nextLoc, prevLoc);
		
	}
	
	
	private int startingX;
	private int startingY;
	
	private Board theBoard;
	
	private String currentAlgo;
	
	public final static String BRUTE_FORCE = "Brute Force";
	public final static String WARNSDORFF = "Warnsdorff";
	
	public long time = 0;
	
	private ArrayList<Integer> completeList;
	
}
