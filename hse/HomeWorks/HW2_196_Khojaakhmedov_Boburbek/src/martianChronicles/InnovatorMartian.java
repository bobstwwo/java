package martianChronicles;

import java.util.ArrayList;

public class InnovatorMartian<T> extends Martian<T> {
    Martian<T> parent;
    T value;
    ArrayList<Martian<T>> collOfChild;
    ArrayList<Martian<T>> collOfDes;

    public InnovatorMartian(Martian<T> parent, T value, ArrayList<Martian<T>> collOfChild) {
        this.parent = parent;
        this.value = value;
        this.collOfChild = collOfChild;
        collOfDes = gainCollOfDes(this);
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

    void setGenCode(T value) throws NullPointerException {
        if (value != null) {
            this.value = value;
        } else
            throw new NullPointerException("Parameter T Value in setGEnCode is null!");
    }

    void setParent(Martian<T> newPar) throws Exception {
        if (!collOfDes.contains(newPar)) {
            this.parent = newPar;

            //Бывший родитель
            Martian<T> oldPar = this.parent;
            oldPar.getCollOfChild().remove(this);
            ((ConservatorMartian<T>) oldPar).collOfDes = ((ConservatorMartian<T>) oldPar).gainCollOfDes(oldPar);

            //Новый родитель
            newPar.getCollOfChild().add(this);
            ((ConservatorMartian<T>) newPar).collOfDes = ((ConservatorMartian<T>) newPar).gainCollOfDes(oldPar);
        } else
            throw new Exception("Setting a new Parent violates the rules of the Martian genealogy!");
    }

    void setCollOfDes(ArrayList<Martian<T>> newColl) throws Exception {
        if (!newColl.contains(this.parent)) {
            this.collOfDes = newColl;
        } else
            throw new Exception("Setting a new Collection of descendant violates the rules of the Martian genealogy!");
    }

    boolean setChild(Martian<T> newChild) {
        if (((ConservatorMartian<T>) newChild).collOfDes.contains(this))
            return false;
        else {
            //Родитель нового ребенка
            Martian<T> par = ((ConservatorMartian<T>) newChild).parent;
            ((ConservatorMartian<T>) par).collOfChild.remove(newChild);
            ((ConservatorMartian<T>) par).collOfDes = ((ConservatorMartian<T>) par).gainCollOfDes(par);

            this.collOfChild.add(newChild);
            this.collOfDes = this.gainCollOfDes(this);
            return true;
        }
    }

    boolean remChild(Martian<T> oldChild) {
        if (this.collOfChild.contains(oldChild)) {
            this.collOfChild.remove(oldChild);
            ((ConservatorMartian<T>) oldChild).parent = null;
            this.collOfDes = this.gainCollOfDes(this);
            return true;
        } else
            return false;
    }

    @Override
    boolean hasDescendantWithValue(T value) throws NullPointerException {
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
    boolean hasChildWithValue(T value) throws NullPointerException {
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
