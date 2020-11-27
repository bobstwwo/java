package martianChronicles;

import java.util.ArrayList;

public class ConservatorMartian<T> extends Martian<T> {
    final Martian<T> parent;
    final T value;
    final ArrayList<Martian<T>> collOfChild;
    final ArrayList<Martian<T>> collOfMar = new ArrayList<>();

    public ConservatorMartian(Martian<T> parent, T value, ArrayList<Martian<T>> collOfChild) {
        this.parent = parent;
        this.value = value;
        this.collOfChild = collOfChild;
    }

    public ConservatorMartian(InnovatorMartian<T> martian) throws Exception {
        this.value = martian.value;
        int size = martian.collOfChild.size();
        for (int i = 0; i < size; i++) {
            ((InnovatorMartian<T>) martian.collOfChild.get(i)).setParent(this);
            collOfMar.add(new ConservatorMartian<T>((InnovatorMartian<T>) martian.collOfChild.get(i)));
        }
        this.collOfChild = collOfMar;
        parent = martian.getParent();
    }

    ArrayList<Martian<T>> gainCollOfDes(Martian<T> curr) {
        ArrayList<Martian<T>> result = new ArrayList<>();
        ArrayList<Martian<T>> children = curr.getCollOfChild();
        for (Martian<T> el : children) {
            result.addAll(gainCollOfDes(el));
        }
        result.add(curr);
        return result;
    }

    @Override
    public boolean hasDescendantWithValue(T value) {
        boolean result = false;
        if (value != null) {
            ArrayList<Martian<T>> collOfDes = this.gainCollOfDes(this);
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
    public boolean hasChildWithValue(T value) {
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
    public ArrayList<Martian<T>> getCollOfDes() {
        return this.gainCollOfDes(this);
    }

    @Override
    public ArrayList<Martian<T>> getCollOfChild() {
        return this.collOfChild;
    }

    @Override
    public Martian<T> getParent() {
        if (this.parent != null)
            return parent;
        else
            return null;
    }
}
