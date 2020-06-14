import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JUnitTest {

	
	
	@Test
	void testMethods() {
		int[] arr = {1,2,3,4};
		int[] resultArray = {1,6,3,12};
		int[] arriba = {2,2,2,2,2};
		ISBNclass a = new ISBNclass(arr);
		// Teste ob arr auch wirklich gesetzt wurde!
		assertEquals(a.getISBN(), arr);		
		
		// TEST METHODE fuelMultipliedArray():
		a.fuelMultipliedArray();
		for(int i = 0 ; i  < 4; i++) {
			assertTrue(a.getMultiArrElement(i) == resultArray[i]);	
		}
		
		
		
		// TEST AUFTRETEN DER ILLArgException:
		assertThrows(IllegalArgumentException.class, () -> a.setISBN(arriba));	// test ob auch wirklich die Exception geworfen wird!
		//alle Tests waren erfolgreich
	}
	
	@Test
	void testMainFunction() {
		// Korrekte ISBN Nr wird übergeben mit einer korrekte Prüfziffer ("5")
		String ISBN = "978-3-8274-1631-5";
		int[] completeISBN = new int[(ISBN.length() - 4)];	
		int[] withoutControllNum = new int[(completeISBN.length - 1)];	
		completeISBN = stringToInt(ISBN);
		for(int i = 0; i < withoutControllNum.length; i++) {
			withoutControllNum[i] = completeISBN[i];
		}
		ISBNclass testObj = new ISBNclass(withoutControllNum);  	
		assertTrue(testObj.getCorrectControllNum() == completeISBN[completeISBN.length-1]);		// Hier für eine richtige Kontrollziffer, aber auch falsche leich testbar
	}
	
	// Durch diesen Test-Bereich lassen sich leicher automatisiert ISBN-Nummer angeben, wenn man viele Nummern hat und schon weiß, ob die Prüfziffer korrekt ist oder nicht

// Da diese Methode als static in der Main-Klasse definiert wurde, musste Sie leider nochmal hier angegeben werden:
	private int[] stringToInt(String isbn) {
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
