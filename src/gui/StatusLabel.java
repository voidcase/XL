package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class StatusLabel extends ColoredLabel implements Observer {
	
    public StatusLabel() {
        super("", Color.WHITE);
    }

    public void update(Observable observable, Object object) {
        Controller controller = (Controller) observable;
        setText(controller.currentString());
        setOpaque(true);
    }
}