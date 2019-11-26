package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitorTooYoung;
    Visitor visitorOldEnough;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        visitorTooYoung = new Visitor(10, 150, 50);
        visitorOldEnough = new Visitor(20, 190, 50);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void cantSellToUnderAge(){
        assertEquals(false, tobaccoStall.isAllowedTo(visitorTooYoung));
        assertEquals(true, tobaccoStall.isAllowedTo(visitorOldEnough));
    }
}
