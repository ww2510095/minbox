package org.minbox.key.plugin.security.minboxpluginsecurity.config;

import org.minbox.key.plugin.security.minboxpluginsecurity.SecurityMain;
import org.minbox.key.plugin.security.minboxpluginsecurity.dataResources.AuthException;
import org.minbox.key.plugin.security.minboxpluginsecurity.dataResources.MinboxSecurityAuth;
import org.minbox.key.plugin.security.minboxpluginsecurity.dataResources.NotAuth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

public class MinboxSecurityHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HandlerMethod method;
        try {
             method = (HandlerMethod) o;
        }catch (Exception e){
            return true;
        }

        NotAuth mNotAuth=method.getMethodAnnotation(NotAuth.class);
        if(mNotAuth!=null)return  true;
        mNotAuth=method.getBean().getClass().getAnnotation(NotAuth.class);
        if(mNotAuth!=null)return  true;
        HttpSession mHttpSession=httpServletRequest.getSession();
        List<String> listauth = (List<String>) mHttpSession.getAttribute(SecurityMain.MINBOX_SECURITY_MAIN_AUTH);
        if(listauth==null)throw  new AuthException();

        MinboxSecurityAuth mMinboxSecurityAuth = method.getMethodAnnotation(MinboxSecurityAuth.class);
       if(mMinboxSecurityAuth==null)
           mMinboxSecurityAuth = method.getBean().getClass().getAnnotation(MinboxSecurityAuth.class);
        if(mMinboxSecurityAuth!=null){
            if(mMinboxSecurityAuth.isAuthAll()){
                if(listauth.containsAll(Arrays.asList(mMinboxSecurityAuth.SecurityAuthKey())))
                    return true;
                else
                    throw  new AuthException();
            }else{
                for (String str :mMinboxSecurityAuth.SecurityAuthKey()){
                    if(listauth.contains(str))
                        return true;
                }
                throw  new AuthException();
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
