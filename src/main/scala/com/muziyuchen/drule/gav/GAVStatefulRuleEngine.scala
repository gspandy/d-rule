package com.muziyuchen.drule.gav

import com.muziyuchen.drule.{RuleEngine, StatefulRuleEngine}

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
class GAVStatefulRuleEngine(groupId: String, artifactId: String, version: String) extends StatefulRuleEngine with GAVRuleEngine {

  initGAV(kieServices, groupId, artifactId, version)

  /**
    * 根据会话名创建会话
    *
    * @param name
    * @return
    */
  override def create(name: String): RuleEngine = {
    if (name.isEmpty) kieSession = kieContainer.newKieSession()
    else kieSession = kieContainer.newKieSession(name)
    this
  }
}
