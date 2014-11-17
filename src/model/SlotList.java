package model;

import java.util.HashMap;
import java.util.Map;

public class SlotList {

	Map<String, Slot> slotMap;

	// TODO
	public SlotList() {
		slotMap = new HashMap<String, Slot>();
	}

	public Slot put(String address, Slot slot) {
		return slotMap.put(address, slot);
	}

	public Slot get(String address) {
		// kasta exception
		return null;
	}

	public Slot remove(String address) {
		return null;
	}
	
	public boolean exists(String address) {
		return slotMap.containsKey(address);
	}
}
