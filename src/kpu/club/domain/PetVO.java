package kpu.club.domain;

public class PetVO {//StudentVO


	private String id;
	private String pet_name;
	private String pet_sex;
	private String kind;
	private String owner_name;
	private String mobile;
	private String address;
	private String root_id;
	private String root_passwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	
	
	public String getPet_sex() {
		return pet_sex;
	}
	public void setPet_sex(String pet_sex) {
		this.pet_sex = pet_sex;
	}
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRootId() {
		return root_id;
	}
	public void setRootId(String root_id) {
		this.root_id=root_id;
	}
	
	public String getRootPasswd() {
		return root_passwd;
	}
	public void setRootPasswd(String root_passwd) {
		this.root_passwd=root_passwd;
	}
	
	
}
