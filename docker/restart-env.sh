#!/bin/sh
cd ../
./gradlew jib
# shellcheck disable=SC2116
BUILD_RESULT=$(echo $?)
if [ "$BUILD_RESULT" -eq 0 ]; then
  cd docker || { echo "not found directory"; exit 1;}
  docker-compose stop
  docker rm "$(docker ps -aq)"
  docker-compose pull
  docker-compose up -d
else
  cd docker || { echo "not found directory"; exit 1;}
  echo "Build Failed"
fi

