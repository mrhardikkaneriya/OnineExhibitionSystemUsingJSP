package feedback;

public class Feedback 
{
	private int fb_id,pro_id;
	private String pro_name, fb_desc;
	
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getFb_id() {
		return fb_id;
	}
	public void setFb_id(int fb_id) {
		this.fb_id = fb_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getFb_desc() {
		return fb_desc;
	}
	public void setFb_desc(String fb_desc) {
		this.fb_desc = fb_desc;
	}
	
	
}
