package model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Set;

public class XLPrintStream extends PrintStream {
    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void save(Set<String> keys, Sheet sheet) {
        for (String key : keys) {
            print(key);
            print('=');
            println(sheet.getSlotText(key));
        }
        flush();
        close();
    }
}
