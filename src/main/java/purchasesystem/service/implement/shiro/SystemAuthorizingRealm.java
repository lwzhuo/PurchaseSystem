package purchasesystem.service.implement.shiro;

import purchasesystem.dao.EmployeeDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeDao employeeDao;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        String employeeId = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authoInfo = new SimpleAuthorizationInfo();
        List <String> roleList= employeeDao.getEmployeeRole(Long.parseLong(employeeId));
        List <String> permList = new ArrayList<String>();
        for(String role:roleList) {
            List<String> list = employeeDao.getPermissionByRole(role);
            for(String permission:list)
                permList.add(permission);
        }
        authoInfo.addRoles(roleList);
        authoInfo.addStringPermissions(permList);
        return authoInfo;
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
