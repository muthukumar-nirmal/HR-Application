# HR-Application
This is a human resource management application

A human resources management system (HRMS) or human resources information system (HRIS) is a form of human resources (HR) software that combines a number of systems and processes to ensure the easy management of human resources, business processes and data. Human resources software is used by businesses to combine a number of necessary HR functions, such as storing employee data, managing payrolls, recruitment processes, benefits administration, and keeping track of attendance records.

A human resources management system ensures everyday human resources processes are manageable and easy to access. It merges human resources as a discipline and, in particular, its basic HR activities and processes with the information technology field, whereas the programming of data processing systems evolved into standardized routines and packages of enterprise resource planning (ERP) software. On the whole, these ERP systems have their origin from software that integrates information from different applications into one universal database. The linkage of its financial and human resource modules through one database is the most important distinction to the individually and proprietarily developed predecessors, which makes this software application both rigid and flexible.

Human resource information systems provide a means of acquiring, storing, analyzing and distributing information to various stakeholders.[1] HRIS enable improvement in traditional processes and enhance strategic decision-making.[1] The wave of technological advancement has revolutionized each and every space of life today, and this includes HR. Early systems were narrow in scope, typically focused on a single task, such as improving the payroll process or tracking employees' work hours. Today's systems cover the full spectrum of tasks associated with human resources departments, including tracking and improving process efficiency, managing organizational hierarchy, tracking absence and annual leave, simplifying financial transactions, and providing reports on people data. In short, as the role of human resources departments expanded in complexity, HR technology systems evolved to fit these needs.


mvn spring-boot:run

# Rest Endpoints
- Add below Depndency
	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
- HTTP Methods
	- GET
	   	- Pathparam
	   	- RequestParam
	- PUT
	- POST
	- DELETE
	- HTTP Status codes
	- Mediatypes
	 	- Produces
	 	- Consumes

#  ORM Integration(hibenrate to Mysql/Oracle/Postgree/MS SQL/H2)
- Add below Dependency

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
- Create a model with below Annotations
	- @Entity
	- @Id
- Create a Repository
	
		@Repository
		public interface StudentRepository extends JpaRepository<Student, Integer> {
		//Code Generation Technique: DSL 
		}

# Swagger 
-   Add dependencies in pom.xml
-	Swagger API depedency & Swagger UI dependency		
		
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

-   Add @ Bean for DocketAPI
-   
		@Bean
    	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
   		 }
-	open url :http://localhost:port/context-path/swagger-ui.html


# Datasource creation
- @ Bean for Programatic Data Source
- use the below config for Datasource

		spring:
		  datasource:
			url: jdbc:mysql://localhost:3306/mysql
			username: root
			password: root
			driver-class-name: com.mysql.cj.jdbc.Driver


#   Actuator Endpoints
- Add below Dependency in the pom.xml
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>		
- By default all actuator endpoints can be seen :
		      "http://serveropaddress:port/context-path/actuator"
- By default Endpoints are disabled due to Secure data
- enable all endpoints by : management.endpoints.web.exposure.include: "*"
- Shutdown endpoint needs to be enabled. This will not be covered in all(*)



# Spring Annotations
- @Component
- @RestController
- @RequestMapping
- @Service
- @Repository
- @SpringBootApplication
- @Bean
- @Autowired
- @Query
- @Transactional
# Dev tools
- HMR(Hot Module Replacement)
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
- Ensures Restart of Project upon save
- It does not detect the pom.xml changes

# Reading Properties Files inside the program
- for Multiple Properties

		@Autowired
		Environment env; 
- for single property
			
		@Value("property.name)

# Bean Validation
- use @ Valid wherever it needs to be validated
- @NotNull
- @Email
- @Min
- @Max
- @Size
- @Past/@Future
- @Negative/@Positive

# Rest Consumers
- http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm

