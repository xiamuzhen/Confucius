<h3>conf/settings.xml</h3>

```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">

    <localRepository></localRepository>
    
    <pluginGroups></pluginGroups>
    
    <proxies></proxies>
    
    <servers></servers>
    
    <mirrors>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>Alibaba Cloud Public Warehouse</name>
            <url>https://maven.aliyun.com/repository/public</url>
        </mirror>
    </mirrors>
    
    <profiles></profiles>
    
</settings>
```