## springboot应用自动配置说明  
1. springboot应用在自动配置的时候，会先看用户有没有自己进行配置，如果用户自定义了配置，则会优先使用用户的配置，如果用户没有进行配置，则会使用自己的配置。如果配置允许多个共存，则springboot会与用户的配置合并。  
## springboot全面接管springmvc配置
1. 在springboot配置类中加上@EnableWebMvc注解  

