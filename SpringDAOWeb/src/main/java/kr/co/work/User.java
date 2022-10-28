package kr.co.work;

import java.util.Date;
import java.util.Objects;

//(
//		id		varchar(30)	not null primary key
//	,	pwd		varchar(50)
//	,	name 	varchar(30)
//	,	email	varchar(30)
//	,	birth	date
//	,	sns		varchar(30)
//	,	reg_date	date
//	)
public class User {

	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date birth;
	private String sns;
	private Date reg_data;
	
	
	public User() {}


	public User(String id, String pwd, String name, String email, Date birth, String sns, Date reg_data) {
	//	super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sns = sns;
		this.reg_data = reg_data;
	}


	@Override
	public int hashCode() {
		return Objects.hash(birth, email, id, name, pwd, sns);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pwd, other.pwd) && Objects.equals(sns, other.sns);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getSns() {
		return sns;
	}


	public void setSns(String sns) {
		this.sns = sns;
	}


	public Date getReg_data() {
		return reg_data;
	}


	public void setReg_data(Date reg_data) {
		this.reg_data = reg_data;
	}
	
	

}
