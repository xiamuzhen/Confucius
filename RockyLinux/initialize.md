```bash
#!/bin/bash

sed -i 's|SELINUX=enforcing|SELINUX=disabled|' /etc/selinux/config

systemctl stop firewalld
systemctl disable firewalld &> /dev/null

sed -e 's|^mirrorlist=|#mirrorlist=|g' \
    -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=https://mirrors.aliyun.com/rockylinux|g' \
    -i.bak /etc/yum.repos.d/rocky-*.repo

yum makecache &> /dev/null

yum -y install bash-completion lrzsz net-tools tar vim wget &> /dev/null

systemctl poweroff
```
