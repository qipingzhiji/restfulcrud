# springboot 应用中对静态资源加载的配置说明  
 
 ```
@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			if (!this.resourceProperties.isAddMappings()) {
				logger.debug("Default resource handling disabled");
				return;
			}
			Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
			CacheControl cacheControl = this.resourceProperties.getCache()
					.getCachecontrol().toHttpCacheControl();
			if (!registry.hasMappingForPattern("/webjars/**")) {
				customizeResourceHandlerRegistration(registry
						.addResourceHandler("/webjars/**")
						.addResourceLocations("classpath:/META-INF/resources/webjars/")
						.setCachePeriod(getSeconds(cachePeriod))
						.setCacheControl(cacheControl));
			}
			String staticPathPattern = this.mvcProperties.getStaticPathPattern();
			if (!registry.hasMappingForPattern(staticPathPattern)) {
				customizeResourceHandlerRegistration(
						registry.addResourceHandler(staticPathPattern)
								.addResourceLocations(getResourceLocations(
										this.resourceProperties.getStaticLocations()))
								.setCachePeriod(getSeconds(cachePeriod))
								.setCacheControl(cacheControl));
			}
		}
```


+ 第一种方式  
webjars:所有/webjars/**,都去classpath:/META/resources/webjars/找资源  
webjars以jar包的方式引入静态资源  
[www.webjars.org](www.webjars.org) 
+ 第二种方式  
 /** 访问当前目录下的任何资源(静态资源的文件夹)  
 1. classpath:/META-INF/resources/
 2. classpath:/resources/
 3. classpath:/static/
 4. classpath:/public
 5. / 当前项目的根路径
 
 + 第三种方式  
 ```
    @Bean
    public WelcomePageHandlerMapping welcomePageHandlerMapping(
 				ApplicationContext applicationContext) {
 			return new WelcomePageHandlerMapping(
 					new TemplateAvailabilityProviders(applicationContext),
 					applicationContext, getWelcomePage(),
 					this.mvcProperties.getStaticPathPattern());
 		}

```
 欢迎页，静态资源的文件夹下的所有index.html页面，被/**映射，也就是说在你访问localhost:8080的时候会去项目静态资源目录下找index.html文件  

+ 第四种方式  
  所有的**/favicon.ico都是在静态资源文件夹下找  
