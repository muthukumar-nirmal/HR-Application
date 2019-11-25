# HR-Application
This is a human resource management application

Rest Endpoints
Add below Depndency

  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-web</artifactId>
  </dependency>
HTTP Methods

GET
Pathparam
RequestParam
PUT
POST
DELETE
HTTP Status codes
Mediatypes
Produces
Consumes

ORM Integration(hibenrate to Mysql/Oracle/Postgree/MS SQL/H2)
Add below Dependency

  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
Create a model with below Annotations

@Entity
@Id
Create a Repository

  @Repository
  public interface StudentRepository extends JpaRepository<Student, Integer> {
  //Code Generation Technique: DSL 
  }



# Swagger
Add dependencies in pom.xml

Swagger API depedency & Swagger UI dependency

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>

Add @ Bean for DocketAPI

  @Bean
  public Docket api() { 
  return new Docket(DocumentationType.SWAGGER_2)  
    .select()                                  
    .apis(RequestHandlerSelectors.any())              
    .paths(PathSelectors.any())                          
    .build();                                           
   }
open url :http://localhost:port/context-path/swagger-ui.html
