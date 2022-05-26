import javax.swing.*;
import java.awt.*;
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
	private JButton cname,cID,cpassw,rewritecomment;
	private JButton apply,close;
	private Connection connect;
	private JPanel showpanel, panel1,panel2,panel3;
	
	public SetupFrame(Connection conn){
		this.connect=conn;
		setTitle("Set up");
		setSize(500,500);
		setVisible(true);
		CreateLabel();
		CreateLayout();
	}
	public void CreateLabel() {
		
	}
	public void CreateLayout() {
		personalinfo=new JLabel("Personal Infomation",JLabel.CENTER);
		Font f=new Font("Utopia",Font.ITALIC,25);
		personalinfo.setFont(f);
		
	}
	
}
