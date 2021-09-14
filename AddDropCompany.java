import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;

public class AddDropCompany{
	private JTextField inputField;
	private JList list;
	private ArrayList<Company> companies;
	private JButton addButton;
	private JButton removeButton;
	private JLabel console;

	public AddDropCompany(){
		companies = new ArrayList<Company>();
		JFrame frame = new JFrame("Add and Drop Company");
		frame.setSize(550, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Input Company Data: "));
		inputField = new JTextField(14);
		AddListener addListener = new AddListener();
		inputField.addActionListener(addListener);
		panel.add(inputField);

		addButton = new JButton("Add Company");
		addButton.addActionListener(addListener);
		panel.add(addButton);
		removeButton = new JButton("Remove Company");
		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int removeSalary = Integer.parseInt(inputField.getText().trim());
				int index = getIndex(removeSalary);

				if(index != -1){
					Company removed = companies.remove(index);
					console.setText("Removed: " + removed);
				}else{
					console.setText("Salary " + removeSalary + " not found");

				}
				list.setListData(companies.toArray());
			}
	});
  
	panel.add(removeButton);
	frame.add(BorderLayout.NORTH, panel);

	list = new JList();
	frame.add(list);

	console = new JLabel();
	frame.add(BorderLayout.SOUTH, console);

	frame.setVisible(true);
   }

   public int getIndex(int salary){
   	for(int i=0; i<companies.size(); i++){
   		Company sal = companies.get(i);
   		if (sal.getSalary() == salary){
   			return i;
   		}
   	}
   	return -1;
} 	

class AddListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		String[] items = inputField.getText().split(",");
		Company company = new Company(items[0].trim(), items[1].trim(), items[2].trim(), items[3].trim());
		companies.add(company);
		console.setText("Added: " + company);
		list.setListData(companies.toArray());
	}
}

public static void main(String[] args){
	new AddDropCompany();
	}	
}
