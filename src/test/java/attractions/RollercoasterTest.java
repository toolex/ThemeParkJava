package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitorTooYoung;
    Visitor visitorTooShort;
    Visitor visitorJustRight;
    Visitor visitorTooTall;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitorTooYoung = new Visitor(11, 150, 50);
        visitorTooShort = new Visitor(13, 140, 50);
        visitorJustRight = new Visitor(15, 155, 50);
        visitorTooTall = new Visitor(20, 225, 50);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorsAllowedVSNotAllowed(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitorTooShort));
        assertEquals(false, rollerCoaster.isAllowedTo(visitorTooYoung));
        assertEquals(true, rollerCoaster.isAllowedTo(visitorJustRight));
    }

    @Test
    public void visitorsPayDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.001);
        assertEquals(8.40, rollerCoaster.priceFor(visitorJustRight), 0.001);
    }

    @Test
    public void tallVisitorsPayDoublePrice(){
        assertEquals(16.80, rollerCoaster.priceFor(visitorTooTall), 0.001);
    }
}
