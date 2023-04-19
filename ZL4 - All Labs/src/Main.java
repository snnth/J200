import java.util.Scanner; 

public class Main {
   
	// sit: 1.4, walk: 5.4, run: 13.0, bike: 6.8, swim: 8.7
	public static double activityCalories(String activity, int minutes) {
		
		double calculatedCalories = 0.0;
		activity = activity.trim().toLowerCase();
		
		switch (activity) {
			case "sit":
				calculatedCalories = 1.4 * minutes;
				break;
			case "walk":
				calculatedCalories = 5.4 * minutes;
				break;
			case "run":
				calculatedCalories = 13.0 * minutes;
				break;
			case "bike":
				calculatedCalories = 6.8 * minutes;
				break;
			case "swim":
				calculatedCalories = 8.7 * minutes;
				break;
		}
		return calculatedCalories;
	}
	  
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); 
		int userMinutes; 
		String userActivity; 
		     
		userActivity = scnr.next(); 
		userMinutes = scnr.nextInt(); 
		      
		System.out.println(activityCalories(userActivity, userMinutes)); 
	}
}
