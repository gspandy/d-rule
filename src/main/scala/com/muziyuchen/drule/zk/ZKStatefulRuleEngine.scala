package com.muziyuchen.drule.zk

import com.muziyuchen.drule.{RuleEngine, StatefulRuleEngine}

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
class ZKStatefulRuleEngine(connectString: String, path: String) extends StatefulRuleEngine with ZKRuleEngine {

  initZK(connectString, path)

  /**
    * 根据会话名创建会话
    *
    * @param name
    * @return
    */
  override def create(name: String): RuleEngine = {
    kieSession = kieBase.newKieSession()
    this
  }
}
