# Demo RestClient with method GET

- Start app and you will see

RestClient was create by this way can call API with method GET and Body
```java
@Bean
RestClient createRestClient() {

  return RestClient.create();
}
```

But RestClient was create by this way **CAN NOT** call API with method GET and Body
```java
@Bean
RestClient builderRestClient(RestClient.Builder builder) {

  return builder.build();
}
```

Log when application start

```text
2024-06-04T06:42:28.943+07:00  INFO 4560 --- [demo] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
{message=Hello World!}
2024-06-04T06:42:29.065+07:00  WARN 4560 --- [demo] [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing: java.util.Map<java.lang.String, java.lang.String> com.example.demo.HomeController.get(java.util.Map<java.lang.String, java.lang.String>)]
2024-06-04T06:42:29.101+07:00  INFO 4560 --- [demo] [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-06-04T06:42:29.116+07:00 ERROR 4560 --- [demo] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.web.client.HttpClientErrorException$BadRequest: 400 : "{"timestamp":"2024-06-03T23:42:29.075+00:00","status":400,"error":"Bad Request","path":"/get"}"
	at org.springframework.web.client.HttpClientErrorException.create(HttpClientErrorException.java:103) ~[spring-web-6.1.8.jar:6.1.8]
	at org.springframework.web.client.StatusHandler.lambda$defaultHandler$3(StatusHandler.java:86) ~[spring-web-6.1.8.jar:6.1.8]
```