#!/usr/bin/env bash

# non-native build
#DEMO_COMMAND='java -jar target/horizex-0.0.1-SNAPSHOT.jar'
# native build
DEMO_COMMAND='./target/horizex'

$DEMO_COMMAND &
export MY_PID=$!
while [ "$(curl -s -o /dev/null -L -w ''%{http_code}'' http://localhost:8080/horizex/customers)" != "200" ];
  do sleep 0.001;
done
ps -p $MY_PID -o rss,cputime
kill -9 $MY_PID
