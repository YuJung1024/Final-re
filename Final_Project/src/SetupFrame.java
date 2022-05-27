import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.sql.*;
public class SetupFrame extends JFrame{

	private JLabel personalinfo;
	private JLabel name,showname;
	private JLabel ID,showID;
	private JLabel password,showpassw;
	private JLabel comment;
	private JTextArea allcomments;
	private JButton cID,cpassw,comments;
	private JButton apply,close;
	private Connection connect;
	private Statement stat;
	private JPanel showpanel, panel1,panel2,panel3,panel4;
	private LoginFrame login;
	
	public SetupFrame(Connection conn) throws SQLException{
		this.connect=conn;
		setTitle("Set up");
		setSize(500,500);
		setVisible(true);
		CreateLayout();
		CreateButton();
		CreateTextArea();
		CreateLabel();
		
	}
	public void CreateLayout() {
		personalinfo=new JLabel("Personal Infomation",JLabel.CENTER);
		Font f=new Font("Utopia",Font.ITALIC,25);
		personalinfo.setFont(f);
		
	}
	public void CreateButton() throws SQLException{
		
		cID=new JButton("Change ID");
		cpassw=new JButton("Change Password");
		comments=new JButton("View Your comments");
		
		login=new LoginFrame(connect);
		login.setVisible(false);
		login.getLogin();
		
		
		apply=new JButton("Apply");
		
		close=new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
	}
	public void CreateTextArea() {
		
	}
	public void CreateLabel() {
		
		panel1=new JPanel(new FlowLayout());
		
		panel2=new JPanel(new FlowLayout());
		
		panel3=new JPanel(new FlowLayout());
		
		panel4=new JPanel(new FlowLayout());
		panel4.add(apply);
		panel4.add(close);
	}
	
	
}
