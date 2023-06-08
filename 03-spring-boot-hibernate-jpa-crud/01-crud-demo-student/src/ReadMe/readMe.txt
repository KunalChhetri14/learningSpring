JPA
Hibernate is a default impl in Spring Boot

Entity class
Java class mapped to database table
At a minimum an Entity class must have
	Must be annotated with @Entity
	Must have a public or protected no-argument constructor
		The class have other constructors

Step 1: Map class to database table
Step 2: Map fields to database column

Step 1:

@Entity
@Table(name="student")
public class Student {

}

Step 2:
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;
}

@Column-Optional : If not specified col name is same as java filed
It is not recommened as if we refactor java code then it will not match existing database columns
THis is big change as we need to update database columns which is tedious if it is enterprise app

Same applies to @Table annotation

Primary Key:
 @Id  // Says it is a primary key
 @GeneratedValue(strategy=GenerationType.IDENTITY)

 YOu can define your own custome generation strategy
 Create implementation of org.hiberante.id.IdentifierGenerator
 Override method public serializable generate()

 Student Data Access Object (DAO)
 * Responsible for interfacing with the database
 * This is a common design pattern: Data Access Object(DAO)

   CrudDemoApp <-----------> Student DAO <---------------> Database

 Student Dao
  our dao needs a entity manager
  JPA ENtity manager is the main component for saving and retrieving entities

  StudentDao <-------------> Entity Manager <-----------------> Some other components <------> Actual database

 JPA Entity Manager
  Our JPA Entity manager needs a data source
  Datasource defines database connection info
  JPA ENtity manager and datasource are automatically created by Spring Boot
    Based on the file : application.properties(JDBC url, user id, password etc)
  We can autowire or inject/inject jpa EM into out student dao
    Data Access Object <--------> EM <----------> Data Source <-------> DB

 Student dao
 1. Define dao interface
 2. define dao impl
      inject the entity manager
 3. Update main app

 Data acess object <-------> EM <------> Data Source <----->  DB

 1. define dao interface
    public interface StudentDAO {
        void save(Student theStudent);
    }
 2. define dao impl
    public class StudentDAOImpl implements StudentDAO {

      private EntityManager entityManager;
      @Autowired
      public StudentDAOImple(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
      }

      @Override
      void save(Student theStudent) {
          entityManager.persist(theStudent);
      }
    }

   Note:
   Spring provides a transactional annotation that will automatically begin and end
   a transaction for you jpa code
   Spring provides a @Repositoty anotation for anootating dao's

   @Repositioty and @RestController is subchild of @Component

   This annotation is applied to dao impl
   and spring will aotumocatically register the dao impl
    thansk to component scanning
   Spring also provides transalation of any JDBC related exceptions i.e if there is checked exc spring will transaltate
   to uncheck exceptions

   Updated version of step i.e daoImpl
    @Repository //specialized annotaiion for repository, supports component scanning, transalates jdbc exceptions
    public class StudentDAOImpl implements StudentDAO {

      private EntityManager entityManager;
      @Autowired
      public StudentDAOImple(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
      }

      @Override
      void save(Student theStudent) {
          entityManager.persist(theStudent);
      }
    }

 3.Update main app
    @SpringBootApplication
    public class  CruddemoApplication {

    	public static void main(String[] args) {
    		SpringApplication.run(CruddemoApplication.class, args);
    	}

      @Bean
      public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
          return runner -> {
            createStudent(studentDAO);
          }
      }
      public void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Kunal", "Chhhetri", "kunalchhetri14@gmail.com");

        studentDAO.save(tempStudent);

        Sop("Saved student id: "+ tempStudent.getId);
      }
    }

    //to read
    entityManager.find(Student.class, 1) //return details of id 1

    JPA Query Language (JPQL)
    Query language for retrieving objects
    Similar in concept to SQL
      where, like, order by, join, in etc
    However JPQL is based on entity name and fields

    Retreiving all Students
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName='Chhetri'", Student.class); //here FROM Student here Student is not databse table instead it is entity name, same goes for lastName
    List<Student> students = theQuery.getResultList();



