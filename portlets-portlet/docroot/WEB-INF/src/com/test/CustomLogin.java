package com.test;

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Portlet implementation class CustomLogin
 */
public class CustomLogin extends MVCPortlet {
 
	public void Login(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String username = ParamUtil.getString(actionRequest, "username");
			String password = ParamUtil.getString(actionRequest, "password");
			MethodKey key = new MethodKey("com.liferay.portlet.login.util.LoginUtil", "login", HttpServletRequest.class, HttpServletResponse.class, String.class, String.class, boolean.class, String.class);
	PortalClassInvoker.invoke(false, key, new Object[] { PortalUtil.getHttpServletRequest(actionRequest), PortalUtil.getHttpServletResponse(actionResponse), username, password, false, null});
} catch (Exception e) {
	e.printStackTrace();
}
ThemeDisplay themeDisplay  = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

actionResponse.sendRedirect(themeDisplay.getPathMain());
	}

}
