linuxmetrics4j
==============

A very simple java library to gather cpu, memory, network, load average stats from procfs on Linux machines.


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

Contribute
==========

If you find a problem, please open an issue or submit a PR.
