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
		private LoginFrame loginframe;
		private SetupFrame setupframe;
		private JLabel title;
		Connection conn;

		public HomeFrame(Connection conn) {
			this.conn=conn;
			setTitle("NCCU美食地圖");
			setSize(500,350);
			createButton();
			createTextArea();
			createLayout();
		}
		public void createButton() {
			restaurant=new JButton("Restaurant");
			view_comment=new JButton("View Comment");
			comment=new JButton("Write Comment");
			schoolmeal=new JButton("SchoolMeal");
			coupon=new JButton("Coupon");
			setup=new JButton("Setup");
			login=new JButton("Login");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					try {
						loginframe=new LoginFrame(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		public void createTextArea() {
			activities=new JTextArea(12,30);
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
			selectpanel=new JPanel(new GridLayout(7,1));
			selectpanel.add(restaurant);
			selectpanel.add(view_comment);
			selectpanel.add(comment);
			selectpanel.add(schoolmeal);
			selectpanel.add(coupon);
			selectpanel.add(setup);
			selectpanel.add(login);
			mainpanel.add(selectpanel);
			mainpanel.add(showpanel);
			basepanel.add(mainpanel,BorderLayout.CENTER);
			add(basepanel);
		}
	}
