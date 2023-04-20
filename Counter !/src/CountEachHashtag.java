import java.util.ArrayList;
import java.util.Scanner;

public class CountEachHashtag {

	public static void main(String[] args) {
		//parallel/multiple arrays
		ArrayList<Integer> counts = new ArrayList<>();
		ArrayList<String> hashtags = new ArrayList<>();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a list of hashtags ('end' to end):");

		boolean done = false;
		do {
			String hashtag = input.next();
			if ( hashtag.equals("end") ) {
				done = true;
			} else {
				hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;

				//if the hashtag is in the hashtags list then add 1 to corresponding count
				boolean found = false;
				for (int i = 0; i < hashtags.size(); i++) {
					if (hashtags.get(i).equals(hashtag)) {
						found = true;
						counts.set(i, counts.get(i) + 1);
					}
				}

				//if not in the list then add
				if (!found) {
					hashtags.add(hashtag);
					counts.add(1);
				}
			}
		} while ( !done);

//		System.out.println(hashtags);
//		System.out.println(counts);

		//determine total number of unique hashtags
		int uniqueHashtags = counts.size();
//		System.out.println(uniqueHashtags);

		//determine minimum count
		//determine maximum count
		int minimum = counts.get(0);
		int maximum = counts.get(0);
		int sum = 0;
		for (int i = 0; i < counts.size(); i++) {
			if (counts.get(i) < minimum) {
				minimum = counts.get(i);
			} else if (counts.get(i) > maximum) {
				maximum = counts.get(i);
			}
			sum += counts.get(0);
		}

		//determine average count
		double average = sum / counts.size();
		System.out.println("" + uniqueHashtags + " hashtags minimum=" + minimum + ", maximum=" + maximum + ", average=" + average);

		int numPerStar = 1;
		//draw bar chart
		for (int i = 0; i < counts.size(); i++) {
			for (int j = 0; j < counts.get(i); j += numPerStar) {
				System.out.print("*");
			}
			System.out.println(" " + hashtags.get(i) + "(" + counts.get(i) + ")");
		}

		System.out.println("A * represents " + numPerStar + " use of tag.");
	}
}