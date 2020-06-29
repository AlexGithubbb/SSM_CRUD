package com.alexpower.crud.bean;

public class Employee {
    private Integer eId;

    private String eName;

    private String eGender;

    private String eEmail;

    private Integer dId;
    
    private Department department;
    
    

    public Employee() {
		super();
	}

	public Employee(Integer eId, String eName, String eGender, String eEmail, Integer dId) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eGender = eGender;
		this.eEmail = eEmail;
		this.dId = dId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender == null ? null : eGender.trim();
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail == null ? null : eEmail.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}