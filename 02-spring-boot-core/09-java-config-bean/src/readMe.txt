Sometimes we might need to work on third party library therefore they haven't implemented
@Component for their class so we might have to manually create a bean

To create a bean first we will be using @Configuration
the @Bean to return new Bean of particular class type
by default the method name will act as beans while referring using @Qualifiers


Ex:

@Configuration
public class SportsConfig {

  @Bean   //insert @Bean("beanId") to change default bean id
  public Coach swimCoach() {  //the bean id defaults to method name
    return new SwimCoach();
  }
}


Step 3:
Inject bean in our controller
@Autowired
public DemoController(@Qualifier("swimCoach") {

}

Use case for bean annotation
Why not simply do @Component to create beans as we are using new keyword here while creating bean??

Main usecase:
make existing third party class available to spring framework
You may not have access to third party source code , you may just have access to jar file
However you would like to use that class as a spring bean


Real world example:
While using aws it has one feature called Amazon S3(Amzon Simple Storage Service)
S3 is a cloud based system for storing pdf, images or any binary object

We want to use aws S3 client as a Spring bean in our app

Now the aws s3 is part of aws sdk
we can't modify source code as we have just jar file
we can't just add @Component

However we can configure using bean annotation i.e @Bean

Example code
@Configuration
public class DocumentConfig {

  @Bean
  public S3Client remoteClient() {
    //Create an s3 client to connect to AWS S3
    ProfileCredentialsProvider creadentialsProvider = ProfileCredentialsProvider.create();
    Region region = Region.US_EAST_1;
    S3Client s3Client = S3Client.builder()
                         .region(region)
                         credentialsProvider(creditalProvider)
                         .build();
    return s3Client;
  }
}

@Component
public class DocumentService {

  private S3Client s3Client;

  @Autowired
  public DocumentService(S3Client s3Client) {
    s3Client = s3Client;
  }

  public void processDocuments(Document document) {

      //Store document in s3
  }
}

