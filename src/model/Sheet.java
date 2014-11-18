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
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public double value(String name) {
		Slot tempSlot = slotMap.get(name);
		return tempSlot.value(this);
	}

	public void createSlot(String text){
		Slot newSlot = slotFactory.buildSlot(text);
		
	}
	
	public String getSlotText(String address){
		if (!slotMap.containsKey(address)){
			return "";
		}
		return slotMap.get(address).toString();
	}
	
	public void update(String address, Object somethingFixLater) {
		
	}
	
	public void remove(String address) {
		slotMap.remove(address);
	}
	
	public Set keySet(){
		return slotMap.keySet();
	}
}
	/*Isaks önskelista
	 * Kära tomten, denna julen önskar jag mig:
	 * remove(String address)
	 * keySet från hashmappen.
	 * god jul.*/

