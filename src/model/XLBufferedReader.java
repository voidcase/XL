package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map) {
		SlotFactory factory = new SlotFactory();
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                if (!string.subString(0,i).matches("[a-h][1-9][0]?")
					throw new XLException("Not XL file")
				else
					map.put(string.subString(0,i),factory.buildSlot(string.subString(i+1)); 
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
	}
}
