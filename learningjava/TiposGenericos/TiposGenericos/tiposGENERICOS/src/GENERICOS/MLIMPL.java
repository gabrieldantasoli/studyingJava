package GENERICOS;

import java.util.ArrayList;

public class MLIMPL<T> implements ML<T> {
    private ArrayList<T> lista = new ArrayList<T>();

    @Override
    public void add(T o) {
        lista.add(o);
    }

    @Override
    public void remove(T o) {
        lista.remove(o);
    }
}
