package org.nioun.essentials.mog.model;

import java.util.Collection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name ;
	
@ManyToMany( mappedBy="roles")
	private Collection<User> users ;



@ManyToMany
@JoinTable(
		name="roles_privileges",
		joinColumns = @JoinColumn(
				name="role_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(
				name="privilege_id",referencedColumnName="id")
		)
public Collection<Privilege> privileges ;
	

/**
 * 
 */
  public Role() {

}

/**
 * @param name
 * @param users
 * @param privileges
 */
public Role(String name, Collection<User> users, Collection<Privilege> privileges) {
	super();
	this.name = name;
	this.users = users;
	this.privileges = privileges;
}

/**
 * @param name
 */
public Role(String name) {
	super();
	this.name = name;
}

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	
	

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (privileges == null) {
			if (other.privileges != null)
				return false;
		} else if (!privileges.equals(other.privileges))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", users=" + users + ", privileges=" + privileges + "]";
	}




	
	
	
	
}
