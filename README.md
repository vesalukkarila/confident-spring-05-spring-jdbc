# webmvc-restservices
Introducing Spring Web MVC features

## Learning goals
Spring WebMVC setup
Writing REST services with WebMVC
Validation
Content negotiation: responses in both JSON and XML
Exception handling against bad request

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
- DispatcherServlet's jobis to dispatch requests and responses to and from controllers
- DispatcherServlet is constructed from WebApplicationContect which is constructed from configuration.class
- @Controller tells Spring that your class contains methods that can return something HTTP related (HTML, JSON, XML) to the browser.
- @ResponseBody tells Spring, that you want to write JSON/XML/plain text directly to the HttpServletOutputstream
- @RestController = @Controller + @ResponseBody
- @GetMapping("/invoices") is a shorthand annotation for RequestMapping(value = "/invoices", method = RequestMethod.GET)
- @EnableWebMvc Spring Web MVC get initialized with default configuration, e.g. registers jackson dependency i.e. enables JSON <-> Java object conversion. 
- @RequestParam @PathVariable @RequestBody (DTO, @JsonProperty) for extracting incoming data.
- Hibernate-validator(&expressly) is one popular validation framework:
  With that you can check that incoming JSON is valid against dto (@Valid + validation-annotations in DTO).
- @Validated (in Controller) + MethodValidationProcessor (in config) enables parameter and pathvariable validation.
- @RestControllerAdvice applies to both @Controller and @RestController and writes JSON/XML to response body
- @ControllerAdvice applies also to both @Controller and @RestController but writes HTML
- With the help of Jackson libraries, Java objects can be written to response body in JSON/XML, based on content negotiation.
