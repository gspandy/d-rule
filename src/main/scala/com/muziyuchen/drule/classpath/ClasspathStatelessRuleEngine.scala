package com.muziyuchen.drule.classpath

import com.muziyuchen.drule.{RuleEngine, StatelessRuleEngine}
import org.kie.api.runtime.KieContainer

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
class ClasspathStatelessRuleEngine extends StatelessRuleEngine {

  private val kieContainer: KieContainer = kieServices.newKieClasspathContainer

  /**
    * 根据会话名创建会话
    *
    * @param name
    * @return
    */
  override def create(name: String): RuleEngine = {
    if (name.isEmpty) kieSession = kieContainer.newStatelessKieSession()
    else kieSession = kieContainer.newStatelessKieSession(name)
    this
  }
}
