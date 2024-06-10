# webmvc-thymeleaf


## Learning goals
Basics of:
- Rendering HTML with WebMVC
- Working with templating library Thymeleaf
- Form submissions

## Sources
Based largely on learnings from Marco Behler's course "The confident Spring professional" https://www.marcobehler.com/ which I bought for myself in order to understand the fundamentals of Spring. 
After going through the course twice, going at it for the third time. Minimal comments for clarity, checking source code only when necessary.

## Use
Endpoints for local use:
- GET "/" optionally "/?username=jeff"
- GET "/login"
- POST "login", korjaa kunnolliseksi rajapintadokumentaatioksi 

## Key takeaways

@Controller, without additional annotations, class serves html  
For Thymeleaf and Spring to work together register following three @Beans:  
- ThymeLeafViewResolver; Tells Spring it should try to find Thymeleaf templates  
- SpringTemplateEngine; Thymeleaf-specific configuration bean, hooks up Spring MVC and Thymeleaf  
- SpringResourceTemplateResolver; Class that actually finds your Thymeleaf template

Through Model (essentially a map-container) you provide variables to the template.  
Spring injects Model into every @Controller method if specified as parameter.  
Thymeleaf tags have lots of code-like functionalities.    
