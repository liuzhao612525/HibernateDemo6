package cn.itcast.entity;

public class Contact {
	private Integer cnid;
	private String cnname;
	private String cngender;
	private String cnphone;

	// 在联系人实体类里面表示所属客户，一个联系人只能属于一个客户
	private Customer customer;

	public Integer getCnid() {
		return cnid;
	}

	public void setCnid(Integer cnid) {
		this.cnid = cnid;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getCngender() {
		return cngender;
	}

	public void setCngender(String cngender) {
		this.cngender = cngender;
	}

	public String getCnphone() {
		return cnphone;
	}

	public void setCnphone(String cnphone) {
		this.cnphone = cnphone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
