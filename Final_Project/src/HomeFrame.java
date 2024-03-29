import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
public class HomeFrame extends JFrame{

		private JButton restaurant,view_comment,comment,schoolmeal,coupon,setup,login;
		private JTextArea activities;
		private JPanel selectpanel,showpanel,mainpanel,basepanel;
		private LoginFrame loginframe,loginagain;
		private SetupFrame setupframe;
		private JLabel title;
		private boolean success;
		Connection conn;
		private String username,userpassword,id,mail;
		private User user=new User();

		public HomeFrame(Connection conn) {
			this.conn=conn;
			this.success=false;
			setTitle("NCCU美食地圖");
			setSize(500,320);
			createButton();
			createTextArea();
			createLayout();
		}
		public void createButton() {
			restaurant=new JButton("Restaurant");
			restaurant.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
//					the code of restaurant list
					
				}
			});
			view_comment=new JButton("View Comment");
			view_comment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
//					the code of view comments
				}
			});
			comment=new JButton("Write Comment");
			comment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if(success!=true) {
						JOptionPane.showMessageDialog(null,"Please login before writing comments!","Error",JOptionPane.ERROR_MESSAGE);
					}else if(success==true) {
//						the code of write comments
					}
				}
			});
			schoolmeal=new JButton("SchoolMeal");
			setup=new JButton("Setup");
			setup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JOptionPane.showMessageDialog(null, "Please login again");
					try {
						loginagain=new LoginFrame(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					if(success!=true) {
//						JOptionPane.showMessageDialog(null,"Please login","Error",JOptionPane.ERROR_MESSAGE);
//					}else if(success==true) {
//						try {
//						setupframe=new SetupFrame(conn);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					}
				}
			});
			login=new JButton("Login");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					String name="";
					String id="";
					String pw="";
					String mail="";
					try {
						loginframe=new LoginFrame(conn);

						setSuccess();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		public void setName(String name) {
			this.username=name;
		}
		public String getName() {
			return this.username;
		}
		public void setPW(String pw) {
			this.userpassword=pw;
		}
		public String getPW() {
			return this.userpassword;
		}
		public void setSuccess() {
			this.success=true;
		}
		public boolean getLogin() {
			return this.success;
		}
		public void setID(String id) {
			this.id=id;
		}
		public String getID() {
			return this.id;
		}
		public void setMail(String mail) {
			this.mail=mail;
		}
		public String getMail() {
			return this.mail;
		}
		public void createTextArea() {
			activities=new JTextArea(10,25);
			activities.setText("活動/集英樓菜單");
			activities.setEditable(false);
			showpanel=new JPanel();
			showpanel.add(activities);
		}
		public void createLayout() {
			title=new JLabel("政大美食地圖",JLabel.CENTER);
			Font t=new Font("Utopia",Font.ITALIC,35);
			title.setFont(t);
			basepanel=new JPanel(new BorderLayout());
			basepanel.add(title,BorderLayout.NORTH);
			mainpanel=new JPanel(new FlowLayout());
			selectpanel=new JPanel(new GridLayout(6,1));
			selectpanel.add(restaurant);
			selectpanel.add(view_comment);
			selectpanel.add(comment);
			selectpanel.add(schoolmeal);
//			selectpanel.add(coupon);
			selectpanel.add(setup);
			selectpanel.add(login);
			mainpanel.add(selectpanel);
			mainpanel.add(showpanel);
			basepanel.add(mainpanel,BorderLayout.CENTER);
			add(basepanel);
		}
	}
