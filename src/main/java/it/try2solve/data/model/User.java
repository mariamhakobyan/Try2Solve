package it.try2solve.data.model;

import it.try2solve.util.StringUtils;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.index.Indexed;
import org.springframework.data.document.mongodb.mapping.Document;

import com.mysema.query.annotations.QueryEntity;


@QueryEntity
@Document
public class User extends BaseModel implements Serializable {

    private static final long serialVersionUID = -4623786185488515904L;
    
	@Id
	private String id;
	
	@Indexed
	private String socialId;
	
	private String firstName;
	private String lastName;
	private String title;
	private int userSource;
	private String link;
	private long lastLogin;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
     * @return the userSource
     */
    public int getUserSource() {
    	return userSource;
    }

	/**
     * @param userSource the userSource to set
     */
    public void setUserSource(int userSource) {
    	this.userSource = userSource;
    }
    
    /**
     * @param userSource the userSource to set
     */
    public void setUserSource(UserSource userSource) {
    	this.userSource = userSource.getValue();
    }
	
    /**
     * @return the userSource
     */
    public UserSource getUserSourceAsEnum() {
    	for(UserSource source: UserSource.values()) {
    		if(userSource == source.getValue()) {
    			return source;
    		}
    	}
    	return null;
    }
    
    public String getName() {
    	StringBuilder name = new StringBuilder(getFirstName());
    	if(StringUtils.isNotBlank(getLastName())) {
    		name.append(" ").append(getLastName());
    	}
    	return name.toString();
    }

	/**
     * @return the link
     */
    public String getLink() {
    	return link;
    }

	/**
     * @param link the link to set
     */
    public void setLink(String link) {
    	this.link = link;
    }

	/**
     * @return the lastLogin
     */
    public long getLastLogin() {
    	return lastLogin;
    }

	/**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(long lastLogin) {
    	this.lastLogin = lastLogin;
    }

	/**
     * @return the socialId
     */
    public String getSocialId() {
    	return socialId;
    }

	/**
     * @param socialId the socialId to set
     */
    public void setSocialId(String socialId) {
    	this.socialId = socialId;
    }

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	    return "User [id=" + id + ", socialId=" + socialId + ", firstName="
	            + firstName + ", lastName=" + lastName + ", title=" + title
	            + ", userSource=" + userSource + ", link=" + link
	            + ", lastLogin=" + lastLogin + "]";
    }

    
}
