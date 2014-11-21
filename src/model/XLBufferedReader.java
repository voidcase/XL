package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, Slot> map) {
		SlotFactory factory = new SlotFactory();
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                if (i == -1 || !string.substring(0,i).matches("[A-H][1-9][0]?"))
					throw new XLException("Not XL file");
				else
					map.put(string.substring(0,i).toUpperCase(),factory.buildSlot(string.substring(i+1))); 
                }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
	}
}
