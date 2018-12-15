package PurchaseSystem.service.implement;

import PurchaseSystem.dao.employeeDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private employeeDao employeeDao;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){

        return null;
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String employeename = (String) token.getPrincipal();
        String password = employeeDao.getEmployeePassword(Long.parseLong(employeename));
        if(password!=null){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(employeename,password,getName());
            return authcInfo;
        }
        else
            return null;
    }
}
