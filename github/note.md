1,spring mvc 的视图控制器默认会将静态资源过滤掉
解决方案:
 1,将url的映射设置为*.do,或则*.action ,不要设置为/*
 2,上面的做法就不能很好的支持restful风格了,spring mvc支持配置resource,
   <mvc:resources mapping="/" location="/" />
 3,<mvc:default-servlet-handler /> 在spring-servlet.xml文件中配置这行代码
 但是如果配置上面的一行代码,在web.xml文件中就不能配置
   <servlet-mapping>
     <servlet-name>Spring MVC Dispatcher Servlet</servlet-name>
     <url-pattern>/*</url-pattern>
   </servlet-mapping>
 /*如果这样配置的话,就又会将静态资源文件交给了Spring MVC Dispatcher