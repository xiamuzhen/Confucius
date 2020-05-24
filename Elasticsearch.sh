cat > /etc/security/limits.conf << EOF
* soft  nofile  65536
* hard  nofile  65536
* soft  nproc 4096
* hard  nproc 4096
EOF

cat > /etc/sysctl.conf << EOF
vm.max_map_count=262144
EOF
sysctl -p
