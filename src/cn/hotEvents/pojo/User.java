package cn.hotEvents.pojo;

import java.util.List;

/**
 * 
 * @author 张国粮
 * 2019年8月4日,上午9:44:32
 *	用户管理类
 */
public class User {
	private String userName;
	private int userId;
	private String password;
	private int userCode;
	
	private List<City> cities;
	
	private City city;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public User(String userName, int userId, String password, int userCode) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.userCode = userCode;
	}
	public User(){}
	
	public static void main(String[] args) {
		User user=new User();
		List<City> cities=user.cities;
		for (City city : cities) {
			System.out.println(city.toString());
		}
	}
}
