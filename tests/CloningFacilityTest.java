import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloningFacilityTest {
    @Test
    public void testCloningFacility() {
        CloningFacility facility = new CloningFacility();
        TestObject orig = new TestObject();
        orig.next = new TestObject();
        TestObject clone = null;
        IntHolder id = new IntHolder(0);
        if (facility.putOrig(orig, id))
        {
            clone = new TestObject(facility,orig);
        }
        else
        {
            clone = (TestObject)facility.getClone(id.value);
        }
        assertEquals(orig, clone);
    }
}
