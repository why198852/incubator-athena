---
title: Documentation
---

Welcome to the Athena documentation. If you encounter any problems when using Athena, have a look at the troubleshooting guide, raise an issue on [GitHub](https://github.com/InkeIO/incubator-athena/issues) or start a topic on the Google Group.

## What is Athena?

Athena (incubating) is a high performance user behavior analysis system.

## Installation

It only takes a few minutes to set up Athena. If you encounter a problem and can't find the solution here, please [submit a GitHub issue](https://github.com/InkeIO/incubator-athena/issues) and we'll help.

### Requirements

Installing Athena is quite easy and only requires the following beforehand:

- [Apache Druid](https://druid.apache.org/) (Should be at least Druid 0.9.x, recommends 0.10 or higher)

If your computer already has these, congratulations! You can skip to the [Athena installation](#Install-Athena) step.

If not, please follow the following instructions to install all the requirements.

### Install Druid

Druid provides [official installer](https://druid.apache.org/downloads.html) for most platforms.

Alternative installation methods:

- Mac: Install it with [Homebrew](https://brew.sh/) or [MacPorts](http://www.macports.org/) - Experimental.
- Linux (DEB/RPM-based): Install it with Binary installation.
- Others: Install it through respective package manager. Refer to [the guide](https://druid.apache.org/docs/latest/tutorials/index.html) provided by Druid.

Binary is also recommended for Mac and Linux to avoid possible file not found issue.

### Install Athena

Once all the requirements are installed, you can install Athena with java:

``` bash
$ java -jar athena-server-<VERSION>.jar
```

or use the startup script we provide

``` bash
$ ./bin/athena.sh start
```
