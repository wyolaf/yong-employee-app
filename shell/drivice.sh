#!/bin/bash

# 获取当前时间
DATE=$(date +"%Y-%m-%d %H:%M:%S")

echo "$DATE"
# 检查磁盘使用率
DISK_USAGE=$(df -h | awk '{if ($NF=="/") {print $5}}' | sed 's/%//g')
echo "磁盘使用率为${DISK_USAGE}%"


CPU_USAGE=$(mpstat 1 1 | awk '/Average:/ {print 100-$NF}')
echo "CPU使用率为${CPU_USAGE}%"

MEM_TOTAL=$(free -m | awk '{if ($1=="Mem:") {print $2}}')
MEM_USED=$(free -m | awk '{if ($1=="Mem:") {print $3}}')
MEM_USAGE=$((100 * $MEM_USED / $MEM_TOTAL))
echo "内存容量${MEM_TOTAL}M"
echo "内存使用${MEM_USED}M"
echo "内存使用率${MEM_USAGE}%"