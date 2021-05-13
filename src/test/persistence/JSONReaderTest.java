package persistence;

import model.*;
import org.junit.jupiter.api.Test;
import ui.TidyCloset;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JSONReaderTest {

    @Test
    public void testReaderNonExistentFile() {
        JSONReader reader = new JSONReader("./data/noFile.json");
        try {
            TidyCloset closet = reader.read();
            fail("IOException expected.");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyCloset() {
        JSONReader reader = new JSONReader("./data/testReaderEmptyCloset.json");
        try {
            TidyCloset closet = reader.read();
            Person testPerson = new Person("Timmy", 24, "male", 140.00, 177.00);
            assertEquals(testPerson, closet.getPerson());
        } catch (IOException e) {
            fail("Couldn't read from file.");
        }
    }

    @Test
    public void testReaderGeneralCloset() {
        JSONReader reader = new JSONReader("./data/testReaderGeneralCloset.json");
        try {
            TidyCloset closet = reader.read();
            Person testPerson = new Person("Timmy", 24, "male", 140.00, 177.00);
            Bottom testBot1 = new Bottom("blue express shorts", 24.99, BottomType.SHORTS, Size.SMALL,
                    Brand.EXPRESS, ColourType.BLACK, "123456");
            Bottom testBot2 = new Bottom("white express shorts", 24.99, BottomType.SHORTS, Size.SMALL,
                    Brand.EXPRESS, ColourType.WHITE, "456789");
            Top testTop1 = new Top("black express T-shirt", 24.99, TopType.TSHIRT, Size.SMALL,
                    Brand.EXPRESS, ColourType.BLACK, "147258");
            assertEquals(testPerson, closet.getPerson());
            assertTrue(closet.getBottoms().contains(testBot1));
            assertTrue(closet.getBottoms().contains(testBot2));
            assertTrue(closet.getTops().contains(testTop1));
        } catch (IOException e) {
            fail("Couldn't read from file.");
        }
    }
}
