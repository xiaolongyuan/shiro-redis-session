package io.longyuan.shiro.redissession.domain;

public class ShiroUser implements java.io.Serializable {

    private static final long serialVersionUID = -2649983064333269618L;

    private final String id;
    private final String loginName;
    private final String name;
    // 是否管理员
    private final boolean isAdmin;
    private final String ip;

    private ShiroUser(Builder builder) {
        id = builder.id;
        loginName = builder.loginName;
        name = builder.name;
        isAdmin = builder.isAdmin;
        ip = builder.ip;
    }

    public static class Builder {
        private final String id;
        private final String loginName;
        private String name;
        // 是否管理员
        private boolean isAdmin;
        private String ip;

        public Builder(String id, String loginName) {
            this.id = id;
            this.loginName = loginName;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public ShiroUser builder() {
            return new ShiroUser(this);
        }

    }

    public String getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getIp() {
        return ip;
    }
}
