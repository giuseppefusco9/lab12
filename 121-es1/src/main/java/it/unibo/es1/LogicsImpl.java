package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final int sizeOfBtns;
	private final List<Integer> ordIntegers;

	public LogicsImpl(int size) {
		this.sizeOfBtns = Objects.requireNonNull(size);
		this.ordIntegers = new ArrayList<>();
		for (int i = 0; i < sizeOfBtns; i++){
			ordIntegers.add(0);
		}
	}

	@Override
	public int size() {
		return Integer.valueOf(this.sizeOfBtns);
	}

	@Override
	public List<Integer> values() {
		return Collections.unmodifiableList(this.ordIntegers);
	}

	@Override
	public List<Boolean> enablings() {
		return this.ordIntegers.stream()
			.map(e -> e < this.sizeOfBtns)
			.toList();
	}

	@Override
	public int hit(int elem) {
		this.ordIntegers.set(elem, this.values().get(elem) + 1);
		return this.ordIntegers.get(elem);
	}

	@Override
	public String result() {
		return this.ordIntegers.stream()
		.map(String::valueOf)
		.collect(Collectors.joining("|","<<",">>"));
	}

	@Override
	public boolean toQuit() {
		return this.ordIntegers.stream().allMatch(i -> i == this.values().get(0));
	}
}
