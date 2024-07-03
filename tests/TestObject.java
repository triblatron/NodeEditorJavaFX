import nodeeditor.CloningFacility;
import nodeeditor.IntHolder;

public class TestObject {
    public int spoo = 0;
    public TestObject next = null;

    public TestObject() {
        spoo = 0;
        next = null;
    }
    public TestObject(CloningFacility facility, TestObject other) {
        IntHolder id = new IntHolder(0);
        facility.putOrig(other,id);
        facility.addClone(id.value, this);
        next = other.next;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (getClass() != other.getClass())
            return false;

        TestObject my = (TestObject) other;
        return spoo == my.spoo;
    }
}
