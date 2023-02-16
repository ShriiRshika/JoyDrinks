package Controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;

import Dao.ImplEmployee;
import Dao.ImplEmployee;
//import Controller.Excel;
import Model.Employee;
//import Model.EmployeeTable;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LogIn {
	
	private Image imgBanner = new ImageIcon(LogIn.class.getResource("banner_1.png")).getImage().getScaledInstance(606, 193, Image.SCALE_SMOOTH);
	private Image imgAccount = new ImageIcon(LogIn.class.getResource("account.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgLock = new ImageIcon(LogIn.class.getResource("lock.png")).getImage().getScaledInstance(20,25, Image.SCALE_SMOOTH);
	private Image imgKey = new ImageIcon(LogIn.class.getResource("key.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
/*	
	private Image imgBanner = null;
	private Image imgAccount = null;
	private Image imgLock = null;
	private Image imgKey = null;
*/
	private JFrame frame;
	private JTextField txtCashier;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("新細明體", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setUndecorated(true);
		frame.setBounds(200, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		System.out.println("image path: "+LogIn.class.getResource(""));
		JLabel lblMessage = new JLabel("Cashier預設為收銀員，密碼為0000");
		lblMessage.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(255, 255, 255));
		lblMessage.setBounds(180, 300, 240, 18);
		frame.getContentPane().add(lblMessage);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(180, 210, 240, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(imgAccount));
		lblNewLabel.setBounds(195, 2, 40, 30);
		panel.add(lblNewLabel);
		
		txtCashier = new JTextField();
		txtCashier.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCashier.getText().equals("Cashier")) {
					txtCashier.setText("");
				}
				else {
					txtCashier.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCashier.getText().equals("")) {
					txtCashier.setText("Cashier");
				}	
			}
		});
		txtCashier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		txtCashier.setBorder(null);
		txtCashier.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		txtCashier.setText("Cashier");
		txtCashier.setBounds(15, 5, 160, 25);
		panel.add(txtCashier);
		txtCashier.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(180, 258, 240, 35);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.BOLD, 14));
		txtPassword.setText("Password");
		txtPassword.setBounds(15, 5, 160, 25);
		panel_1.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(imgLock));
		lblNewLabel_2.setBounds(190, 2, 40, 30);
		panel_1.add(lblNewLabel_2);
		
		JPanel pnlLogIn = new JPanel();
		pnlLogIn.setBorder(null);
		pnlLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						boolean accountCorrect = false;
						//EmployeeDaoExcel employeeExcel = new EmployeeDaoExcel("Employee.xlsx");
						//Employee employee = employeeExcel.findEmployee(txtCashier.getText());
						ImplEmployee implEmp = new ImplEmployee();
						Employee employee = implEmp.queryName(txtCashier.getText());
						//System.out.println("LogIn:employee="+employee);
						
						if(employee!=null) {
							System.out.println("id:"+employee.getId()+"\tname:"+employee.getName()+"\tpassword:"+employee.getPassword());
							if(txtPassword.getText().equals(employee.getPassword())) {
								lblMessage.setText("Hi "+employee.getName()+"，你好！");
								accountCorrect = true;	
							}	
						}
									
						if(accountCorrect) {
							String cashierName = txtCashier.getText();
							txtCashier.setText(null);
							txtPassword.setText(null);
							System.out.println("Account is correct!");
							//lblMessage.setText("Cashier："+employee.getName());
							OrderUI ui = new OrderUI(cashierName);
							
							frame.dispose();
												
							ui.setVisible(true);
						}
						else if(txtCashier.getText().equals("") || txtCashier.getText().equals("收銀員") ||
								txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
							lblMessage.setText("請輸入所需資料！");
						}
						else {
							lblMessage.setText("輸入資料錯誤！請重新輸入");
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlLogIn.setBackground(new Color(0, 100, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlLogIn.setBackground(new Color(0, 128, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlLogIn.setBackground(new Color(0, 80, 0));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLogIn.setBackground(new Color(0, 100, 0));
			}
		});
		pnlLogIn.setBackground(new Color(0, 128, 0));
		pnlLogIn.setBounds(180, 325, 240, 40);
		frame.getContentPane().add(pnlLogIn);
		pnlLogIn.setLayout(null);
	
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(imgKey));
		lblNewLabel_4.setBounds(50, 5, 40, 30);
		pnlLogIn.add(lblNewLabel_4);
		
		JLabel lblLogIn = new JLabel("登  入");
		lblLogIn.setForeground(new Color(255, 255, 255));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("標楷體", Font.BOLD, 16));
		lblLogIn.setBounds(100, 10, 71, 25);
		pnlLogIn.add(lblLogIn);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(imgBanner));
		lblNewLabel_3.setBounds(0, 32, 600, 160);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblClose = new JLabel("X");
		lblClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "你確定要離開 Joy Drink？", "確定", JOptionPane.YES_NO_OPTION) == 0) {
						frame.dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblClose.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					lblClose.setForeground(Color.WHITE);
				}
		});
		lblClose.setBorder(null);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setBackground(new Color(255, 255, 255));
		lblClose.setBounds(580, 5, 20, 20);
		frame.getContentPane().add(lblClose);
		
		frame.setLocationRelativeTo(null);
	}
}
