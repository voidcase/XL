package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import expr.Environment;

public class Sheet extends Observable implements Environment {

	private SlotFactory slotFactory;
	private Map<String, Slot> slotMap;
	private String status;

	public Sheet() {
		slotFactory = new SlotFactory();
		slotMap = new HashMap<String, Slot>();
	}

	public Sheet(HashMap<String, Slot> hashMap) {
		this();
		slotMap.putAll(hashMap);
	}

	public String getStatus() {
		return status;
	}

	@Override
	public double value(String name) {
		try {
			Slot tempSlot = slotMap.get(name);
			return tempSlot.value(this);
		} catch (NullPointerException e) {
			throw new XLException(
					"One or more cells that you tried to use in your expression are blank");
		}
	}

	public String valueText(String name) {
		if (!slotMap.containsKey(name)) {
			return "";
		}
		return slotMap.get(name).display(this);
	}

	public void createSlot(String address, String text) {
		if (slotMap.containsKey(address)) {
			slotMap.remove(address);
		}

		try {
			Slot newSlot = slotFactory.buildSlot(text);
			slotMap.put(address, newSlot);
		} catch (XLException e) {
			throw new XLException(e.getMessage());
		}
	}

	public String getSlotText(String address) {
		if (!slotMap.containsKey(address)) {
			return "";
		}
		return slotMap.get(address).toString();
	}

	public void update(String address, String input) {

		if (slotMap.isEmpty()) {
			try {
				createSlot(address, input);
			} catch (XLException e) {
				throw new XLException(e.getMessage());
			}
		} else {
			Slot oldSlot = slotMap.get(address);
			try {
				if (input.equals("")) {
					System.out.println("sheet: input == '' ");
					if (slotMap.containsKey(address)) {
						for (Entry<String, Slot> entry : slotMap.entrySet()) {
							String key = entry.getKey();
							Slot loopSlot = entry.getValue();
							CircularSlot circSlot = new CircularSlot();
							slotMap.remove(key);
							slotMap.put(key, circSlot);
							loopSlot.value(this);
							slotMap.remove(key);
							slotMap.put(key,loopSlot);
						}
						slotMap.remove(address);
					}
				} else {
					System.out.println("Sheet: else");
					CircularSlot circSlot = new CircularSlot();
					slotMap.put(address, circSlot);
					System.out.println("Sheet: so far");

					try {
						Slot tempSlot = slotFactory.buildSlot(input);
						System.out.println("Sheet: progress, "
								+ tempSlot.toString());
						tempSlot.value(this);
						createSlot(address, input);
					} catch (XLException e) {
						throw new NullPointerException(e.getMessage());
					}
				}
			} 
			catch (NullPointerException e) {
				clearCircularSlots();
				throw new XLException(e.getMessage());
			} 
			catch (XLException e) {
				clearCircularSlots();
				System.out.println("Sheet: exception");
				createSlot(address, oldSlot.toString());
				throw new XLException(e.getMessage());
			}
			setChanged();
			notifyObservers();
		}
	}

	public void remove(String address) {
		slotMap.remove(address);
	}

	public Set keySet() {
		return slotMap.keySet();
	}
	
	private void clearCircularSlots() {
		for (Entry<String, Slot> entry : slotMap.entrySet()) {
			String key = entry.getKey();
			Slot loopSlot = entry.getValue();
			if (loopSlot instanceof CircularSlot) {
				slotMap.remove(key);
			}
		}

	}
}