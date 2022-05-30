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
	private JLabel email,showmail;
	private JLabel comment;
	private JTextArea allcomments;
	private JButton cName,cpassw,cmail,comments;
	private JButton close;
	private Connection connect;
	private Statement stat;
	private JPanel showpanel, panel1,panel2,panel3,panel4,panel5,panel6,panel7;
	private LoginFrame login;
	private String user,id,pw,mail;
	private User use=new User();
	
	public SetupFrame(Connection conn,String name, String id, String pw, String mail) throws SQLException{
		setTitle("Set up");
		this.user=name;
		this.id=id;
		this.pw=pw;
		this.mail=mail;
		setSize(500,800);
		setVisible(true);
		CreateTitle();
		CreateLabel();
		CreateTextArea();
		CreateButton();
		CreateLayout();
	}
	public void CreateTitle() {
		personalinfo=new JLabel("Personal Infomation",JLabel.CENTER);
		Font f=new Font("Utopia",Font.ITALIC,25);
		personalinfo.setFont(f);
		
	}
	public void CreateLabel(){
		name=new JLabel("Name: ");
		showname=new JLabel();
		showname.setText(this.user);
		System.out.print(user);
		ID=new JLabel("ID: ");
		showID=new JLabel();
		showID.setText(this.id);
		System.out.print(id);
		password=new JLabel("Password: ");
		showpassw=new JLabel();
		showpassw.setText(this.pw);
		email=new JLabel("Email: ");
		showmail=new JLabel();
		showmail.setText(this.mail);
		comment=new JLabel("Comments: ");
	}
	public void CreateTextArea() {
		allcomments=new JTextArea(10,10);
		allcomments.setEditable(false);
	}
	public void CreateButton() throws SQLException{
		
		cName=new JButton("Change Name");
//		cName.addActionListener(new ActionListener() {
//			
//		});
		cpassw=new JButton("Change Password");
		
		cmail=new JButton("Change Email");
		
		comments=new JButton("View Your comments");
		
		
		
		close=new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
	}
	public void CreateLayout() {
		showpanel=new JPanel(new GridLayout(7,1));
		
		panel1=new JPanel(new FlowLayout());
		panel1.add(name);
		panel1.add(showname);
		panel1.add(cName);
		panel2=new JPanel(new FlowLayout());
		panel2.add(ID);
		panel2.add(showID);
		panel3=new JPanel(new FlowLayout());
		panel3.add(password);
		panel3.add(showpassw);
		panel3.add(cpassw);
		panel4=new JPanel(new FlowLayout());
		panel4.add(email);
		panel4.add(showmail);
		panel4.add(cmail);
		panel5=new JPanel(new FlowLayout());
		panel5.add(comments);
		panel6=new JPanel(new FlowLayout());
		panel6.add(comment);
		panel6.add(allcomments);
		panel7=new JPanel(new FlowLayout());
		panel7.add(close);
		showpanel.add(panel1);
		showpanel.add(panel2);
		showpanel.add(panel3);
		showpanel.add(panel4);
		showpanel.add(panel5);
		showpanel.add(panel6);
		showpanel.add(panel7);
		add(showpanel);
	}
}
