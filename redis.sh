#!/bin/bash

mkdir redis-cluster && cd redis-cluster || exit
echo "Creating redis-cluster folder"

for i in {7000..7005}; do
  mkdir -p "$i"
  echo "Creating folder $i"
done

for i in {7000..7005}; do
  echo "Creating redis.conf file for folder $i"
  echo "port $i" > "$i/redis.conf"
  echo "cluster-enabled yes" >> "$i/redis.conf"
  echo "cluster-config-file nodes.conf" >> "$i/redis.conf"
  echo "cluster-node-timeout 5000" >> "$i/redis.conf"
  echo "appendonly yes" >> "$i/redis.conf"
done

for i in {7000..7005}; do
  echo "Starting Redis server in folder $i"
  redis-server "$i/redis.conf"
done

echo "Creating Redis cluster"
redis-cli --cluster create 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 --cluster-replicas 1
