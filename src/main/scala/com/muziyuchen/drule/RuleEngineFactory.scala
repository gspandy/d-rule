package com.muziyuchen.drule

import com.muziyuchen.drule.classpath.{ClasspathStatefulRuleEngine, ClasspathStatelessRuleEngine}
import com.muziyuchen.drule.gav.{GAVStatefulRuleEngine, GAVStatelessRuleEngine}
import com.muziyuchen.drule.zk.{ZKStatefulRuleEngine, ZKStatelessRuleEngine}

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
object RuleEngineFactory {

  /**
    * 创建规则引擎
    *
    * @return
    * */
  def createRuleEngine: RuleEngine = {
    val ruleEngine = new ClasspathStatefulRuleEngine
    ruleEngine
  }

  /**
    * 通过 GAV 创建规则引擎
    *
    * @param groupId
    * @param artifactId
    * @param version
    * @return
    * */
  def createGAVRuleEngine(groupId: String, artifactId: String, version: String): RuleEngine = {
    val ruleEngine = new GAVStatefulRuleEngine(groupId, artifactId, version)
    ruleEngine
  }

  /**
    * 通过 ZK 创建规则引擎
    *
    * @param connectString
    * @param path
    * @return
    * */
  def createZKRuleEngine(connectString: String, path: String): RuleEngine = {
    val ruleEngine = new ZKStatefulRuleEngine(connectString, path)
    ruleEngine
  }

  /**
    * 创建无状态的规则引擎
    *
    * @return
    * */
  def createStatelessRuleEngine: RuleEngine = {
    val ruleEngine = new ClasspathStatelessRuleEngine
    ruleEngine
  }

  /**
    * 通过 GAV 创建无状态规则引擎
    *
    * @param groupId
    * @param artifactId
    * @param version
    * @return
    * */
  def createGAVStatelessRuleEngine(groupId: String, artifactId: String, version: String): RuleEngine = {
    val ruleEngine = new GAVStatelessRuleEngine(groupId, artifactId, version)
    ruleEngine
  }

  /**
    * 通过 ZK 创建无状态规则引擎
    *
    * @param connectString
    * @param path
    * @return
    * */
  def createZKStatelessRuleEngine(connectString: String, path: String): RuleEngine = {
    val ruleEngine = new ZKStatelessRuleEngine(connectString, path)
    ruleEngine
  }

}
