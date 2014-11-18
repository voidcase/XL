package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import expr.Environment;

public class Sheet extends Observable implements Environment{

	private SlotFactory slotFactory;
	private Map<String, Slot> slotMap;
	private String status;
	
	public Sheet(){
		slotFactory = new SlotFactory();
		slotMap = new HashMap<String, Slot>();
	}
	
	public Sheet(HashMap<String, Slot> hashMap) {
		slotFactory = new SlotFactory();
		slotMap.putAll(hashMap);
		
		
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public double value(String name) {
		Slot tempSlot = slotMap.get(name);
		return tempSlot.value(this);
	}

	public void createSlot(String address, String text){
		if (slotMap.containsKey(address)){
			slotMap.remove(address);
		}
		Slot newSlot = slotFactory.buildSlot(text);
		slotMap.put(address, newSlot);
	}
	
	public String getSlotText(String address){
		if (!slotMap.containsKey(address)){
			return "";
		}
		return slotMap.get(address).toString();
	}
	
	public void update(String address, String input) {
		if (slotMap.containsKey(address)) {
			Slot oldSlot = slotMap.get(address);
			try {
				createSlot(address,"CircularSlot");	
				Slot tempSlot = slotFactory.buildSlot(input);
				double value = tempSlot.value(this);
				createSlot(address, input);
			} catch (XLException e) {
				createSlot(address, oldSlot.toString());
				throw new XLException(e.getMessage());
			}
		}
	}
	
	public void remove(String address) {
		slotMap.remove(address);
	}
	
	public Set keySet(){
		return slotMap.keySet();
	}
}