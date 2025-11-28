package org.nioun.essentials.mog.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.nioun.essentials.mog.model.Privilege;
import org.nioun.essentials.mog.model.User;
import org.nioun.essentials.mog.service.UserService;
import org.nioun.essentials.mog.repository.UserRepository;
import org.nioun.essentials.mog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	

	@Autowired
	private MessageSource messages ; 
	
	

	
	
	
	/* @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			return new org.springframework.security.core.userdetails.User(
					" "," " , true , true , true , true ,
					getAuthorities(Arrays.asList(
							userRepository.findByName("ROLE_USER"))));
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail() , user.getPassword() , user.isEnabled() , true , true , 
				true , getAuthorities(user.getUsers()));
		
	}
 */
	
	/* private Collection<? extends GrantedAuthority> getAuthorities(Collection<User> users){
		return getGrantedAuthorities(getPrivileges(users));
		
	}
	
	 private List<String>  getPrivileges(Collection<User> users){
	 
	 List<String> privileges = new ArrayList<>() ;
	 List<Privilege> collection = new ArrayList<>() ;	 
	 for (User user:users) {
		 collection.addAll(user.getRoles().getPrivileges());
	 }
	 for (Privilege item:collection) {
		 privileges.add(item.getName());
	 }
	 
	 return privileges ;
	 					}
	 */
	 
	 /* private  List<GrantedAuthority>  getGrantedAuthorities(List<String> privileges) {
		 List<GrantedAuthority> authorities = new ArrayList<>();
		 for (String privilege : privileges) {
			 authorities.add(new SimpleGrantedAuthority(privilege));
		 }
		 return authorities ;
	 }
	  */
	 
	

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
    userRepository.delete(user);

	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	 
	 
}