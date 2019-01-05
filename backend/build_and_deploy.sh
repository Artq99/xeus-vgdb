#!/bin/sh

echo "[INFO] ========================================================================"
echo "[INFO] Building dockerized backend..."
echo "[INFO] ========================================================================"
echo "[INFO]"

echo "[INFO] Building the jar..."
mvn clean package
if [ "$?" != 0 ]; then
	echo "[ERROR] Error while building the jar!"
	exit 1
fi
echo "[INFO] Jar built successfuly."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Stopping and removing the container..."
STATUS=$(docker stop xvgdb_backend1 2>&1)
if echo "$STATUS" | grep "No such container" &> /dev/null; then
	echo "[INFO] Container does not already exist."
elif echo "$STATUS" | grep "^xvgdb_backend1$" &> /dev/null; then
	echo "[INFO] Container stopped."
	docker rm xvgdb_backend1 &> /dev/null
	echo "[INFO] Container removed."
else
	echo "[ERROR] $STATUS"
	exit 1
fi

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Removing the image..."
STATUS=$(docker image rm xvgdb_backend:1.0 2>&1)
if echo "$STATUS" | grep "No such image" &> /dev/null; then
	echo "[INFO] Image does not already exist."
elif echo "$STATUS" | grep "Untagged" &> /dev/null; then
	echo "[INFO] Image removed."
else
	echo "[ERROR] $STATUS"
	exit 1
fi

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Creating the image..."
docker build --tag xvgdb_backend:1.0 . &> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating the image!"
	exit 1
fi
echo "[INFO] Image created."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Creating and starting the container..."
docker run \
	--detach \
	--publish 8080:8080 \
	--name xvgdb_backend1 \
	xvgdb_backend:1.0 \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating the container!"
	exit 1
fi
echo "[INFO] Container created and started."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Waiting until the Tomcat Server is up..."

while : ;
do
	sleep 1
	
	docker logs xvgdb_backend1 | grep "Error starting Application" &> /dev/null
	if [ "$?" == "0" ]; then
		echo "[ERROR] Error while starting the application!"
		exit 1
	fi
	
	docker logs xvgdb_backend1 | grep "Started Application" &> /dev/null
	if [ "$?" == "0" ]; then
		break
	fi
done
echo "[INFO] Tomcat Server is up and running."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Dockerized backend built."
