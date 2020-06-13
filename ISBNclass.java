public class ISBNclass{
	
	private int[] isbn;
	private int[] calculateArray;
	private int sub;
	private int res;
	
	public ISBNclass(int[] isbn) {
		this.isbn = new int[isbn.length];	// this is the isbn without the controll-number!
		this.calculateArray = new int[isbn.length];	// um Pr�fziffer zu ermitteln ist Zwischenspeicher notw.
		for(int h = 0; h < isbn.length; h++) {
			calculateArray[h] = 0;
		}
		this.isbn = isbn;
	}
	
	public void setISBN(int[] isbn) throws IllegalArgumentException{
		if(this.isbn.length != isbn.length) {
			throw new IllegalArgumentException("The isbn has a diffrent length! Sorry you need the same Length as the last one.");
		}
		this.isbn = isbn;
	}
	
	public int[] getISBN() {
		return this.isbn;
	}
	
	public int getMultiArrElement(int o) {
		return calculateArray[o];
	}
	
	public void fuelMultipliedArray() {
		int multiplier = 1;		// abwechselnd 1, 3, 1, 3 ..
		for(int i = 0; i < isbn.length; i++) {
			this.calculateArray[i] = (multiplier*isbn[i]);
			if(multiplier == 1) {
				multiplier = 3;
			}
			else { 
				multiplier = 1;
			}
		}
	}
	
	public void summation() {	// aufsummieren der Elemente für den Algorithmus wichtig!
		res = 0;
		for(int i = 0; i < isbn.length; i++) {
			res += calculateArray[i];
		}
	}
	
	public void searchNextNum() {
		sub = (res+1);
		while(sub%10 != 0) {
			sub++;		// die nächste durch 10 teilbare Zahl wird genutzt
		}
	}
	
	// Einzelnen Module/Methoden zusammenfassen:
	public int getCorrectControllNum() {	// diese Methode erlaubt es die Kontrollnummer eines ISBN-Codes zu 
		fuelMultipliedArray();
		summation();
		searchNextNum();
		return (sub - res);	// sub ist ausversehen leider doch der größere Wert... , für die Funktion des Algorithmus aber unbedeutend!
	}
}