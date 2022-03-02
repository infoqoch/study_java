package effective.c18.composition;

import java.util.Collection;
import java.util.Set;

public class InstrumentedHashSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        System.out.println("add called");
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println("addAll called");
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
