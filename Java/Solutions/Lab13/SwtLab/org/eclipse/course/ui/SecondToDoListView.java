package org.eclipse.course.ui;

/**
 * @author Espirity Inc.
 */

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import java.util.Enumeration;
import java.util.Vector;
 
public class SecondToDoListView {
	private static String EMPTYSTRING = "";
	private Display display;
	private Shell shell;
	private Text toDoItemText;
	private List todoItemsList;
	private Button  deleteButton, addButton, deleteAllButton;
	private String newItem;
	private Vector items;
	private String  selectedItem ;
	
	private void setNewItem(String newItem){
		this.newItem = newItem;
	}
	private void setItems(Vector items){
			this.items = items;
	}
	private void setSelectedItem(String selectedItem){
		this.selectedItem = selectedItem;
	}
	
	private String getNewItem(){
		return newItem;
	}
	
	private Vector getItems(){
		return items;
	}
	
	private String getSelectedItem(){
		return selectedItem;
	}
	
	public  SecondToDoListView(){
		display = new Display ();
		shell = new Shell (display);
		setNewItem(EMPTYSTRING);
		setItems(new Vector());
		setSelectedItem(EMPTYSTRING);
		
		createLayout(shell);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) 
				display.sleep ();
		}
		display.dispose ();
	}
	
	private void createLayout(Shell shell){
		FormData data;		
		FormLayout layout= new FormLayout();
		
	   	layout.marginWidth = 5;
	   	layout.marginHeight = 5;
	   	shell.setLayout(layout);
	   	shell.setText("Second To Do List");
	   		
		toDoItemText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		data = new FormData();	
		data.top = new FormAttachment(0,0);
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(50,0);
		toDoItemText.setLayoutData(data);
		toDoItemText.addModifyListener(new ToDoItemTextModifyListener());
			
		todoItemsList = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		data = new FormData();	
		data.top = new FormAttachment(toDoItemText,5);
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(50,0);
		data.bottom = new FormAttachment(100,0);
		todoItemsList.setLayoutData(data);
		todoItemsList.addSelectionListener(new TodoItemsListSelectionListener());
		
		addButton = new Button(shell, SWT.PUSH);
		addButton.setText("Add");
		data = new FormData();	
		data.top = new FormAttachment(0,0);
		data.left = new FormAttachment(toDoItemText,5);
		addButton.setLayoutData(data);
		addButton.addSelectionListener(new AddButtonSelectionListener());
		
		deleteButton = new Button(shell, SWT.PUSH);
		deleteButton.setText("Delete");
		data = new FormData();	
		data.top = new FormAttachment(addButton,5);
		data.left = new FormAttachment(todoItemsList,5);
		deleteButton.setLayoutData(data);
		deleteButton.addSelectionListener(new DeleteButtonSelectionListener());
		
		deleteAllButton = new Button(shell, SWT.PUSH);
		deleteAllButton.setText("Delete All");
		data = new FormData();	
		data.top = new FormAttachment(deleteButton,5);
		data.left = new FormAttachment(todoItemsList,5);
		deleteAllButton.setLayoutData(data);
		deleteAllButton.addSelectionListener(new DeleteAllButtonSelectionListener());
		
		update();
	}
	
	public class AddButtonSelectionListener extends SelectionAdapter {		
		public void widgetSelected(SelectionEvent event) {
			if (!getNewItem().equals(EMPTYSTRING)){
				getItems().add(getNewItem());
				setNewItem(EMPTYSTRING);
			}
			update();
		}
	}
	
	public class DeleteButtonSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			getItems().remove(getSelectedItem());
			setSelectedItem(EMPTYSTRING);
			update();
		}
	}
	
	public class DeleteAllButtonSelectionListener extends SelectionAdapter {	
		public void widgetSelected(SelectionEvent event) {
			setItems(new Vector());
			update();
		}
		}
	
	public class TodoItemsListSelectionListener extends SelectionAdapter {	
			public void widgetSelected(SelectionEvent event) {
				setSelectedItem(todoItemsList.getSelection()[0]);
				update();
			}
		}
	
	public class ToDoItemTextModifyListener implements ModifyListener {	
		public void modifyText(ModifyEvent e) {
			setNewItem(toDoItemText.getText());
			update();
		}
	}
	
	private void updateDeleteButton(){
		deleteButton.setEnabled(!getSelectedItem().equals(EMPTYSTRING));
	}
	
	private void updateAddButton(){
		addButton.setEnabled(!getNewItem().equals(EMPTYSTRING));
	}
	
	private void updateDeleteAllButton(){
			deleteAllButton.setEnabled(!getItems().isEmpty());
		}
	private void updateToDoItemText(){
		if(!toDoItemText.getText().equals(getNewItem()))
		toDoItemText.setText(getNewItem());
	}
	
	private void updateTodoItemsList() {
		String [] displayItems; 
		Enumeration enumeration;
		int index;
		
		if(!(todoItemsList.getItems().length == getItems().size())) {		
			displayItems = new String[items.size()];
			enumeration = getItems().elements();
			index = 0;
			while (enumeration.hasMoreElements()){
				displayItems[index] = (String)enumeration.nextElement();
				index++;
			}
			todoItemsList.setItems(displayItems);
		}
	}
	private void update(){
		updateAddButton();
		updateDeleteButton();
		updateDeleteAllButton();
		updateToDoItemText();
		updateTodoItemsList();	
	}
	
	public static void main(String[] args) {
			SecondToDoListView view = new SecondToDoListView();
	}
}
