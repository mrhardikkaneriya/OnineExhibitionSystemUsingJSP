package event;

public class Event 
{
	private static int ho_id, vpe_id;
	private int h_id;
	private int e_id, e_status;
	private String e_name, e_start, e_end, e_desc;
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public int getE_status() {
		return e_status;
	}
	public void setE_status(int e_status) {
		this.e_status = e_status;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
//		System.out.print(e_name);
		this.e_name = e_name;
//		System.out.print(this.e_name);
	}
	public String getE_start() {
		return e_start;
	}
	public void setE_start(String e_start) {
		this.e_start = e_start;
	}
	public String getE_end() {
		return e_end;
	}
	public void setE_end(String e_end) {
		this.e_end = e_end;
	}
	public String getE_desc() {
		return e_desc;
	}
	public void setE_desc(String e_desc) {
		this.e_desc = e_desc;
	}
	public int getVpe_id() {
		return vpe_id;
	}
	public void setVpe_id(int vpe_id) {
		this.vpe_id = vpe_id;
	}
	public int getHo_id() {
		return ho_id;
	}
	public void setHo_id(int ho_id) {
		Event.ho_id = ho_id;
	}
	
	
	
	
}
