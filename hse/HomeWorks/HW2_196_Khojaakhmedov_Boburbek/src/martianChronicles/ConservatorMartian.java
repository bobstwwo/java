package martianChronicles;

import java.util.ArrayList;

public class ConservatorMartian<T> extends Martian<T> {
    Martian<T> parent;
    T value;
    ArrayList<Martian<T>> collOfChild;
    ArrayList<Martian<T>> collOfDes;

    public ConservatorMartian(Martian<T> parent, T value, ArrayList<Martian<T>> collOfChild) {
        this.parent = parent;
        this.value = value;
        this.collOfChild = collOfChild;
        collOfDes = gainCollOfDes(this);
    }

    ArrayList<Martian<T>> gainCollOfDes(Martian<T> curr) {
        ArrayList<Martian<T>> result = new ArrayList<>();
        ArrayList<Martian<T>> children = curr.getCollOfChild();
        for(Martian<T> el:children)
        {
            result.addAll(gainCollOfDes(el));
        }
        result.add(curr);
        return result;
    }

    @Override
    boolean hasDescendantWithValue(T value) {
        boolean result = false;
        if (value != null) {
            for (Martian<T> mar : collOfDes) {
                if (((ConservatorMartian<T>) mar).value.equals(value)) {
                    result = true;
                    break;
                }
            }
            return result;
        } else
            throw new NullPointerException("Parameter T Value in hasDescendantWithValue is null!");

    }

    @Override
    boolean hasChildWithValue(T value) {
        boolean result = false;
        if (value != null) {
            for (Martian<T> mar : collOfChild) {
                if (((ConservatorMartian<T>) mar).value.equals(value)) {
                    result = true;
                    break;
                }
            }
            return result;
        } else
            throw new NullPointerException("Parameter T Value in hasChildWithValue is null!");
    }

    @Override
    ArrayList<Martian<T>> getCollOfDes() {
        return collOfDes;
    }

    @Override
    ArrayList<Martian<T>> getCollOfChild() {
        return this.collOfChild;
    }

    @Override
    Martian<T> getParent() {
        if (this.parent != null)
            return parent;
        else
            return null;
    }
}
