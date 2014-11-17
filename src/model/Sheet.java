package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


import expr.Environment;

public class Sheet extends Observable implements Environment{
	//TODO
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
		// TODO Auto-generated method stub
		return 0;
	}

	public void createSlot(String text){
		
	}
	
	public String getSlotText(String address){
		if (!slotMap.containsKey(address)){
			return "";
		}
		return slotMap.get(address).toString();
	}
	
	public void update(String address, Object somethingFixLater) {
		
	}

	/** Implement toString for slot at given address here */
	public String getString(String address) {
		return "";
		//TODO
	}
	/*Isaks önskelista
	 * Kära tomten, denna julen önskar jag mig:
	 * remove(String address)
	 * keySet från hashmappen.
	 * god jul.*/
	
}
