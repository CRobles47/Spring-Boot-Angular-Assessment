package cogent.infotech.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private Integer userAge;
	private Integer userSalary;

	public User() {}

	public User(String userName, Integer userAge, Integer userSalary) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userSalary = userSalary;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getUserSalary() {
		return userSalary;
	}

	public void setUserSalary(Integer userSalary) {
		this.userSalary = userSalary;
	}
}
