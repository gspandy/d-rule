package com.muziyuchen.drule.gav

import com.muziyuchen.drule.{RuleEngine, StatelessRuleEngine}

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
class GAVStatelessRuleEngine(groupId: String, artifactId: String, version: String) extends StatelessRuleEngine with GAVRuleEngine {

  initGAV(kieServices, groupId, artifactId, version)

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
