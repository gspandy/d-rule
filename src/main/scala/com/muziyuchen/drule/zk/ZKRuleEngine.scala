package com.muziyuchen.drule.zk

import org.kie.api.KieBase
import org.kie.api.builder.Message
import org.kie.api.io.ResourceType
import org.kie.internal.utils.KieHelper

/**
  * Created by LI_ZHEN on 2016/6/27.
  */
trait ZKRuleEngine {

  protected var zkDrlManager: ZKDrlManager = _

  protected var kieBase: KieBase = _

  /**
    * 初始化 ZooKeeper 管理器
    *
    * @param connectString
    * @param path
    * */
  def initZK(connectString: String = "", path: String = "/rule"): Unit = {
    zkDrlManager = new ZKDrlManager(connectString, path)
    zkDrlManager.start

    reload
    zkDrlManager.drlChanged(reload _)
  }

  def reload: Unit = {
    val kieHelper = new KieHelper()
    for (drl <- zkDrlManager.getDrls) {
      kieHelper.addContent(drl, ResourceType.DRL)
    }
    val results = kieHelper.verify()
    if (results.hasMessages(Message.Level.ERROR)) {
      //TODO
    }
    kieBase = kieHelper.build()
  }

}
