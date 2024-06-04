# simple-webapp-IoC-basics
Introducing Spring Core features, building on top of simple-webapp repository

## Learning goals
Maven dependencies  
Basics of Spring Core features:  
@Configuration, @Beans, @Scopes, @Component, @ComponentScan  
@Autowired(constructor&field&setter injections), @Bean lifecycles  
Resources, Properties and Profiles.  

## Sources
Based largely on learnings from Marco Behler's course "The confident Spring professional" https://www.marcobehler.com/ which I bought for myself in order to understand the fundamentals of Spring. 
After going through the course twice, going at it for the third time. Minimal comments for clarity, checking source code only when necessary.

## Use
Endpoints for local use:
- GET "/" returns html greeting
- GET "/invoices" returns all posted invoices as JSON
- POST "/invoices?user_id=jeff&amount=40" creates an invoice and returns it as JSON
- POST "/*" returns 404

## Key takeaways
- ApplicationContext is central interface for Spring IoC
- ApplicationContext is constructed from @Configuration class
- Beans are accessed through applicationContext
- @Bean's scope is singleton by default (remember thread safety)
- Instead of configuring beans in config, use @Component (or Service/Repository/Controller/RestController which are also Components) and set @ComponentScan in @Configuration class
- Use constructor injection for mandatory and setter injection for optional dependencies.
- @Autowired not required after Spring 4.3, but can be used for clarity.
- Use @Bean with 3rd party libraries that don't have explicit Spring support.
- Lifecycle callbacks: @PostConstruct and @PreDestroy (remember .registerShutDownHook() )
- @PropertySource needs to be set in config file (remember, order matters if several), properties accessed through @Value
- @Profile("env"): Class will run only in specified profile (remember to set VM options)
- @PropertySource can be choosen to be used only when run in certain profile
