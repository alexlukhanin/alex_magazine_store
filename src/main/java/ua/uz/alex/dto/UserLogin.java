package ua.uz.alex.dto;

public class UserLogin {
	private String userEmail;
	private String destinationUrl;

	public UserLogin(String userEmail, String destinationUrl) {
		this.userEmail = userEmail;
		this.destinationUrl = destinationUrl;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getDestinationUrl() {
		return destinationUrl;
	}

	public void setDestinationUrl(String destinationUrl) {
		this.destinationUrl = destinationUrl;
	}

	@Override
	public String toString() {
		return "UserLogin{" +
				"userEmail='" + userEmail + '\'' +
				", destinationUrl='" + destinationUrl + '\'' +
				'}';
	}
}
