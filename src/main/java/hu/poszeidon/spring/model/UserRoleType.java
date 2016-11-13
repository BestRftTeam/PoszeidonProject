package hu.poszeidon.spring.model;

public enum UserRoleType {
	STUDENT("STUDENT"),
	PARENT("PARENT"),
	ADMIN("ADMIN");
	
	String userRoleType;
	
	private UserRoleType(String userRoleType){
		this.userRoleType = userRoleType;
	}
	
	public String getUserRoleType(){
		return userRoleType;
	}
}