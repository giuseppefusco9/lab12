package it.unibo.es3;

import java.util.List;

public interface Logics {

    void expand();

    boolean toQuit();

    List<Pair<Integer, Integer>> getPositions();
    
}
