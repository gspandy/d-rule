package com.muziyuchen.drule

import org.kie.api.command.{Command, KieCommands}
import org.kie.api.runtime.StatelessKieSession

import scala.collection.mutable


/**
  * Created by LI_ZHEN on 2016/6/23.
  */
abstract class StatelessRuleEngine extends RuleEngine {

  protected var kieSession: StatelessKieSession = _

  protected val commandFactory: KieCommands = kieServices.getCommands

  protected val commands = mutable.MutableList[Command[Any]]()

  /**
    * 插入 fact 对象
    *
    * @param any
    * @return
    */
  override def insert(any: Any): RuleEngine = {
    commands :+ commandFactory.newInsert(any)
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
    commands :+ commandFactory.newSetGlobal(identifier, any)
    this
  }

  /**
    * 根据组名 focus agenda group
    *
    * @param groupName
    * @return
    */
  override def focusAgendaGroup(groupName: String): RuleEngine = {
    commands :+ commandFactory.newAgendaGroupSetFocus(groupName)
    this
  }

  /**
    * 启动规则
    *
    * @param immediately 是否立即启动
    * @return
    */
  override def fire(immediately: Boolean): RuleEngine = {
    if (immediately) {
      commands :+ commandFactory.newFireAllRules
      kieSession.execute(commands)
      commands.clear()
    }
    this
  }

  /**
    * 销毁会话
    *
    * @return
    */
  override def destory: RuleEngine = {
    this
  }
}
