#!/bin/bash

# Wait until database starts
until exec 6<>/dev/tcp/${DATABASE_HOST:-postgres}/${DATABASE_PORT:-5432}; do
  echo "Database is unavailable - sleeping"
  sleep 5
done
echo "Database is up - starting service"

# Wait until configserver starts
until exec 6<>/dev/tcp/${CONFIG_SERVER_HOST:-configserver}/${CONFIG_SERVER_PORT:-5000}; do
  echo "Configserver is unavailable - sleeping"
  sleep 5
done
echo "Configserver is up - starting service"

# Run applicataion
java -jar homework17.jar --spring.profiles.active=${SPRING_PROFILES_ACTIVE:-default}