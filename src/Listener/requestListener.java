package Listener;

import item.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import util.sessionUtil;
@WebListener
public class requestListener implements ServletRequestListener
{
	private ArrayList<user> userList;
	@Override
	public void requestDestroyed(ServletRequestEvent arg0)
	{
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0)
	{
		userList=(ArrayList<user>) arg0.getServletContext().getAttribute("userList");
		
		if(userList==null)
			userList=new ArrayList<user>();
		
		HttpServletRequest request=(HttpServletRequest) arg0.getServletRequest();
		String sessionId=request.getSession().getId();
		if(sessionUtil.getUserBySessionId(userList,sessionId)==null){
			user user=new user();
			user.setSessionId(sessionId);
			user.setIpString(request.getRemoteAddr());
			user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			userList.add(user);
		}
		arg0.getServletContext().setAttribute("userList", userList);
	}
}
