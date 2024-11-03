package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import GLuong.NhanVien;
import GLuong.XLLuong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JTextField txtMaNV, txtHoTen, txtLuong;
    private JComboBox<String> cmbDiachi;
    private JButton btnTimKiem, btnCapNhat;
    private JTable tblNhanVien;
    private DefaultTableModel modelNhanVien;
    private XLLuong quanLyNhanVien;

    public MainFrame() {
        setTitle("QUANG LY NHAN VIEN");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Xuất hiện giữa màn hình

        quanLyNhanVien = new XLLuong();
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Set khoảng cách giữa các thành phần

        // Khởi tạo các trường thông tin
        JLabel lbMaNV = new JLabel("Ma NV: ");
        txtMaNV = new JTextField(20);
        JLabel lbHoTen = new JLabel("Ho va Ten: ");
        txtHoTen = new JTextField(20);
        JLabel lbLuong = new JLabel("Luong: ");
        txtLuong = new JTextField(20);
        JLabel lbDiaChi = new JLabel("Dia chi: ");
        cmbDiachi = new JComboBox<>(new String[]{"HAI PHONG", "HA NOI", "NAM DINH"});
        btnTimKiem = new JButton("Tim Kiem");
        btnCapNhat = new JButton("Cap Nhat");

        // Thêm các thành phần vào bộ cục
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lbMaNV, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtMaNV, gbc);

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
        panel.add(lbLuong, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtLuong, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lbDiaChi, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cmbDiachi, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(btnTimKiem, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(btnCapNhat, gbc);

        String[] columnNames = {"MaNV", "HoTen", "DiaChi", "Luong"};
        modelNhanVien = new DefaultTableModel(columnNames, 0);
        tblNhanVien = new JTable(modelNhanVien);
        JScrollPane scrollPane = new JScrollPane(tblNhanVien);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        updateTableData();

        // Thêm ListSelectionListener để cập nhật các trường khi chọn dòng trong JTable
        tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tblNhanVien.getSelectedRow();
				if(selectedRow >= 0) {
					txtMaNV.setText(modelNhanVien.getValueAt(selectedRow, 0).toString());
					txtHoTen.setText(modelNhanVien.getValueAt(selectedRow, 1).toString());
					txtLuong.setText(modelNhanVien.getValueAt(selectedRow, 3).toString());
					cmbDiachi.setSelectedItem(modelNhanVien.getValueAt(selectedRow, 2).toString());
				}
			}
		});
        btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchFrame searchFrame = new SearchFrame(MainFrame.this);
				searchFrame.setLocationRelativeTo(null); // Đặt SearchFrame ở giữa màn hình
			    searchFrame.setVisible(true);
			}
		});
        btnCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NhanVien nv = quanLyNhanVien.getNVbyMa(txtMaNV.getText());
				capNhatNhanVien(nv);
				updateTableData();
			}
		});
    }
    
    public void timKiemNhanVien(String maNV) {
    	NhanVien nv = quanLyNhanVien.getNVbyMa(maNV);
    	modelNhanVien.setRowCount(0);
    	Object[] rowData;
    	if(nv != null) {
    		rowData = new Object[] {
    				nv.getMaNV(),
    				nv.getHoTen(),
    				nv.getLuong(),
    				nv.getDiaChi()
    		};
    		modelNhanVien.addRow(rowData);
    	}
    }
    public void capNhatNhanVien(NhanVien nv) {
    	nv.setMaNV(txtMaNV.getText());
    	nv.setHoTen(txtHoTen.getText());
    	nv.setLuong(Float.parseFloat(txtLuong.getText()));
    	nv.setDiaChi(cmbDiachi.getSelectedItem().toString());
    	quanLyNhanVien.updateNV(nv);
    	updateTableData();
    }
    public void updateTableData() {
        modelNhanVien.setRowCount(0);
        Object[] rowData;
        for (NhanVien nv : quanLyNhanVien.getAllNV()) {
            rowData = new Object[]{
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getDiaChi(),
                    nv.getLuong()
            };
            modelNhanVien.addRow(rowData);
        }
    }
}
