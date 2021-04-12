Spring Cloud Alibaba(4)---nacos(配置中心）

有关Spring Cloud Alibaba之前写过四篇文章，这篇也是在上面项目的基础上进行开发。

[Spring Cloud Alibaba(1)---入门篇](https://www.cnblogs.com/qdhxhz/p/14563991.html)
[Spring Cloud Alibaba(2)---Nacos概述](https://www.cnblogs.com/qdhxhz/p/14575355.html)



有关配置中心，之前也详细写过Apollo配置中心，所以一些有关配置中心的理论知识，这里就不在陈述，具体看下面文章

[Apollo(1)--- Apollo入门介绍篇](https://www.cnblogs.com/qdhxhz/p/13388054.html)
[Apollo(2)--- Apollo架构设计](https://www.cnblogs.com/qdhxhz/p/13394182.html)
[Apollo(3)--- SpringBoot整合Apollo](https://www.cnblogs.com/qdhxhz/p/13449285.html)

###前言



有关nacos客户端的搭建和nacos的介绍在 **Spring Cloud Alibaba(2)---Nacos概述** 都有讲到，所以这里不在陈述。
这里在商品博客项目基础上，来实现配置中心的工作。




一、Nacos 服务端初始化

 1、启动Nacos客户端

 启动Nacos Server,有关Nacos搭建我这里不在陈述，上面博客有些，或者直接看官网如何搭建：[Nacos 官网]
 ```
sh startup.sh -m standalone
```

 2、启动好Nacos之后，在Nacos添加如下的配置
 
图（1）
 
 具体含义下面介绍
 
 <br>
 
 二、springBoot整合Nacos(配置中心）
 
 
 1、pom.xml
 
 ```xml
  <!--添加nacos配置中心-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```
 
 2、Controller层
 
 ```java
@RestController
@RequestMapping("api/v1/config")
public class ConfigTestController {

    /**
     * nacos获取配置
     */
    @Value("${user.name}")
    private String name;

    @RequestMapping("test-config")
    public Object findByGoodsId() {
        System.out.println("name = " + name);
        return name;
    }

}
```
 
 3、bootstrap.yml
 
 ```yml
spring:
  application:
    name: mall-goods

  cloud:
    nacos:
      config:
        server-addr: 127.0.0.1:8848 #Nacos配置中心地址
        file-extension: yaml #文件拓展格式

  profiles:
    active: dev
```
 
 
 4、测试
 
 （图2）
 
 
 <br>
 
 三、Nacos配置管理的模型
 
 
 
 对于nacos配置管理, 通过namespace, group, dataId能够定位到一个配置集.
 
 （图3）
 
 
 1、配置管理模型概念
 
 
 1) Namespace(命名空间)
 
 命名空间(namespace)可用于对不同的环境进行配置隔离. 例如: 可以隔离开发环境, 测试环境, 生成环境. 因为他们的配置可能各不相同. 或者是隔离不同的用户, 不同的开发人员使用同一个nacos管理各自的配置, 可通过namespace进行隔离. 不同的命名空间下, 可以存在相同名称的配置分组(Group)或配置项(Data Id)

 默认值：public
 
 2、Group(配置分组)
 
 配置分组就是上图中的Group. 配置分组是对配置集进行分组. 通过一个有意义的字符串(如: buy, trade)来表示. 不同的配置分组下可以有相同的配置集(Data ID). 当您在nacos上创建一个配置的时候, 如果未填写配置分组的名称, 则采用默认名称DEFAULT_GROUP.
 
默认值:DEFAULT_GROUP


3、DataId(配置集)
 
 在系统中, 通常一个配置文件, 就是一个配置集. 一个配置集可以包含系统的各种配置信息. 例如:一个配置集可能包含系统的数据源、连接池， 日志等级的配置信息。每个配置集都可以定义一个有意义的名称, 就是配置集的Id, 即Data Id
 
4、配置项
 
 配置集中包含的一个个配置内容, 就是配置项. 他代表具体的可配置的参数. 通常以key=value的形式存在.
 
 
 2、通俗理解
 
 这里通俗去理解这几个概念含义
 
 Namespace: 代表不同的环境, 如: 开发、测试， 生产等
 
 Group: 可以代表某个项目, 如XX医疗项目, XX电商项目
 
 DataId: 每个项目下往往有若干个工程, 每个配置集(DataId)是一个工程的主配置文件
 
（图4）

3、页面理解

（图5）

1）代表 Namespace(命名空间)，默认就创建好public，这里创建好了一个dev

2）代表 Group(配置分组)，这里默认分组 DEFAULT_GROUP

3）代表 DataId(配置集)，这里有个配置mall-goods.yaml，配置项有配置项user.name: "我是张三的好朋友李四"

<br>

四、补充
 
1、为什么用bootstrap.yaml而不用application.xml

官方有说明

```
必须使用 bootstrap.properties 配置文件来配置Nacos Server 地址
```

虽然bootstrap.yaml和application.xml都属于配置文件，功能也一样。但技术上，bootstrap.yml由父Spring ApplicationContext加载。父ApplicationContext被加载到使用application.yml的之前

当使用 Spring Cloud 的时候，配置信息一般是从 config server 加载的，为了取得配置信息（比如密码等），你需要一些提早的或引导配置。因此，把 config server 信息放在 bootstrap.yml，用来加载真正需要的配置信息。

`说明` bootstrap.properties 和 bootstrap.yaml到没有什么区别，只是格式上有点不一样。


2、DataId(配置集)和mall-goods微服务对于关系

我们在nacos配置的配置集叫:mall-goods.yaml，它是如何和我们项目匹配上的呢？

我们再来看下我们的bootstrap.yml的配置

（图6）

我们前面说了，通过namespace, group, dataId能够定位到一个配置集。从这个配置中我们没有去指明具体namespace，那就代表采用默认的 public。没有制定group，代表采用默认DEFAULT_GROUP。


那么配置集就为

```
${spring.application.name}.${file-extension:properties} #这里就相当于 mall-goods.yaml
${spring.application.name}-${profile}.${file-extension:properties} # 这里就相当于 mall-goods-dev.yaml 
```

如果同时配置的话，mall-goods-dev.yaml会覆盖mall-goods.yaml中的配置


3、补充

其实我这里还有很多细节没讲，比如怎么指定分组，指定命名空间和一些其它规则，具体可以看官网说明，讲的还挺清除的。

官方讲解：[Spring Cloud Alibaba Nacos Config](https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config)

还有一些nacos集群搭建、naocos将数据存储到mysql数据库的知识，这里也不说了。自己可以网上查查。















 
 
 
 
 
 
 














`总结` 这篇博客也是比较简单了来学习了Nacos作为服务注册中心，下一篇博客开始写Nacos作为配置中心







 



























