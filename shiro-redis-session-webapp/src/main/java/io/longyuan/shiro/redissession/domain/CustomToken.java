package io.longyuan.shiro.redissession.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

public class CustomToken implements HostAuthenticationToken, RememberMeAuthenticationToken {

    private String loginName;
    private String password;
    private String host;
    private boolean rememberMe = false;

    public CustomToken() {
    }

    public CustomToken(String loginName, String password) {
        this(loginName, password, false, null);
    }

    public CustomToken(String loginName, String password, String host) {
        this(loginName, password, false, host);
    }

    public CustomToken(String loginName, String password, boolean rememberMe) {
        this(loginName, password, rememberMe, null);
    }

    public CustomToken(String loginName, String password, boolean rememberMe, String host) {
        this.loginName = loginName;
        this.password = password;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public Object getPrincipal() {
        return getLoginName();
    }

    public Object getCredentials() {
        return getPassword();
    }

    public String getHost() {
        return host;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void clear() {
        this.loginName = null;
        this.host = null;
        this.password = null;
        this.rememberMe = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" - ");
        sb.append(loginName);
        sb.append(", rememberMe=").append(rememberMe);
        if (StringUtils.isNotBlank(host)) {
            sb.append(" (").append(host).append(")");
        }
        return sb.toString();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
