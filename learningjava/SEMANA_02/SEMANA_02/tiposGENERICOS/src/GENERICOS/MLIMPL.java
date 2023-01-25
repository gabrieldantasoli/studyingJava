package GENERICOS;

import java.util.ArrayList;

public class MLIMPL<T> {
    private ArrayList<T> lista = new ArrayList<T>();

    
    public void add(T o) {
        lista.add(o);
    }

    
    public void remove(T o) {
        lista.remove(o);
    }
}
