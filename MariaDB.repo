cat > /etc/yum.repos.d/MariaDB.repo << EOF
[mariadb]
name = MariaDB
baseurl = https://mirrors.tuna.tsinghua.edu.cn/mariadb/yum/10.1/centos7-amd64
gpgkey=https://mirrors.tuna.tsinghua.edu.cn/mariadb/yum/RPM-GPG-KEY-MariaDB
gpgcheck=1
EOF

yum -y install MariaDB-server MariaDB-client
