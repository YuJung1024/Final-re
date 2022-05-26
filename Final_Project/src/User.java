import java.util.ArrayList;
public class User {

	private ArrayList<String>name;
	private ArrayList<Integer>ID;
	private ArrayList<String>password;
	private ArrayList<String>mail;

	public User() {
		name=new ArrayList<String>();
		ID=new ArrayList<Integer>();
		password=new ArrayList<String>();
		mail=new ArrayList<String>();
	}
	public void add(String n,int id,String pw,String m) {
		name.add(n);
		ID.add(id);
		password.add(pw);
		mail.add(m);	
	}
	public ArrayList<String> getN(){
		return this.name;
	}
	public ArrayList<Integer> getID(){
		return this.ID;
	}
	public ArrayList<String> getPW(){
		return this.password;
	}
}
