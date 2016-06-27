# d-rule
d-rule 是一个基于 Drools 的规则引擎，支持通过以下方式创建规则引擎：

* classpath  扫描 ClassPath 下的规则
* gav  通过 Maven 的 GroupID AtifactID 和 Version 扫描本地 Maven 仓库下的规则
* zookeeper  ZooKeeper 中存储的规则

## 使用

``` scala
// 使用规则引擎工厂创建规则引擎
val ruleEngine = RuleEngineFactory.getRuleEngine

// 创建规则引擎并执行
ruleEngine.create().fire()
```