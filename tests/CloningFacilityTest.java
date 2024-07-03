import nodeeditor.CloningFacility;
import nodeeditor.IntHolder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloningFacilityTest {
    @Test
    public void testCloningFacility() {
        CloningFacility facility = new CloningFacility();
        TestObject orig = new TestObject();
        orig.next = new TestObject();
        TestObject clone;
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
