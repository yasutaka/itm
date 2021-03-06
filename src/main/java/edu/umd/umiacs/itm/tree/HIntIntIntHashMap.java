package edu.umd.umiacs.itm.tree;

import gnu.trove.TIntIntHashMap;

/**
 * This class defines a two level hashmap, so a value will be indexed by two keys.
 * The value is int, and two keys are both int.
 * Author: Yuening Hu
 */
public class HIntIntIntHashMap extends TwoIntHashMap<TIntIntHashMap> {
	/**
	 * If keys do not exist, insert value.
	 * Else update with the new value.
	 */
	public void put(int key1, int key2, int value) {
		if(! this.data.contains(key1)) {
			this.data.put(key1, new TIntIntHashMap());
		}
		TIntIntHashMap tmp = this.data.get(key1);
		tmp.put(key2, value);
	}

	/**
	 * Return the value indexed by key1 and key2.
	 */
	public int get(int key1, int key2) {
		if (this.contains(key1, key2)) {
			return this.data.get(key1).get(key2);
		} else {
			System.out.println("HIntIntIntHashMap: key does not exist!");
			return 0;
		}
	}

	/**
	 * Adjust the value indexed by the key pair (key1, key2) by the specified amount.
	 */
	public void adjustValue(int key1, int key2, int increment) {
		int old = this.get(key1, key2);
		this.put(key1, key2, old+increment);
	}

	/**
	 * If the key pair (key1, key2) exists, adjust the value by the specified amount,
	 * Or insert the new value.
	 */
	public void adjustOrPutValue(int key1, int key2, int increment, int newvalue) {
		if (this.contains(key1, key2)) {
			int old = this.get(key1, key2);
			this.put(key1, key2, old+increment);
		} else {
			this.put(key1, key2, newvalue);
		}
	}

	/**
	 * Remove the first key 
	 */
	public void removeKey1(int key1) {
		this.data.remove(key1);
	}

	/**
	 * Remove the second key 
	 */
	public void removeKey2(int key1, int key2) {
		if (this.data.contains(key1)) {
			this.data.get(key1).remove(key2);
		}
	}
}

