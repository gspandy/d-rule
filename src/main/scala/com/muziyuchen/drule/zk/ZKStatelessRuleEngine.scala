package com.muziyuchen.drule.zk

import com.muziyuchen.drule.{RuleEngine, StatelessRuleEngine}

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
class ZKStatelessRuleEngine(connectString: String, path: String) extends StatelessRuleEngine with ZKRuleEngine {

  initZK(connectString, path)

  /**
    * 根据会话名创建会话
    *
    * @param name
    * @return
    */
  override def create(name: String): RuleEngine = {
    kieSession = kieBase.newStatelessKieSession()
    this
  }
}
