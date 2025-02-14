package Classes_HasA;


public class Artist {
	
	private String firstName;
	private String lastName;
	private String StageName;
	
	public Artist(String firstName, String lastName, String StageName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.StageName = StageName;
	}

	@Override
	public String toString() {
		
		return "\n First Name:" +firstName + "\n Last Name:" 
		+ lastName + "\n Stage Name:" + StageName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStageName() {
		return StageName;
	}

	public void setStageName(String stageName) {
		StageName = stageName;
	}
	
}
