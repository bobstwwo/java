package martianChronicles;

import java.util.ArrayList;

public class InnovatorMartian<T> extends Martian<T> {
    Martian<T> parent = null;
    T value;
    ArrayList<Martian<T>> collOfChild = new ArrayList<>();
    ArrayList<Martian<T>> collOfDes = new ArrayList<>();

    public InnovatorMartian(T value) {
        this.value = value;
        collOfDes = gainCollOfDes(this);
    }

    ArrayList<Martian<T>> gainCollOfDes(Martian<T> curr) {
        ArrayList<Martian<T>> result = new ArrayList<>();
        ArrayList<Martian<T>> children = curr.getCollOfChild();
        for (Martian<T> el : children) {
            result.addAll(gainCollOfDes(el));
        }
        result.add(curr);
        result.remove(this);
        return result;
    }

    public boolean setGenCode(T value) throws NullPointerException {
        if (value != null) {
            this.value = value;
            return true;
        } else
            throw new NullPointerException("Parameter T Value in setGEnCode is null!");
    }

    public boolean setParent(Martian<T> newPar) throws Exception {
        if (!collOfDes.contains(newPar)) {
            this.parent = newPar;

            //Бывший родитель
            Martian<T> oldPar = this.parent;
            oldPar.getCollOfChild().remove(this);
            ((InnovatorMartian<T>) oldPar).collOfDes = ((InnovatorMartian<T>) oldPar).gainCollOfDes(oldPar);

            //Новый родитель
            newPar.getCollOfChild().add(this);
            ((InnovatorMartian<T>) newPar).collOfDes = ((InnovatorMartian<T>) newPar).gainCollOfDes(oldPar);
            return true;
        } else
            throw new Exception("Setting a new Parent violates the rules of the Martian genealogy!");
    }

    public boolean setCollOfDes(ArrayList<Martian<T>> newColl) throws Exception {
        if (!newColl.contains(this.parent)) {
            this.collOfDes = newColl;
            return true;
        } else
            throw new Exception("Setting a new Collection of descendant violates the rules of the Martian genealogy!");
    }

    public boolean setChild(Martian<T> newChild) {
        if (((InnovatorMartian<T>) newChild).collOfDes.contains(this))
            return false;
        else {
            //Родитель нового ребенка
            Martian<T> par = ((InnovatorMartian<T>) newChild).parent;
            if (par != null) {
                ArrayList<Martian<T>> collChild = ((InnovatorMartian<T>) par).collOfChild;
                if (collChild != null) {
                    collChild.remove(newChild);
                    ((InnovatorMartian<T>) par).collOfDes = ((InnovatorMartian<T>) par).gainCollOfDes(par);
                }
            }

            this.collOfChild.add(newChild);
            this.collOfDes = this.gainCollOfDes(this);
            return true;
        }
    }

    public boolean remChild(Martian<T> oldChild) {
        if (this.collOfChild.contains(oldChild)) {
            this.collOfChild.remove(oldChild);
            ((InnovatorMartian<T>) oldChild).parent = null;
            this.collOfDes = this.gainCollOfDes(this);
            return true;
        } else
            return false;
    }

    @Override
    public boolean hasDescendantWithValue(T value) throws NullPointerException {
        boolean result = false;
        if (value != null) {
            for (Martian<T> mar : collOfDes) {
                if (((InnovatorMartian<T>) mar).value.equals(value)) {
                    result = true;
                    break;
                }
            }
            return result;
        } else
            throw new NullPointerException("Parameter T Value in hasDescendantWithValue is null!");

    }

    @Override
    public boolean hasChildWithValue(T value) throws NullPointerException {
        boolean result = false;
        if (value != null) {
            for (Martian<T> mar : collOfChild) {
                if (((InnovatorMartian<T>) mar).value.equals(value)) {
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
        return collOfDes;
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
