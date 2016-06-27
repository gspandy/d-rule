package com.muziyuchen.drule.gav

import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer

/**
  * Created by LI_ZHEN on 2016/6/27.
  */
trait GAVRuleEngine {

  protected var kieContainer: KieContainer = _

  def initGAV(kieServices: KieServices, groupId: String, artifactId: String, version: String): Unit = {
    kieContainer = kieServices.newKieContainer(kieServices.newReleaseId(groupId, artifactId, version))

    val kieScanner = kieServices.newKieScanner(kieContainer)
    kieScanner.scanNow()
    kieScanner.start(1000L * 10)
  }

}
