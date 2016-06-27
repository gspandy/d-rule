package com.muziyuchen.drule

import org.kie.api.runtime.KieSession

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
abstract class StatefulRuleEngine extends RuleEngine {

  protected var kieSession: KieSession = _

  /**
    * 插入 fact 对象
    *
    * @param any
    * @return
    */
  override def insert(any: Any): RuleEngine = {
    kieSession.insert(any)
    this
  }

  /**
    * 设置全局对象
    *
    * @param identifier
    * @param any
    * @return
    */
  override def setGlobal(identifier: String, any: Any): RuleEngine = {
    kieSession.setGlobal(identifier, any)
    this
  }

  /**
    * 根据组名 focus agenda group
    *
    * @param groupName
    * @return
    */
  override def focusAgendaGroup(groupName: String): RuleEngine = {
    kieSession.getAgenda.getAgendaGroup(groupName).setFocus
    this
  }

  /**
    * 启动规则
    *
    * @param immediately 是否立即启动
    * @return
    */
  override def fire(immediately: Boolean): RuleEngine = {
    if (immediately) kieSession.fireAllRules
    this
  }

  /**
    * 销毁会话
    *
    * @return
    */
  override def destory: RuleEngine = {
    kieSession.destroy
    this
  }
}
