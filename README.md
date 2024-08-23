# Dynamic Database Routing in Spring Boot

This repository contains code for custom annotations in a Spring Boot application that enable dynamic database routing based on the context of the request. The annotations allow you to specify which database to use at both the class and method levels.

## Features

- **Dynamic Database Routing:** Directs requests to different databases based on annotations.
- **Class-Level and Method-Level Annotations:** Allows setting database choices at both levels.
- **Priority Handling:** Method-level annotations override class-level annotations.

## Annotations

### `@UsingDb`

- **Description:** Specifies which database to use for the annotated class or method.
- **Usage:**
  - `@UsingDb(DatabaseType.READ)`: Directs requests to the read database.
  - `@UsingDb(DatabaseType.WRITE)`: Directs requests to the write database.

### Behavior

- **Class-Level Annotations:** When `@UsingDb` is added to a class, all methods within that class inherit this setting.
- **Method-Level Annotations:** When `@UsingDb` is added to a method, it overrides the class-level annotation for that method.

### Example

```java
@UsingDb(DatabaseType.READ)
public class SomeService {

    @UsingDb(DatabaseType.WRITE)
    public void someMethod() {
        // This method will use the write database.
    }

    public void anotherMethod() {
        // This method will use the read database (inherited from the class-level annotation).
    }
}
```

## Reference

This implementation is inspired by the [Baeldung article on Abstract Routing Data Source](https://www.baeldung.com/spring-abstract-routing-data-source).

## Setup

1. **Add Dependencies:** Ensure you have the necessary dependencies for Spring Boot and data sources in your `pom.xml` or `build.gradle`.
2. **Configure Data Sources:** Define your read and write data sources in the `application.properties` or `application.yml`.
3. **Implement Routing Logic:** Use the provided annotations to configure database routing in your service classes.

