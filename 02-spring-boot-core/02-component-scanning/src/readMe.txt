For setting base package of component scan
In main app
@SpringBootApplication (
  scanBasePackages = {
    "com.kunal.springBootDependencyInjection.SpringApp",
    "com.kunal.springBootDependencyInjection.util"
  }
)
