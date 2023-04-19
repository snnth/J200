import java.util.ArrayList;
import java.util.Scanner;

public class Counter {

	public static void main(String[] args) {
		ArrayList<Integer> dailyCounts = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a hashtag: ");
		String hashtag = input.nextLine().trim();
		hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;

		System.out.println("Enter count of " + hashtag + " tweets per day (negative to end).");

		boolean done = false;
		do {
			int count = input.nextInt();
			if ( count < 0) {
				done = true;
			} else {
				dailyCounts.add( count);
			}
		} while ( !done);


		//determine minimum
		int minimum = dailyCounts.get(0);
		for (int i = 0; i < dailyCounts.size(); i++) {
			if (dailyCounts.get(i) < minimum) {
				minimum = dailyCounts.get(i);
			}
		}

		//determine maximum
		int maximum = dailyCounts.get(0);
		for (int i = 0; i < dailyCounts.size(); i++) {
		}

		//determine average
		double average = 0.0;
		int sum = 0;
		for (int i = 0; i < dailyCounts.size(); i++) {
			sum += dailyCounts.get(i);
		}
		average = sum / dailyCounts.size();

		//determine total number of days of data
		System.out.println("For " + dailyCounts.size() + " days minimum=" + minimum + ", maximum=" + maximum + ", average=" + average + "");


		//draw a bar chart where maximum / 50 is represented by one *
		int oneStar = maximum / 50;
		for (int i = 0; i < dailyCounts.size(); i++) {
			for (int j = 0; j < dailyCounts.get(i); j += oneStar) {
				System.out.print("*");
				if ((dailyCounts.get(i) - j) <= oneStar) {
					System.out.println(" (" + dailyCounts.get(i) + ")");
				}
			}
		}

		System.out.println("A * represents " + oneStar + " tweets.");

	}
}