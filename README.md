# webmvc-restservices


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

