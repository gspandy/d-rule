package com.muziyuchen.drule

import org.kie.api.KieServices

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
trait RuleEngine {

  protected val kieServices: KieServices = KieServices.Factory.get

  /**
    * 根据会话名创建会话
    *
    * @param name
    * @return
    */
  def create(name: String = ""): RuleEngine

  /**
    * 插入 fact 对象
    *
    * @param any
    * @return
    */
  def insert(any: Any): RuleEngine

  /**
    * 设置全局对象
    *
    * @param identifier
    * @param any
    * @return
    */
  def setGlobal(identifier: String, any: Any): RuleEngine

  /**
    * 根据组名 focus agenda group
    *
    * @param groupName
    * @return
    */
  def focusAgendaGroup(groupName: String): RuleEngine

  /**
    * 启动规则
    *
    * @param immediately 是否立即启动
    * @return
    */
  def fire(immediately: Boolean = true): RuleEngine

  /**
    * 销毁会话
    *
    * @return
    */
  def destory: RuleEngine

}
