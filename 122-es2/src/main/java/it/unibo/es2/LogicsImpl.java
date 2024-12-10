package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics{

    private final List<List<Boolean>> map;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        this.map = new ArrayList<>();
        for(int i=0; i < size; i++){
            List<Boolean> list = new ArrayList<>();
            this.map.add(list);
            for(int j=0; j < size; j++){
                list.add(false);
            }
        }
    }

    @Override
    public boolean hit(Pair<Integer, Integer> pos) {
        boolean var = !this.map.get(pos.getX()).get(pos.getY());
        this.map.get(pos.getX()).set(pos.getY(), var);
        return var;
    }

    @Override
    public boolean toQuitRow() {
        return map.stream().anyMatch(row -> row.stream().allMatch(bool -> bool));
    }

    @Override
    public boolean toQuitCol() {
        return IntStream.range(0, this.size)
            .anyMatch(i -> map.stream()
                .allMatch(l -> l.get(i))
            );                                                              
    }
}
