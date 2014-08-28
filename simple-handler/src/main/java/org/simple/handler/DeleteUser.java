package org.simple.handler;

import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.User;
import org.simple.persistence.UserDAO;

public class DeleteUser implements Runnable{
	private User user;

	@Override
	public void run() {
		UserDAO ud = new UserDAO();		
		try{
			ud.delete(this.user);
		}catch(ObjectNotFoundException e){
			throw e;
		}finally{
			ud = null;
		}
		
	}
	
	public DeleteUser(User user){
		this.user=user;
	}
	
	
}
