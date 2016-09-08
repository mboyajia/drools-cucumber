package drools.cucumber;

public class HelloCukes {
	private Integer id;
	private String myString;
	private Integer myInteger;
	
	public HelloCukes(Integer id) {
		this.id = id;
		this.myString = "";
		this.myInteger = 0;
	}
	
	public HelloCukes(Integer id, String myString, Integer myInteger) {
		super();
		this.id = id;
		this.myString = myString;
		this.myInteger = myInteger;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public Integer getMyInteger() {
		return myInteger;
	}
	public void setMyInteger(Integer myInteger) {
		this.myInteger = myInteger;
	}


	@Override
	public String toString() {
		return "HelloCukes [id=" + id + ", myString=" + myString + ", myInteger=" + myInteger + "]";
	}
}
