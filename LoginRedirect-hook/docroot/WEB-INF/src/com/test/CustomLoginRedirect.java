package com.test;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLoginRedirect extends Action {
	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.SimpleAction#SimpleAction()
	 */
	public CustomLoginRedirect() {
		super();
	}

	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.SimpleAction#run(String[] ids)
	 */
	public void run(String[] ids) throws ActionException {
		for (int i = 0; i < ids.length; i++) {
			System.out.println("ok =="+ids[i]);
		}
		
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		try {
			
			System.out.println("usertoRe=="+GroupLocalServiceUtil.getGroup(10803).getFriendlyURL());
			System.out.println("logged user's groupId=="+PortalUtil.getScopeGroupId(request));
			if(Validator.isNotNull(PortalUtil.getScopeGroupId(request))) {
			System.out.println("group redirect url="+GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getFriendlyURL());
//			response.sendRedirect(PortalUtil.getPortalURL(request)+GroupLocalServiceUtil.getGroup(10803).getFriendlyURL());
			response.sendRedirect("http://www.google.com");
			}
//			response.sendRedirect(PortalUtil.getPortalURL(request)+GroupLocalServiceUtil.getGroup(10803).getFriendlyURL());
			response.sendRedirect("http://www.google.com");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}