package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;
    private String coloredLabel;

    public SlotLabels(int rows, int cols, Controller controller) {    
        super(rows + 1, cols);

        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(ch, row, controller);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        coloredLabel = firstLabel.address();
    }

    public List<Observer> listObservers() {
    	List<Observer> newList = new ArrayList<Observer>();
    	newList.addAll(labelList);
        return newList;
    }
    
    public void setBackgroundColor(Color color, String address) {
 
    	char ch = address.charAt(0);
    	int num = Integer.parseInt(address.charAt(1) + "");

    	int newNum = Character.getNumericValue(ch)-10 + (num - 1) * 8;
		labelList.get(newNum).setBackground(color);
    	
//    	if (ch == 'A') {
//    		int newNum = 0 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'B') {
//    		int newNum = 1 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'C') {
//    		int newNum = 2 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'D') {
//    		int newNum = 3 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'E') {
//    		int newNum = 4 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'F') {
//    		int newNum = 5 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'G') {
//    		int newNum = 6 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} else if (ch == 'H') {
//    		int newNum = 7 + (num - 1) * 8;
//    		labelList.get(newNum).setBackground(color);
//    	} 
    	
    	
    	  coloredLabel = address;
    }
    
    public String coloredLabel(){
    	return coloredLabel;
    }
}
