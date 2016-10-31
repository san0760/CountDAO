package Listener;

import item.user;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import util.sessionUtil;
@WebListener
public class SessionListener implements HttpSessionListener
{
	private int userNumber=0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		userNumber++;
		arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		userNumber--;
		arg0.getSession().getServletContext().setAttribute("userNumber", userNumber);
		ArrayList<user> userList=null;
		userList=(ArrayList<user>) arg0.getSession().getServletContext().getAttribute("userList");
		if(sessionUtil.getUserBySessionId(userList, arg0.getSession().getId())!=null)
			userList.remove(sessionUtil.getUserBySessionId(userList, arg0.getSession().getId()));
	}

}
