package util;

import item.user;

import java.util.ArrayList;


public class sessionUtil
{
	public static Object getUserBySessionId(ArrayList<user> userList,String sessionId)
	{
		for(int i=0;i<userList.size();i++){
			user user=userList.get(i);
			if(user.getSessionId().equals(sessionId)){
				return user;
			}
		}
		return null;
	}
}
