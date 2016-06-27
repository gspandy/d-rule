package com.muziyuchen.drule.zk

import org.apache.curator.framework.{CuratorFramework, CuratorFrameworkFactory}
import org.apache.curator.framework.recipes.cache.PathChildrenCache
import org.apache.curator.retry.ExponentialBackoffRetry

import scala.collection.mutable
import scala.collection.JavaConversions._

/**
  * Created by LI_ZHEN on 2016/6/23.
  */
private[zk] class ZKDrlManager(connectString: String, path: String) {

  private var client: CuratorFramework = _

  private var cache: PathChildrenCache = _

  def start: Unit = {
    client = CuratorFrameworkFactory.newClient(connectString, new ExponentialBackoffRetry(1000, 3))
    client.start
    client.blockUntilConnected

    cache = new PathChildrenCache(client, path, true)
    cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE)
  }

  def getDrls: mutable.MutableList[String] = {
    var drls = new mutable.MutableList[String]()

    for (childData <- cache.getCurrentData) {
      val drl = new String(childData.getData(), "UTF-8")
      drls += drl
    }

    drls
  }

  def close:Unit = {
    cache.close
    client.close
  }

}
