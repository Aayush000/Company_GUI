import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;

public class CompanyGUI{
	private JTextField fileField;
	private JButton nameButton;
	private JButton locationButton; 
	private JButton quitButton;
	private JLabel photo;
	private JTextArea contents;
	private JLabel console;
	private ArrayList<Company> companies;
	private String[][] tableData;
	private JTable table;

	public CompanyGUI(){
		companies = new ArrayList<Company>();
		JFrame frame = new JFrame();
		frame.setSize(750, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter file name"));
		fileField = new JTextField("companies.csv");
		fileField.addActionListener(new FileListener());
		panel.add(fileField);

		nameButton = new FancyButton("Sort By Name");
		nameButton.addActionListener(new NameListener());
		panel.add(nameButton);

		locationButton = new FancyButton("Sort by Location");
		locationButton.addActionListener(new CompanyListener());
		panel.add(locationButton);

    salaryButton = new FancyButton("Sort by Salary");
		salaryButton.addActionListener(new CompanyListener());
		panel.add(salaryButton);

		quitButton = new WarningButton("Quit");
		quitButton.addActionListener(new QuitListener());
		panel.add(quitButton);

		frame.add(BorderLayout.NORTH, panel);

		String[] columns = {"Salary", "Company Name", "Location", "Age", "Number of countries"};
		tableData = new String[companies.length][5];
		table = new JTable(tableData, columns);

		setTableData(); 

		ListSelectionModel select= table.getSelectionModel(); 
		select.addListSelectionListener(new TableListener()); 
		photo = new JLabel();
		showPhoto();

		JSplitPane pane = new JSplitPane(SwingConstants.VERTICAL, table, photo);
		pane.setDividerLocation(90);

		frame.add(pane);
		frame.setVisible(true);

		contents =new JTextArea(5, 40);
		frame.add(contents);

		console = new JLabel();
		console.setForeground(Color.white);
		console.setBackground(Color.black);
		frame.setVisible(true);

	}

	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.println("----End-------");
			System.exit(0);
		}
	}

	private void setTableData(){
		for(int i=0; i<companies.size(); i++){
			tableData[i][0] = companies.get(i).getSalary() + "";
			tableData[i][1] = companies.get(i).getName();
			tableData[i][2] = companies.get(i).getLocation();
			tableData[i][3] = companies.get(i).getAge();
			tableData[i][4] = companies.get(i).getVacation();
			tableData[i][5] = companies.get(i).getNumOfCountries();

		}
	}

	class FileListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String fileName = fileField.getText().trim();
			try{
				FileReader fr = new FileReader(fileName);
				BufferedReader file = new BufferedReader(fr);
				int size = Integer.parseInt(file.readLine().trim());
				companies = new Company[size];

				for (int i=0; i<companies.length; i++){
					String line = file.readLine();
					String[] items = line.split(",");
					companies = new ArrayList<Company>(
						items[0].trim(), 
						items[1].trim(), 
						items[2].trim(), 
						items[3].trim());
				}

			StringBuilder builder = new StringBuilder();
			for(Company c: companies){
				builder.append(c.toString() + "\n");
			}

			contents.setText(builder.toString());
			}

      catch(IOException e){
				System.out.println(e);
			}
		}
	}

	public String companyString(){
		StringBuilder builder = new StringBuilder();
			for(Company c: companies){
				builder.append(c.toString() + "\n");
			}
			return builder.toString();
	}

	private void showPhoto(){
		int selectedIndex = (int)(Math.random() * companies.length);
		photo.setIcon(new ImageIcon(companies.get(selectedIndex).getPhoto()));
	}

	class NameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Collections.sort(companies, Company.NAME);
			int selectedIndex = table.getSelectedRow();
			photo.setIcon(new ImageIcon(companies.get(selectedIndex).getPhoto()));
			contents.setText(companyString());
			setTableData();
		}
	}

	class CompanyListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Collections.sort(companies, Company.LOCATION);
			contents.setText(companyString());
			setTableData();
		}
	}

	class TableListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent event){
			int selectedIndex = table.getSelectedRow();
			photo.setIcon(new ImageIcon(companies.get(selectedIndex).getPhoto()));
		}
	}

	public static void main(String[] args){
		CompanyGUI gui = new CompanyGUI();
	}
}	

class FancyButton extends JButton{
	public FancyButton(String str){
		super(str);
		setBackground(Color.blue);
		setForeground(Color.yellow);
	}
}

class WarningButton extends JButton{
	public WarningButton(String str){
		super(str);
		setBackground(Color.red);
		setBackground(Color.red);
	}
}	