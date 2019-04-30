package org.minbox.key.plugin.security.minboxpluginsecurity;

import org.minbox.key.plugin.security.minboxpluginsecurity.key.UserBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SecurityMain {

    public static final String MINBOX_SECURITY_MAIN_USER="MINBOX_SECURITY_MAIN_USER";
    public static final String MINBOX_SECURITY_MAIN_AUTH="MINBOX_SECURITY_MAIN_AUTH";
    public static void setUser(HttpServletRequest mHttpServletRequest, UserBase mUserBase){
        mHttpServletRequest.getSession().setAttribute(MINBOX_SECURITY_MAIN_USER,mUserBase);
        mHttpServletRequest.getSession().setAttribute(MINBOX_SECURITY_MAIN_AUTH,mUserBase.getAuthKey());
    }
    public static void setAuthKey(HttpServletRequest mHttpServletRequest, List<String> AuthKey){
        mHttpServletRequest.getSession().setAttribute(MINBOX_SECURITY_MAIN_AUTH,AuthKey);
    }

    public static Object getUser(HttpServletRequest mHttpServletRequest){
       return mHttpServletRequest.getSession().getAttribute(MINBOX_SECURITY_MAIN_USER);
    }

}
