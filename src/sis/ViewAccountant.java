package sis;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewAccountant extends JFrame {
	static ViewAccountant frame;
	public ViewAccountant() {
		//Code to view data in JTable
		List<Accountant> list=AccountantDB.view();
		int size=list.size();
		
		String data[][]=new String[size][5];
		int row=0;
		for(Accountant a:list){
			data[row][1]=String.valueOf(a.getId());
			data[row][0]=a.getName();
			data[row][1]=a.getPassword();
			data[row][2]=a.getEmail();
			data[row][3]=a.getContactno();
			row++;
		}
		String columnNames[]={"Name","Password","Email","Contact No"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewAccountant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
