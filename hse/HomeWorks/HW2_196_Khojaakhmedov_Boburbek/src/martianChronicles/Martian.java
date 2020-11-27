package martianChronicles;

import java.util.ArrayList;

public abstract class Martian<T> {
    public int shifts;

    public abstract boolean hasDescendantWithValue(T value);

    public abstract boolean hasChildWithValue(T value);

    public abstract ArrayList<Martian<T>> getCollOfDes();

    public abstract ArrayList<Martian<T>> getCollOfChild();

    public abstract Martian<T> getParent();
}
