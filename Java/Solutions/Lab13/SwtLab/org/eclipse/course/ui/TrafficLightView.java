package org.eclipse.course.ui;

/**
 * @author Espirity Inc.
 */

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrafficLightView {
	private Display display;
	private Shell shell;
	private Text statusText;
	private Button advanceButton, autoButton, redButton, yellowButton, greenButton, lightButtons[];
	private List actionList;
	private Combo combo;
	private Timer aTimer;
	
	private TrafficLight    aTrafficLight;
	private int             timeCount = 0;
		
	public  TrafficLightView(){
		display = new Display ();
		shell = new Shell (display);
		aTimer = new Timer(100, new TimerEventHandler());
		lightButtons = new Button[3];
		setTrafficLight(new TrafficLight());
		createLayout(shell);
	
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) 
				display.sleep ();
		}
		display.dispose ();
	}
	
	private int getTimeCount() {
		return timeCount;
	}
	
	private void setTimeCount(int timeCount) {
			this.timeCount = timeCount;
	}
	
	private TrafficLight getTrafficLight() {
		return aTrafficLight;
	}
	
	private void setTrafficLight(TrafficLight aTrafficLight) {
		this.aTrafficLight = aTrafficLight;
	}
		
	private void createLayout(Shell shell){
		FormData data;		
		FormLayout layout= new FormLayout();
		
	   	layout.marginWidth = 5;
	   	layout.marginHeight = 5;
	   	shell.setLayout(layout);
	   	shell.setText("Traffic Light View");
	   	
		statusText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		data = new FormData();	
		data.top = new FormAttachment(0,5);
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(30,0);
		statusText.setLayoutData(data);
		
		advanceButton = new Button(shell, SWT.PUSH);
		advanceButton.setText("Advance");
		data = new FormData();	
		data.top = new FormAttachment(0,5);
		data.left = new FormAttachment(40,5);
		data.right = new FormAttachment(80,0);
		advanceButton.setLayoutData(data);
		advanceButton.addSelectionListener(new AdvanceButtonSelectionListener());
	
		autoButton = new Button(shell, SWT.CHECK);
		autoButton.setText("Auto");
		data = new FormData();	
		data.top = new FormAttachment(statusText,10);
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(30,0);
		autoButton.setLayoutData(data);
		autoButton.addSelectionListener(new AutoButtonSelectionListener());
	
		String[] actions = {"Stop", "Yield", "Go"};
		actionList = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		data = new FormData();	
		data.top = new FormAttachment(advanceButton,5);
		data.left = new FormAttachment(40,5);
		data.right = new FormAttachment(80,0);
		data.bottom = new FormAttachment(80,0);
		actionList.setLayoutData(data);
		actionList.addSelectionListener(new ActionListSelectionListener());
		actionList.setItems(actions);
		
		combo = new Combo(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		data = new FormData();	
		data.top = new FormAttachment(autoButton,5);
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(30,0);
		data.bottom = new FormAttachment(30,0);
		combo.setLayoutData(data);
		combo.addSelectionListener(new ComboSelectionListener());
		combo.setItems(actions);
		
		redButton = new Button(shell, SWT.RADIO);
		redButton.setText("Red");
		redButton.setForeground (new Color(display, 255,0,0));
		data = new FormData();	
		data.top = new FormAttachment(combo,20);
		data.left = new FormAttachment(0,5);
		redButton.setLayoutData(data);
		redButton.addSelectionListener(new LightsButtonSelectionListener());
	
		yellowButton = new Button(shell, SWT.RADIO);
		yellowButton.setText("Yellow");
		yellowButton.setForeground (new Color(display, 255, 255, 0));
		data = new FormData();	
		data.top = new FormAttachment(redButton,20);
		data.left = new FormAttachment(0,5);
		yellowButton.setLayoutData(data);
		yellowButton.addSelectionListener(new LightsButtonSelectionListener());
	
		greenButton = new Button(shell, SWT.RADIO);
		greenButton.setText("Green");
		greenButton.setForeground (new Color(display, 0, 255, 0));
		data = new FormData();	
		data.top = new FormAttachment(yellowButton,20);
		data.left = new FormAttachment(0,5);
		greenButton.setLayoutData(data);
		greenButton.addSelectionListener(new LightsButtonSelectionListener());
	
		lightButtons[0] = redButton;
		lightButtons[1] = yellowButton;
		lightButtons[2] = greenButton;
		
		update();
	}
	
	public class AdvanceButtonSelectionListener extends SelectionAdapter {		
		public void widgetSelected(SelectionEvent event) {		
			getTrafficLight().advance();
			update();
		}
	}
	
	public class AutoButtonSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			if (autoButton.getSelection()) {
				aTimer.start();
				setTimeCount(0);
			}
			else
				aTimer.stop();
			update();
		}
	}
	
	public class ComboSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			getTrafficLight().setState(((Combo)event.getSource()).getSelectionIndex() + 1);
			update();
		}
	}
	
	public class ActionListSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			getTrafficLight().setState(((List)event.getSource()).getSelectionIndex() + 1);
			update();
		}
	}
			
	public class StatusTextModifyListener implements ModifyListener {	
		public void modifyText(ModifyEvent e) {
			update();
		}
	}
	
	public class LightsButtonSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			for (int i=0; i<3; i++) {
				if (event.getSource() == lightButtons[i]) {
					getTrafficLight().setState(i+1);
				}
			}
			update();
		}
	}
	
	//	This is the Timer event handler
	private class TimerEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (((getTrafficLight().isRed()) && (timeCount > 5)) ||
					((getTrafficLight().isYellow()) && (timeCount > 2)) ||
					((getTrafficLight().isGreen()) && (timeCount > 7))) {
				getTrafficLight().advance();
				setTimeCount(0);
				Display.getDefault ().asyncExec (new Runnable () {
	  				public void run () {
		 				update();
	  				}});
			}
			else
				setTimeCount(getTimeCount() + 1);
		}
	}
	
	
	private void updateRadioButtons() {
		for (int i=0; i<3; i++) {
			lightButtons[i].setSelection(getTrafficLight().getState() == (i+1));
		}
	}
			
	private void updateActionList() {
		actionList.setSelection(getTrafficLight().getState() - 1);
	}
	
	private void updateStatusText() {
		String temp="";
		switch (getTrafficLight().getState()) {
			case 1: temp = " Means: 'Stop Please'"; break;
			case 2: temp = " Means: 'Yield to Others'"; break;
			case 3: temp = " Means: 'Go Really Fast'";
		}
		statusText.setText(getTrafficLight().toString() + temp);
	}
		  
	private void updateCombo(){
		combo.setText(getTrafficLight().toString()); 
	}
	
	private void update(){
		updateRadioButtons();
		updateStatusText();
		updateActionList();	
		updateCombo();
	}
	
	public static void main(String[] args) {
		TrafficLightView view = new TrafficLightView();
	}
}
