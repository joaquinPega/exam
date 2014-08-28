package org.simple.webhandler;

/*
 * Meter String a tabla en la cual el servlet busca cual pagina devolver o mensaje mostrar
 */

import java.util.List;

import org.simple.exceptions.ObjectNotFoundException;
import org.simple.handler.DeleteUser;
import org.simple.handler.UpdateUser;
import org.simple.model.User;
import org.simple.persistence.UserDAO;

public class WebHandler {

	public String startAplication() {
		// TODO: add web start security here initialize all the req for the
		// aplication
		return "Success";
	}

	public List<User> getListUsers(int page) {
		// Todo: get 20 users by page searched
		List<User> users =null;
		users =new UserDAO().getAll();
		return users;
	}
	
	public String deleteUser(User user){
		String result="aError";
		Thread deleteU = new Thread(new DeleteUser(user));
		try{
			deleteU.start();
			result="Success";
		}catch(ObjectNotFoundException e){
			result = "Edelete";
		}finally{
			deleteU=null;			
		}
		return result;
	}
	
	public String updateUser(User user) {
		String result = "Error";
		Thread updateU = new Thread(new UpdateUser(user));
		try {
			updateU.run();
			result = "Success";
		} catch (ObjectNotFoundException e) {
			result = "Eupdate";
		} finally {
			// no se me ocurre que poner
		}
		return result;
	}
}
