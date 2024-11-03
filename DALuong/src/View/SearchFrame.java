package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchFrame extends JFrame {
	private MainFrame mainFrame;
	private JButton btnTimKiem;
	private JTextField txtMaNV;
	private JLabel lbMaNV;
	
	public SearchFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		// Cài đặt các thuộc tính cơ bản của SearchFrame
		setTitle("TIM KIEM NHAN VIEN");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Đặt ở giữa màn hình
		
		// Sử dụng GridBagLayout cho panel
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // khoảng cách giữa các thành phần
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Tạo và thêm nhãn "Ma NV"
		lbMaNV = new JLabel("Nhap Ma NV:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lbMaNV, gbc);
		
		// Tạo và thêm trường nhập "txtMaNV"
		txtMaNV = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(txtMaNV, gbc);
		
		// Tạo và thêm nút "Tìm Kiếm"
		btnTimKiem = new JButton("TIM KIEM");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER; // Đặt nút ở giữa
		panel.add(btnTimKiem, gbc);
		
		// Thêm panel vào khung chính
		add(panel);
		
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maNV = txtMaNV.getText();
				if(maNV != null) {
					mainFrame.timKiemNhanVien(maNV);
					dispose();
				}
			}
		});
	}
}
