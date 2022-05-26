import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

;public class LoginFrame extends JFrame{

	private String username,passw;
	private JLabel user,password;
	private JTextField u,passwords;
	private JButton login,enroll,forget;
	private JPanel panel1,panel2,panel3,operatepanel;
	private EnrollFrame enrollf;
	private User ue=new User();
	private boolean success;
	Connection connect;
	Statement stat;
	
	public LoginFrame(Connection conn )throws SQLException {
		this.connect=conn;
		this.success=false;
		setTitle("Login");
		setSize(300,200);
		setVisible(true);
		createLabel();
		createTextField();
		createButton();
		createLayout();
	}
	public void createLabel() {
		user=new JLabel("Username");
		password=new JLabel("Passwords");
	}
	public void createTextField() {
		u=new JTextField(15);
		passwords=new JTextField(15);
	}
	public void createButton() throws SQLException{
		login=new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
//					stat=connect.createStatement();
					String user=u.getText();
					String PW=passwords.getText();
					
					String query="SELECT * FROM personalInfo WHERE Name=?";
					PreparedStatement str=connect.prepareStatement(query);
					str.setString(1,user);
//					str.executeUpdate();										
					boolean hasresult=str.execute();
					if(hasresult==true) {
						ResultSet result=str.getResultSet();
						
						String que="SELECT * FROM personalInfo WHERE Name=? AND Password=?";
						PreparedStatement state=connect.prepareStatement(que);
						state.setString(1,user);
						state.setString(2,PW);
						boolean right=state.execute();
						
						if(right==true) {
							ResultSet result1=state.getResultSet();
							JOptionPane.showMessageDialog(null,"Welcome!","Info",JOptionPane.OK_OPTION );
							username=u.getText();
							passw=u.getText();
							setEnroll();
							result1.close();
							state.close();
							result.close();
							str.close();
							dispose();
							return;
						}else if(right!=true) {
							JOptionPane.showMessageDialog(null,"Password is wrong!","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}else if(hasresult!=true) {
						JOptionPane.showMessageDialog(null,"Please enroll before login or you enter a wrong name","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
				
		});
		enroll=new JButton("Enroll");
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					enrollf=new EnrollFrame(connect);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		forget=new JButton("Forget password");
	}
	public void createLayout() {
		panel1=new JPanel(new FlowLayout());
		panel1.add(user);
		panel1.add(u);
		panel2=new JPanel(new FlowLayout());
		panel2.add(password);
		panel2.add(passwords);
		panel3=new JPanel(new FlowLayout());
		panel3.add(login);
		panel3.add(enroll);
		panel3.add(forget);
		operatepanel=new JPanel(new GridLayout(3,1));
		operatepanel.add(panel1);
		operatepanel.add(panel2);
		operatepanel.add(panel3);
		add(operatepanel);
	}
	public String getName() {
		return this.username;
	}
	public void setEnroll() {
		this.success=true;
	}
	public boolean getEnroll() {
		return this.success;
	}

}
