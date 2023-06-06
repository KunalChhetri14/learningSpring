Bean Scopes:
Scope refers to lifecycle of bean
how long does the bean live
how many instances are created
how is the bean shared

By default scope is singleton
Singleton:  Spring container only creates one instance by default which is cached in memory and shared among different items

Explicaitly specify bean scope

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

}

Other scropes are
Prototype: Creates a new bean isntance for each container request
request: Scoped to a HTTP web request. Only used for webapps
session: Scoped to a HTTP web session. Only used for webapps
global: Scoped to a global HTTP web session. Only used for webapps
