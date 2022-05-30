import java.util.ArrayList;
public class User {

	private String name;
	private String id;
	private String passw;
	private String mail;
	
	public User() {
	}
	public void addName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void addID(String ID) {
		this.id=ID;
	}
	public String getID() {
		return this.id;
	}
	public void setPW(String PW) {
		this.passw=PW;
	}
	public String getPW() {
		return this.passw;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	public String getMail() {
		return this.mail;
	}
}
