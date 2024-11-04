package GSach;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI_delSA extends JFrame {
	private JComboBox<String> cmbNamXB;
	private JButton btnXoa;
	private DefaultTableModel modelSach;
	private JTable tableSach;
	private XLSach xuLySach;
	
	// Constructor
	public GUI_delSA() {
		setTitle("QUAN LY SACH");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		xuLySach = new XLSach();
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lbCmbNamXB = new JLabel("Nam Xuat Ban:");
		panel.add(lbCmbNamXB, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		cmbNamXB = new JComboBox<String>(new String[] {"2019", "2020", "2021"});
		panel.add(cmbNamXB, gbc);
		
		btnXoa = new JButton("Xoa");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btnXoa, gbc);
		
		String[] columnNames = new String[] {"Ma Sach", "Ten Sach", "Nam Xuat Ban", "Gia Ban", "Thanh Tien"};
		modelSach = new DefaultTableModel(columnNames, 0);
		tableSach = new JTable(modelSach);
		JScrollPane scrollPane = new JScrollPane(tableSach);
		
		add(panel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int confirm = JOptionPane.showConfirmDialog(GUI_delSA.this, "Ban chac chan muon xoa chu ?");
				if(confirm == JOptionPane.YES_OPTION) {
					int namXB = Integer.parseInt(cmbNamXB.getSelectedItem().toString());
					deleteSA(namXB);
				}
			}
		});
		updateTableData();
	}
	public void deleteSA(int namXB) {
		xuLySach.deleteSA(namXB);
		updateTableData();
	}
	public void updateTableData() {
		modelSach.setRowCount(0);
		Object[] rowData;
		for(Sach sach : xuLySach.getSA()) {
			rowData = new Object[] {
					sach.getMaSach(),
					sach.getTenSach(),
					sach.getNamXuatBan(),
					sach.getGiaBan(),
					sach.thanhTien()
			};
			modelSach.addRow(rowData);
		}
	}
}
