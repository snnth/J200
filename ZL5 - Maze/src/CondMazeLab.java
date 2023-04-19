///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Maze
// Course:          CS200 Fall 20
//
// Author:          Matthew Smith
// Email:           mjsmith44@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

public class CondMazeLab extends Maze 
{
    public static void main(String[] args) { 
       
        // Step 1: Run Maze Simulation
    	CondMazeLab myMaze = new CondMazeLab();
    	
    }

    public void step() 
    {           
        // if not facing a wall
        if (!puss.isFacingWall()) {
        	
        	// turn right
        	puss.right();
        	
        	// if not facing a wall stay turned right (right always rule)
        	if (!puss.isFacingWall()) {		
        		
        		// check for hazards before moving appropriately
        		// gully check
            	if (puss.isFacingGully()) {
            		puss.jump();
            		return;
            	}
            	
            	// mud and boots check
            	if (puss.isFacingMud() && !puss.isInBoots()) {
            		puss.putOnBoots();
            	}
            	if (!puss.isFacingMud() && puss.isInBoots()) {
            		puss.forward();
            		puss.takeOffBoots();
            		return;
            	}
            	
            	// dog and sneak check
            	if (puss.isFacingDog() && !puss.isTipToeing()) {
            		puss.startTipToe();
            	}
            	if (!puss.isFacingDog() && puss.isTipToeing()) {
            		puss.forward();
            		puss.stopTipToe();
            		return;
            	}
            	
            	//if all checks pass and no action was taken move forward
            	puss.forward();
            	return;
        		
        	// otherwise turn back left
        	} else {
        		puss.left();
        		
        		// check for all hazards
        		// gully check
            	if (puss.isFacingGully()) {
            		puss.jump();
            		return;
            	}
            	
            	// mud and boots check
            	if (puss.isFacingMud() && !puss.isInBoots()) {
            		puss.putOnBoots();
            	}
            	if (!puss.isFacingMud() && puss.isInBoots()) {
            		puss.forward();
            		puss.takeOffBoots();
            		return;
            	}
            	
            	// dog and sneak check
            	if (puss.isFacingDog() && !puss.isTipToeing()) {
            		puss.startTipToe();
            	}
            	if (!puss.isFacingDog() && puss.isTipToeing()) {
            		puss.forward();
            		puss.stopTipToe();
            		return;
            	}
            	
            	// if all checks pass and no action was taken move forward
            	puss.forward();
            	return;
        	}
    
        // puss is facing a wall
        } else {
        	
        	// turn right
        	puss.right();

        	// if there is no wall
        	if (!puss.isFacingWall()) {
        		
        		// check for all hazards
        		// gully check
            	if (puss.isFacingGully()) {
            		puss.jump();
            		return;
            	}
            	
            	// mud and boots check
            	if (puss.isFacingMud() && !puss.isInBoots()) {
            		puss.putOnBoots();
            	}
            	if (!puss.isFacingMud() && puss.isInBoots()) {
            		puss.forward();
            		puss.takeOffBoots();
            		return;
            	}
            	
            	// dog and sneak check
            	if (puss.isFacingDog() && !puss.isTipToeing()) {
            		puss.startTipToe();
            	}
            	if (!puss.isFacingDog() && puss.isTipToeing()) {
            		puss.forward();
            		puss.stopTipToe();
            		return;
            	}
            	
            	// if all checks pass and no action was taken move forward
            	puss.forward();
            	return;
            	
            // turn him around by 180 degrees
        	} else {
        		puss.left();
        		puss.left();
        		
        		if (!puss.isFacingWall()) {
        			// check for all hazards
            		// gully check
                	if (puss.isFacingGully()) {
                		puss.jump();
                		return;
                	}
                	
                	// mud and boots check
                	if (puss.isFacingMud() && !puss.isInBoots()) {
                		puss.putOnBoots();
                	}
                	if (!puss.isFacingMud() && puss.isInBoots()) {
                		puss.forward();
                		puss.takeOffBoots();
                		return;
                	}
                	
                	// dog and sneak check
                	if (puss.isFacingDog() && !puss.isTipToeing()) {
                		puss.startTipToe();
                	}
                	if (!puss.isFacingDog() && puss.isTipToeing()) {
                		puss.forward();
                		puss.stopTipToe();
                		return;
                	}
                	
                	// if all checks pass and no action was taken move forward
                	puss.forward();
                	return;
                	
                // if he is facing a wall turn him left
        		} else {
        			puss.left();
        			
        			// check for all hazards
            		// gully check
                	if (puss.isFacingGully()) {
                		puss.jump();
                		return;
                	}
                	
                	// mud and boots check
                	if (puss.isFacingMud() && !puss.isInBoots()) {
                		puss.putOnBoots();
                	}
                	if (!puss.isFacingMud() && puss.isInBoots()) {
                		puss.forward();
                		puss.takeOffBoots();
                		return;
                	}
                	
                	// dog and sneak check
                	if (puss.isFacingDog() && !puss.isTipToeing()) {
                		puss.startTipToe();
                	}
                	if (!puss.isFacingDog() && puss.isTipToeing()) {
                		puss.forward();
                		puss.stopTipToe();
                		return;
                	}
                	
                	// if all checks pass and no action was taken move forward
                	puss.forward();
                	return;
        		}
        	}
        }
    }    
      
    public CondMazeLab() { super(true); }
}