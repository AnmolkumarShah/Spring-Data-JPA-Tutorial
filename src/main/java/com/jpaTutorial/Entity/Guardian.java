package com.jpaTutorial.Entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name = "guardian_name")
	),
	@AttributeOverride(
			name = "email",
			column = @Column(name = "guardian_email")
	),
	@AttributeOverride(
			name = "mobile",
			column = @Column(name = "guardian_mobile")
	)
})
public class Guardian {

	private String name;
	private String email;
	private String mobile;

	public Guardian(String guardianName, String guardianEmail, String guardianMobile) {
		super();
		this.name = guardianName;
		this.email = guardianEmail;
		this.mobile = guardianMobile;
	}

	public String getGuardianName() {
		return name;
	}

	public void setGuardianName(String guardianName) {
		this.name = guardianName;
	}

	public String getGuardianEmail() {
		return email;
	}

	public void setGuardianEmail(String guardianEmail) {
		this.email = guardianEmail;
	}

	public String getGuardianMobile() {
		return mobile;
	}

	public void setGuardianMobile(String guardianMobile) {
		this.mobile = guardianMobile;
	}

	public Guardian() {
		super();
		// TODO Auto-generated constructor stub
	}

}
