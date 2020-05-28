cat > /etc/yum.repos.d/percona-original-release.repo << EOF
[percona-release-x86_64]
name = Percona Original release/x86_64 YUM repository
baseurl = https://mirrors.tuna.tsinghua.edu.cn/percona/yum/release/\$releasever/RPMS/x86_64
enabled = 1
gpgcheck = 0
EOF
