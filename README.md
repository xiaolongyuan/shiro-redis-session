
使用redis作为shiro实现集群会话管理，并可配置ehcache作为进程内缓存，通过redis消息订阅发布实现session缓存统一

详细介绍见 Shiro通过Redis管理会话实现集群 http://sgq0085.iteye.com/blog/2170405 

shiro-redis-session
	jar
shiro-redis-session-webapp
	示例demo
	
###Issues：
https://github.com/xiaolongyuan/shiro-redis-session/issues	
###RoadMap:
* 修复已知问题
* 添加accessToken使用及示例
	
###主要参考：
https://github.com/sgq0085/learn 替换redis使用为spring data redis


###推荐文章：
* Shiro通过Redis管理会话实现集群 http://sgq0085.iteye.com/blog/2170405 
* shiro教程 http://jinnianshilongnian.iteye.com/category/305053
* JWT 在前后端分离中的应用与实践 http://www.open-open.com/lib/view/open1433995002942.html
* 理解OAuth 2.0 http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html
* 使用Token作为凭证，从App免登陆跳转到Web是否足够安全？ http://segmentfault.com/q/1010000002641130
* md语法 https://github.com/guoyunsky/Markdown-Chinese-Demo http://wowubuntu.com/markdown/

###项目依赖：
> 	shiro 1.2.3+
> 	spring data redis 1.6.0+
	
###github 地址
> 	https://github.com/xiaolongyuan/shiro-redis-session

###oschina 地址
> 	http://git.oschina.net/xiaolongyuan/shiro-redis-session

