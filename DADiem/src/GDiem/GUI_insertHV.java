package GDiem;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_insertHV extends JFrame {
	private JTextField txtMaHV, txtHoTen, txtDiem;
	private JComboBox<String> cmbLop;
	private JButton btnThem;
	private XLDiem quanLyDiem;
	private DefaultTableModel modelHocVien;
	private JTable tbHocVien;
	public GUI_insertHV() {
		setTitle("QUANG LY HOC VIEN");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		quanLyDiem = new XLDiem();
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		// Cac truong thong tin
		JLabel lbMaHV = new JLabel("Ma Hoc Vien: ");
		txtMaHV = new JTextField(20);
		JLabel lbHoTen = new JLabel("Ho Ten:");
		txtHoTen = new JTextField(20);
		JLabel lbDiem = new JLabel("Diem:");
		txtDiem = new JTextField(20);
		
		cmbLop = new JComboBox<String>(new String[] {"64KTPM2", "6LGT1", "64CNTT3"});
		JLabel lbLop = new JLabel("Lop: ");
		
		// Them cac phan tu vao bo cuc
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lbMaHV, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(txtMaHV, gbc);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lbHoTen, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(txtHoTen, gbc);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(lbDiem, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(txtDiem, gbc);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(lbLop, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(cmbLop, gbc);
		
        btnThem = new JButton("Them");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(btnThem, gbc);
		
        String[] columnNames = {"MA HV", "HO TEN", "DIEM", "LOP"};
        modelHocVien = new DefaultTableModel(columnNames, 0);
        tbHocVien = new JTable(modelHocVien);
        JScrollPane scrollPane = new JScrollPane(tbHocVien);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); 
        
        btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Hocvien hv = new Hocvien();
				hv.setMaHV(txtMaHV.getText());
				hv.setHoTen(txtHoTen.getText());
				hv.setDiem(Double.parseDouble(txtDiem.getText()));
				hv.setLop(cmbLop.getSelectedItem().toString());
				AddHocVien(hv);
				updateTableData();
			}
		});
	tbHocVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tbHocVien.getSelectedRow();
				if(selectedRow >= 0) {
					txtMaHV.setText(modelHocVien.getValueAt(selectedRow, 0).toString());
					txtHoTen.setText(modelHocVien.getValueAt(selectedRow, 1).toString());
					txtDiem.setText(modelHocVien.getValueAt(selectedRow, 2).toString());
					cmbLop.setSelectedItem(modelHocVien.getValueAt(selectedRow, 3));
				}
			}
		});
        updateTableData();
	}
	public void updateTableData() {
		modelHocVien.setRowCount(0);
		Object[] rowData;
		for(Hocvien hv : quanLyDiem.getHV()) {
			rowData = new Object[]{
				hv.getMaHV(),
				hv.getHoTen(),
				hv.getDiem(),
				hv.getLop()
			};
			modelHocVien.addRow(rowData);
		}
	}
	public void AddHocVien(Hocvien hv) {
		quanLyDiem.insertHV(hv);
	}
}
