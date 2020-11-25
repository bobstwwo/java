package martianChronicles;

import java.util.ArrayList;

public abstract class Martian<T> {
   abstract boolean hasDescendantWithValue(T value);
   abstract boolean hasChildWithValue(T value);
   abstract ArrayList<Martian<T>> getCollOfDes();
   abstract ArrayList<Martian<T>> getCollOfChild();
   abstract Martian<T> getParent();
}
