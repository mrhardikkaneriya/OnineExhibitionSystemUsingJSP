package login;

public class User {

	
    private static int host_id, viewer_id, admin_id, login_status, reg_status;
    public int getHost_id() {
		return host_id;
	}
	public void setHost_id(int host_id) {
//		this.host_id = 1;
		this.host_id = host_id;
		System.out.println("Set value: "+host_id);
	}
	public int getViewer_id() {
		return viewer_id;
	}
	public void setViewer_id(int viewer_id) {
		this.viewer_id = viewer_id;
	}
	private String host_name, host_mail, host_contact, host_gender, host_password, host_status;
    private String viewer_name, viewer_mail, viewer_contact, viewer_gender, viewer_password, viewer_status;
    private String admin_name, admin_mail, admin_contact, admin_password;
    private static String user_type;
    
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_mail() {
		return admin_mail;
	}
	public void setAdmin_mail(String admin_mail) {
		this.admin_mail = admin_mail;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getViewer_name() {
		return viewer_name;
	}
	public void setViewer_name(String viewer_name) {
		this.viewer_name = viewer_name;
	}
	public String getViewer_mail() {
		return viewer_mail;
	}
	public void setViewer_mail(String viewer_mail) {
		this.viewer_mail = viewer_mail;
	}
	public String getViewer_contact() {
		return viewer_contact;
	}
	public void setViewer_contact(String viewer_contact) {
		this.viewer_contact = viewer_contact;
	}
	public String getViewer_gender() {
		return viewer_gender;
	}
	public void setViewer_gender(String viewer_gender) {
		this.viewer_gender = viewer_gender;
	}
	public String getViewer_password() {
		return viewer_password;
	}
	public void setViewer_password(String viewer_password) {
		this.viewer_password = viewer_password;
	}
	public String getViewer_status() {
		return viewer_status;
	}
	public void setViewer_status(String viewer_status) {
		this.viewer_status = viewer_status;
	}
	
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getHost_mail() {
		return host_mail;
	}
	public void setHost_mail(String host_mail) {
		this.host_mail = host_mail;
	}
	public String getHost_contact() {
		return host_contact;
	}
	public void setHost_contact(String host_contact) {
		this.host_contact = host_contact;
	}
	public String getHost_gender() {
		return host_gender;
	}
	public void setHost_gender(String host_gender) {
		this.host_gender = host_gender;
	}
	public String getHost_password() {
		return host_password;
	}
	public void setHost_password(String host_password) {
		this.host_password = host_password;
	}
	public String getHost_status() {
		return host_status;
	}
	public void setHost_status(String host_status) {
		this.host_status = host_status;
	}
	public int getLogin_status() {
		return login_status;
	}
	public void setLogin_status(int login_status) {
		User.login_status = login_status;
	}
	public int getReg_status() {
		return reg_status;
	}
	public void setReg_status(int reg_status) {
		User.reg_status = reg_status;
	}
    	
}
