import java.util.HashMap;
import java.util.Vector;

public class CloningFacility {
    public boolean putOrig(Object orig, IntHolder id) {
        if (_refToId.containsKey(orig)) {
            id.set(_refToId.get(orig).value);
            return false;
        }
        else {
            id.set(_refToId.size() + 1);
            _refToId.put(orig, id);
            return true;
        }
    }

    public void addClone(int id, Object obj) {
        if (id>_clones.size())
        {
            _clones.setSize(id);
        }
        _clones.add(id-1, obj);
    }

    public Object getClone(int id) {
        return _clones.get(id);
    }

    private final Vector<Object> _clones = new Vector<>();
    private final HashMap<Object, IntHolder> _refToId = new HashMap<>();
}
