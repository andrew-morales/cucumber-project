#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" \
    -DHUB_HOST=$HUB_HOST \
    -Dbrowser=$browser \
    -Denv=$env \
    -Dhudson.model.DirectoryBrowserSupport.CSP= \
    -Dcucumber.options="$CUCUMBER_OPTIONS" \
    org.junit.runner.JUnitCore test.java.runner.TestRunner