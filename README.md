linuxmetrics4j
==============

A very simple java library to gather cpu, memory, network, load average stats from procfs on Linux machines.

Actually have been implemented retrieving from:
* /proc/loadavg to get load average
* /proc/stat to get cpu usage
* /proc/meminfo to get memory usage
* /proc/net/dev to get network usage

More information of what is possibile to retrieve from procfs can be found on the proc man page: http://linux.die.net/man/5/proc


Usage
=====

```java
  LinuxMetricsClient client = new LinuxMetricsClientImpl();
  
  CpuUsage cpuUsage = client.getCpuUsage();
  Integer count = cpuUsage.getCoreCount();
  BigDecimal idle = cpuUsage.getIdle();
  BigDecimal user = cpuUsage.getUser();
  
  MemoryUsage memory = client.getMemoryInfo();
  memory.getMemTotal();
  
  LoadAverage loadAverage = client.getLoadAverage();
  double five = loadAverage.getFiveMinutes();
  
  List<NetworkUsage> networks = client.getNetworkUsage();
  for (NetworkUsage network : networks)
  {
      String device = network.getDevice();
      Integer received = network.getBytesReceived();
      Integer sent = network.getBytesTransmitted();
  }

```

Maven repository
================

Add to your pom.xml:
```xml
<repositories>
	<repository>
		<id>github.linuxmetrics4j.repo</id>
		<url>https://raw.github.com/gionn/linuxmetrics4j/mvn-repo/</url>
	</repository>
</repositories>
<dependencies>
		<dependency>
		<groupId>net.gionn.linuxmetrics4j</groupId>
		<artifactId>metrics-core</artifactId>
		<version>0.0.1</version>
	</dependency>
</dependencies>
```

Contribute
==========

If you find a problem, please open an issue or submit a PR.
