// Thanks https://gist.github.com/hayderimran7/50cb1244cc1e856873a4
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def adminUserName = System.getenv("ADMIN_USERNAME")
if (adminUserName == null) { adminUserName = "admin" }

def adminPassword = System.getenv("ADMIN_PASSWORD")
if (adminPassword == null) {
  adminPassword = "demo123"
  println("""***************************************************************************************
*
* WARNING: You didn't change the default image password, there may be a security risk
* WARNING: Pass the value using 'docker run -e ADMIN_PASSWORD=theOneYouWant ...
*
* Admin login is ${adminUserName} / demo123
*
***************************************************************************************""")
}

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
println "Creating the '$adminUserName' admin user with provided password (using env var 'ADMIN_PASSWORD')"

hudsonRealm.createAccount(adminUserName, adminPassword)
instance.setSecurityRealm(hudsonRealm)

// enable html rendering of description (from antisamy-markup-formatter)
instance.setMarkupFormatter(new hudson.markup.RawHtmlMarkupFormatter(false))

def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, adminUserName)

strategy.add(Jenkins.READ, "anonymous")
strategy.add(hudson.model.Item.READ, "anonymous")
instance.setAuthorizationStrategy(strategy)

Jenkins.instance.setNumExecutors(0)

Jenkins.getInstance().save()
