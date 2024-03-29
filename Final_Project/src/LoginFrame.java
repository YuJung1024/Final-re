import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
;public class LoginFrame extends JFrame{

	private String username,passw,id,mail;
	private JLabel user,password;
	private JTextField u,passwords;
	private JButton login,enroll,forget;
	private JPanel panel1,panel2,panel3,operatepanel;
	private EnrollFrame enrollf;
	private User use;
	private SetupFrame set,setf;

	private boolean success;
	Connection connect;
	Statement stat,stat1;
	private static ArrayList <String> namelist,pwlist,idlist,maillist;
	
	public LoginFrame(Connection conn )throws SQLException {
		this.connect=conn;
		setTitle("Login");
		setSize(300,200);
		setVisible(true);
		createLabel();
		createTextField();
		createButton();
		createLayout();
		namelist=new ArrayList<String>();
		pwlist=new ArrayList<String>();
		idlist=new ArrayList<String>();
		maillist=new ArrayList<String>();
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
				
				String id="";
				String mail="";
				try {
					stat=connect.createStatement();
					String user=u.getText();
					String PW=passwords.getText();
					String query="SELECT Name FROM personalInfo";
					boolean hasresult=stat.execute(query);
					
					if(hasresult==true) {
						ResultSet result=stat.getResultSet();
						showName(result);
						
						if(getNlist().contains(user)) {
							
//							n=getNlist();
//							stat1=connect.createStatement();
							String que="SELECT Password FROM personalInfo";
							boolean right=stat.execute(que);
							if(right==true) {
								ResultSet re=stat.getResultSet();
								showPassword(re);
								if(getPWlist().get(getNlist().indexOf(user)).equals(PW)) {
									JOptionPane.showMessageDialog(null, "Welcome");
									setLogin();
									setVisible(false);
									setName(user);
									setPW(PW);
									String s="SELECT UserID FROM personalInfo";
									boolean has=stat.execute(s);
									if(has==true) {
										ResultSet r=stat.getResultSet();
										showID(r);
										id=(String)getIDlist().get(getNlist().indexOf(user));
									}
									String st="SELECT Email FROM personalInfo";
									boolean hasre=stat.execute(st);
									if(hasre==true) {
										ResultSet rs=stat.getResultSet();
										showMail(rs);
										mail=(String)getMaillist().get(getNlist().indexOf(user));
										
									}
									setf=new SetupFrame(connect,user,id,PW,mail);
									setf.setVisible(true);
									use=new User();
									use.addName(user);
									use.addID(id);
									use.setPW(PW);
									use.setMail(mail);
									re.close();
									result.close();
									stat.close();
								}else {
									JOptionPane.showMessageDialog(null,"Password is wrong","Error",JOptionPane.ERROR_MESSAGE);
								}
							}
						}else {
							JOptionPane.showMessageDialog(null,"Please enroll before login or your name is wrong","Error",JOptionPane.ERROR_MESSAGE);
						}
						setID(id);
						
						setMail(mail);
						}
					}
//					String query="SELECT Name FROM personalInfo WHERE Name=?";
//					PreparedStatement str=connect.prepareStatement(query);
//					str.setString(1,user);										
//					boolean hasresult=str.execute();
//					if(hasresult==true) {
//						ResultSet result=str.getResultSet();
//						
//						String que="SELECT Name,Password FROM personalInfo WHERE Name=? AND Password=?";
//						PreparedStatement state=connect.prepareStatement(que);
//						state.setString(1,user);
//						state.setString(2,PW);
//						boolean right=state.execute();
//						
//						if(right==true) {
//							ResultSet result1=state.getResultSet();
//							JOptionPane.showMessageDialog(null,"Welcome!");
//							username=u.getText();
//							passw=u.getText();
//							setLogin();
//							result1.close();
//							state.close();
//							result.close();
//							str.close();
//							setVisible(false);
//							return;
//							
//						}else if(right!=true) {
//							JOptionPane.showMessageDialog(null,"Password is wrong!","Error",JOptionPane.ERROR_MESSAGE);
//							
//						}
//					}else if(hasresult!=true) {
//						JOptionPane.showMessageDialog(null,"Please enroll before login or you enter a wrong name","Error",JOptionPane.ERROR_MESSAGE);
//						
//					}
//				}
			catch (SQLException e1) {
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
	public void setName(String name) {
		this.username=name;
	}
	public void setPW(String pw) {
		this.passw=pw;	
	}
	public String getName() {
		return this.username;
	}
	public String getPW() {
		return this.passw;
	}
	public void setLogin() {
		this.success=true;
	}
	public boolean getLogin() {
		return this.success;
	}
	
	public static void showName(ResultSet result)throws SQLException{
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (result.next()) {			
			for (int i = 1; i <= columnCount; i++) {
				namelist.add(result.getString(i));
		}
	}
	}
	public ArrayList getNlist() {
		return this.namelist;
	}
	public static void showPassword(ResultSet result)throws SQLException{
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				pwlist.add(result.getString(i));
		}
	}
	}
	public ArrayList getPWlist() {
		return this.pwlist;
	}
	public static void showID(ResultSet result)throws SQLException{
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (result.next()) {		
			for (int i = 1; i <= columnCount; i++) {
				idlist.add(result.getString(i));	
		}
	}
	}
	public ArrayList getIDlist() {
		return this.idlist;
	}
	public void setID(String id) {
		this.id=id;
	}
	public String getID() {
		return this.id;
	}
	public static void showMail(ResultSet result)throws SQLException{
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (result.next()) {		
			for (int i = 1; i <= columnCount; i++) {
				maillist.add(result.getString(i));	
		}
	}
	}
	public ArrayList getMaillist() {
		return this.maillist;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	public String getMail() {
		return this.mail;
	}
}
