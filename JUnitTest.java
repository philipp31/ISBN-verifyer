import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;

class JUnitTest {

	@Test
	void test() {
		int[] arr = {1,2,3,4};
		int[] resultArray = {1,6,3,12};
		int[] arriba = {2,2,2,2,2};
		ISBNclass a = new ISBNclass(arr);
		// Teste ob arr auch wirklich gesetzt wurde!
		assertEquals(a.getISBN(), arr);		
		
		// TEST METHODE fuelMultipliedArray():
		a.fuelMultipliedArray();
		for(int i = 0 ; i < 4; i++) {
			assertTrue(a.getMultiArrElement(i) == resultArray[i]);	
		}
		
		// TEST AUFTRETEN DER ILLArgException:
		assertThrows(IllegalArgumentException.class, () -> a.setISBN(arriba));	// test ob auch wirklich die Exception geworfen wird!
		//alle Tests waren erfolgreich
	}

	
}
