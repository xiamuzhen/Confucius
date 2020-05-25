#!/bin/bash

setenforce 0
sed -i 's/SELINUX=enforcing/SELINUX=disabled/' /etc/selinux/config

systemctl stop firewalld
systemctl disable firewalld &> /dev/null

mkdir /etc/yum.repos.d/backup/
mv /etc/yum.repos.d/*.repo /etc/yum.repos.d/backup/

mkdir /media/cdrom/
mount /dev/sr0 /media/cdrom/ &> /dev/null
echo '/dev/sr0 /media/cdrom/ iso9660 defaults 0 0' >> /etc/fstab

cat > /etc/yum.repos.d/CentOS-Media.repo << EOF
[c7-media]
name=CentOS-\$releasever - Media
baseurl=file:///media/cdrom/
gpgcheck=0
enabled=1
EOF

systemctl poweroff
