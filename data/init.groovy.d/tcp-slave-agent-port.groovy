import hudson.model.*;
import jenkins.model.*;

Thread.start {
      sleep 10000
      Jenkins.instance.setSlaveAgentPort(-1)
      def sshd = org.jenkinsci.main.modules.sshd.SSHD.get()
      sshd.setPort(-1)

      println "--> disabled jnlp... done"
}
