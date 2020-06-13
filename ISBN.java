import java.util.Scanner;

public class ISBN {
	
	public static void main(String args[]) {
		if(args.length != 1) {
			System.out.println("Wrong Format! Use just 1 Argument (ISBN-Number!!) !");
			System.exit(-1);
		}
		String ISBN = args[0];
		int[] completeISBN = new int[(ISBN.length() - 4)];		//int-Array aller Zahlen notwendig!
		int[] withoutControllNum = new int[(completeISBN.length - 1)];	// hier ist die ISBN-Nr. ohne die Kontrollziffer
		Scanner scanner = new Scanner(System.in);
		int calculatetControllNum;
		int givenControllNum;
		completeISBN = stringToInt(ISBN);
		for(int i = 0; i < withoutControllNum.length; i++) {
			withoutControllNum[i] = completeISBN[i];
		}
		ISBNclass isbnObj = new ISBNclass(withoutControllNum);  	// ISBNclass ermöglicht es die Kontrollziffer einer ISBN-Nr zu berechnen
		do {
			if(ISBN.equals("help")) {
				System.out.println("Please type in a ISBN to check if the ISBN number is correct!");
				System.out.println("if you want to exit the program type in 'exit'.");
			}
			else {
				completeISBN = stringToInt(ISBN);
				for(int i = 0; i < withoutControllNum.length; i++) {
					withoutControllNum[i] = completeISBN[i];
				}
				try {
					isbnObj.setISBN(withoutControllNum);  
				}
				catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				calculatetControllNum = isbnObj.getCorrectControllNum();
				givenControllNum = completeISBN[(completeISBN.length-1)];
				if(givenControllNum == calculatetControllNum) {
					System.out.println(ISBN + " ist eine gueltige ISBN.");	// ist die ISBN-Korrekt wird ausgegeben, dass die ISBN-Nr korrekt ist
				} 
				else {
					char cNum = (char) calculatetControllNum;
					cNum += 48;			// ASCII-Umwandlung beachten! 
					char[] correctISBN = new char[ISBN.length()];
					ISBN.getChars(0, (ISBN.length()-1), correctISBN, 0);
					correctISBN[(ISBN.length()-1)] = cNum;
					String correct = new String(correctISBN);
					System.out.println(ISBN + " ist eine fehlerhafte ISBN.");		// ist ISBN-Nr. nicht korrekt wird die falsche ausgegeben
					System.out.println("Gueltig waere " + correct);					// zusätzlich wird die richtige ISBN ausgegeben
				}
			}
			System.out.println("Please type in a new ISBN to check if it is correct or not");
			System.out.println("If you want to exit the program, you can type in 'exit'.");
			ISBN = scanner.nextLine();
		} while(!(ISBN.equals("exit")));
		scanner.close();
}
	
// parsen der GEWOLLTEN Informationen = alle ints die restlichen inhalte nicht aus den Daten übernehmen (rest uninteressant):
	public static int[] stringToInt(String isbn) {
		char[] cache = new char[isbn.length()];
		int[] wantedFormat = new int[(isbn.length() - 4)];
		int ascii;
		int zaehler = 0;
		for(int i = 0; i < isbn.length(); i++) {
			cache[i] = isbn.charAt(i);
		}
		for(int k = 0; k < isbn.length(); k++) {
			ascii =((int) cache[k]);
			if( 47 < ascii && ascii < 58) {
				wantedFormat[zaehler] = (ascii - 48); 
				zaehler++;
			}
		}
		return wantedFormat;
	}	
}