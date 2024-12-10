package it.unibo.es2;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	boolean hit(Pair<Integer, Integer> pos);
	
	/**
	 * @return whether it is time to quit (for rows)
	 */
	boolean toQuitRow();

	/**
	 * @return whether it is time to quit (for cols)
	 */
	boolean toQuitCol();
}