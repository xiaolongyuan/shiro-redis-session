package io.longyuan.shiro.redissession.realm;

import com.google.common.collect.Lists;
import io.longyuan.shiro.redissession.domain.CustomToken;
import io.longyuan.shiro.redissession.domain.ShiroUser;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

public class ShiroDbRealm extends AuthorizingRealm {


    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int SALT_SIZE = 8;
    public static final int HASH_INTERATIONS = 1024;

//    @Autowired
//    private CachingSessionDAO sessionDao;

    public ShiroDbRealm() {
        super();
        setAuthenticationTokenClass(CustomToken.class);
    }

    /**
     * 认证回调函数,登录时调用.
     * AuthenticationInfo 中principal会设置到Session中并通过SessionDao保存起来
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        CustomToken token = (CustomToken) authcToken;
        String loginName = token.getLoginName();
        String host = token.getHost();

        // TODO 通过token，连接数据库或单点服务器认证登陆

        // 创建principal身份
        ShiroUser su = new ShiroUser.Builder("id", loginName).name("name").isAdmin(true).ip(host).builder();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(su, token.getPassword(), getName());
        if ("fail".equals(loginName)) {
            return null;
        }

//        // TODO: 测试用代码，修改session中属性集群中其他节点也会发生改变
//        Subject subject = SecurityUtils.getSubject();
//        Serializable sessionId = subject.getSession().getId();
//        ShiroSession session = (ShiroSession) sessionDao.readSession(sessionId);
//        Map<String, String> customMap = Maps.newHashMap();
//        customMap.put("test", "value");
//        session.setAttribute("custom", customMap);
//        sessionDao.update(session);

        return info;
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     * 只会被缓存，不会被设置到Session中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 添加角色
        info.addRole("admin");

        // 添加权限
        List<String> permList = Lists.newArrayList();
        permList.add("permission_admin");
        info.addStringPermissions(permList);

        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
//    @PostConstruct
//    public void initCredentialsMatcher() {
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
//        matcher.setHashIterations(HASH_INTERATIONS);
//        setCredentialsMatcher(matcher);
//    }

}
