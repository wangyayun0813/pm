package com.yling.common.shiro.realm;

import com.yling.common.base.SiteContants;
import com.yling.common.shiro.exception.MyAuthenticationException;
import com.yling.modules.models.Role;
import com.yling.modules.models.User;
import com.yling.modules.service.RoleService;
import com.yling.modules.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.nutz.dao.Cnd;
import org.nutz.lang.Strings;
import org.nutz.mvc.Mvcs;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/15.
 * 修改人：
 */
public class DaoAuthRealm extends AuthorizingRealm
{
    protected UserService userService;
    protected RoleService roleService;

    protected UserService getUserService()
    {
        if(null == userService)
            userService = Mvcs.getIoc().get(UserService.class);
        return userService;
    }

    protected RoleService getRoleService()
    {
        if(null == roleService)
            roleService = Mvcs.getIoc().get(RoleService.class);
        return roleService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal)
    {
        User user = (User) principal;
        if (null != user)
        {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(getUserService().getRoleNames(user));
            for(Role r:user.getRoles())
            {
                if(r.getDisabled().shortValue() == SiteContants.FLAG_YES)
                    info.addStringPermissions(getRoleService().getPermissionNameList(r));
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        CaptchaToken token = (CaptchaToken) authenticationToken;
        String username = token.getUsername();
        if(Strings.isEmpty(username))
            throw new MyAuthenticationException("用户名不能为空！");
        User user = getUserService().fetch(Cnd.where("login_name", "=", username));
        if(null == user)
            throw new MyAuthenticationException("用户未注册！");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginPassword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(SiteContants.SALT));
        return info;
    }
}
