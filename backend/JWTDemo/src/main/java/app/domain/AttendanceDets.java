package app.domain;

import java.util.Date;

public class AttendanceDets {


private static final long serialVersionUID = 1L;
	
	
	private String prn;
	private String sName;
	private Integer sub_Id;
	private Integer count;
	@Override
	public String toString() {
		return "AttendanceDets [prn=" + prn + ", sName=" + sName + ", sub_Id=" + sub_Id + ", count=" + count + "]";
	}
	
	public  AttendanceDets()
	{
		
	}
	
	
	public String getPrn() {
		return prn;
	}
	public void setPrn(String prn) {
		this.prn = prn;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getSub_Id() {
		return sub_Id;
	}
	public void setSub_Id(Integer sub_Id) {
		this.sub_Id = sub_Id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AttendanceDets(String prn, String sName, Integer sub_Id, Integer count) {
		super();
		this.prn = prn;
		this.sName = sName;
		this.sub_Id = sub_Id;
		this.count = count;
	}
	


	


}


