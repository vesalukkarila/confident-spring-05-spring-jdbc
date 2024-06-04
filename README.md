# webmvc-restservices
Introducing Spring Web MVC features

## Learning goals
  

## Sources
Based largely on learnings from Marco Behler's course "The confident Spring professional" https://www.marcobehler.com/ which I bought for myself in order to understand the fundamentals of Spring. 
After going through the course twice, going at it for the third time. Minimal comments for clarity, checking source code only when necessary.

## Use
Endpoints for local use:
- GET "/" 
- GET "/invoices" 
- POST "/invoices?user_id=jeff&amount=40" 
- POST "/invoices/jeff/40"
- POST "/invoicesbody" + user_id & amount in request body
- Content negotiation: Request header's Accept and Content-Type can both be either "application/json" or "application/xml"

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
