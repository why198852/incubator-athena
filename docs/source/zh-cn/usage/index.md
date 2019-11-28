---
title: 文档
---

欢迎使用Athena文档. 如果您在使用Athena时遇到任何问题, 请查看故障排除指南, 在[GitHub](https://github.com/InkeIO/incubator-athena/issues)提出问题或在Google网上论坛中开始一个话题.

## Athena是什么?

Athena (incubating)是一个高性能的用户行为分析系统.

## 安装

安装Athena只需几分钟时间,若您在安装过程中遇到问题或无法找到解决方式,请[提交问题](https://github.com/InkeIO/incubator-athena/issues)我们会尽力解决您的问题.

### 安装必备

安装Athena非常简单只需要先安装下列应用程序即可:

- [Apache Druid](https://druid.apache.org/) (Druid版本需不低于0.9.x, 建议使用0.10及以上版本)

如果您的环境中已经安装上述必备程序, 你可以直接前往[安装Athena](#Install-Athena)步骤.

如果没有请按照以下说明安装所有程序.

### 安装Druid

Druid为大多数平台提供了[安装程序](https://druid.apache.org/downloads.html).

替代安装方法:

- Mac: 使用[Homebrew](https://brew.sh/)或[MacPorts](http://www.macports.org/)安装 - 实现性.
- Linux (DEB/RPM): 二进制安装.
- 其他: 通过相应的软件包管理器进行安装. 请参阅Druid提供的[指南](https://druid.apache.org/docs/latest/tutorials/index.html).

对于Mac和Linux,也建议使用Binary,以避免可能的文件未找到问题.

### 安装Athena

一旦安装了所有必备程序,就可以使用java安装Athena:

``` bash
$ java -jar athena-server-<VERSION>.jar
```

或使用我们提供的安装脚本

``` bash
$ ./bin/athena.sh step
```
