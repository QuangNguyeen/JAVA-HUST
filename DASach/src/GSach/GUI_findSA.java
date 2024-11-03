package GSach;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_findSA extends JFrame {
	private JComboBox<String> cmbNhaXB;
	private JTextField txtGiaB;
	private JButton btnTimKiem;
	private DefaultTableModel modelSach;
	private JTable tableSach;
	private XLSach xuLySach;
	
	public GUI_findSA() {
		xuLySach = new XLSach();
		setTitle("QUAN LY SACH");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lbComboBoxNhaXB = new JLabel("Nha Xuat Ban:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lbComboBoxNhaXB, gbc);
		
		cmbNhaXB = new JComboBox<String>(new String[]{"DAI HOC BACH KHOA HN", "DAI HOC NGOAI THUONG", "DAI HOC QUOC GIA HN"});
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(cmbNhaXB, gbc);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		JLabel lbGiaBan = new JLabel("Gia Ban:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(lbGiaBan, gbc);
		
		txtGiaB = new JTextField(18);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(txtGiaB, gbc);
		
		btnTimKiem = new JButton("TIM KIEM");
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(btnTimKiem, gbc);
		
		String[] columnNames = new String[] {"Ma Sach", "Ten Sach", "Nha Xuat Ban", "Nam Xuat Ban", "Gia Ban", "Gia Khuyen Mai"};
		modelSach = new DefaultTableModel(columnNames, 0);
		tableSach = new JTable(modelSach);
		JScrollPane scrollPane = new JScrollPane(tableSach);
		add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); 
        
        btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nhaXB;
				double giaBan;
				try{
					nhaXB = cmbNhaXB.getSelectedItem().toString();
					giaBan = Double.parseDouble(txtGiaB.getText());
					timKiemByNXBGB(nhaXB, giaBan);
				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
        updateTableData();
	}
	public void timKiemByNXBGB(String _nhaXB, double _giaBan) {
	    modelSach.setRowCount(0); // Xóa hết dữ liệu cũ trước khi thêm dữ liệu mới
	    ArrayList<Sach> dsSach = xuLySach.getSAbyNXBGB(_nhaXB, _giaBan);
	    Object[] rowData;
	    for(Sach sach : dsSach) {
	        rowData = new Object[] {
	            sach.getMaS(),
	            sach.getTenS(),
	            sach.getNhaXB(),
	            sach.getNamXB(),
	            sach.getGiaB(),
	            sach.Khuyenmai()
	        };
	        modelSach.addRow(rowData);
	    }
	}
	public void updateTableData() {
		modelSach.setRowCount(0);
		Object[] rowData;
		for(Sach sach : xuLySach.getSA()) {
			rowData = new Object[] {
					sach.getMaS(),
					sach.getTenS(),
					sach.getNhaXB(),
					sach.getNamXB(),
					sach.getGiaB(),
					sach.Khuyenmai()
			};
			modelSach.addRow(rowData);
		}
	}
}
