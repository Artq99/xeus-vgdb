#!/bin/sh

echo "[INFO] ========================================================================"
echo "[INFO] Building dockerized database..."
echo "[INFO] ========================================================================"
echo "[INFO]"

if [ ! -f "passwords.txt" ]; then
	echo "[ERROR] File 'passwords.txt' does not exist!"
	exit 1
fi

echo "[INFO] Reading the 'passwords.txt' file..."

ROOT_PASSWD=$(grep "root" passwords.txt | sed "s/root=//g")
if [ "$ROOT_PASSWD" == "" ]; then
	echo "[ERROR] Password for the user root not provided!"
	exit 1
fi

ADMIN_PASSWD=$(grep "admin" passwords.txt | sed "s/admin=//g")
if [ "$ADMIN_PASSWD" == "" ]; then
	echo "[ERROR] Password for the user xvgdb_admin not provided!"
	exit 1
fi

SPRING_PASSWD=$(grep "spring" passwords.txt | sed "s/spring=//g")
if [ "$SPRING_PASSWD" == "" ]; then
	echo "[ERROR] Password for the user xvgdb_spring not provided!"
	exit 1
fi

FLYWAY_PASSWD=$(grep "flyway" passwords.txt | sed "s/flyway=//g")
if [ "$FLYWAY_PASSWD" == "" ]; then
	echo "[ERROR] Password for the user xvgdb_flyway not provided!"
	exit 1
fi

echo "[INFO] Passwords loaded from 'passwords.txt' file."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Stopping and removing the container..."
STATUS=$(docker stop xvgdb_model1 2>&1)
if echo "$STATUS" | grep "No such container" &> /dev/null; then
	echo "[INFO] Container does not already exist."
elif echo "$STATUS" | grep "^xvgdb_model1$" &> /dev/null; then
	echo "[INFO] Container stopped."
	docker rm xvgdb_model1 &> /dev/null
	echo "[INFO] Container removed."
else
	echo "[ERROR] $STATUS"
	exit 1
fi

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Removing the image..."
STATUS=$(docker image rm xvgdb_model:1.0 2>&1)
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
docker build --tag xvgdb_model:1.0 . &> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating the image!"
	exit 1
fi
echo "[INFO] Image created."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Creating and starting the container..."
docker run \
	--detach \
	--publish 3306:3306 \
	--name xvgdb_model1 \
	--env MYSQL_ROOT_PASSWORD=$ROOT_PASSWD \
	xvgdb_model:1.0 \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating the container!"
	exit 1
fi
echo "[INFO] Container created and started."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Waiting until the MySQL Server is up..."
docker ps | grep 'Up.*(healthy).*xvgdb_model1' &> /dev/null
STATUS=$?
while [ $STATUS != 0 ];
do
	sleep 1
	docker ps | grep 'Up.*(healthy).*xvgdb_model1' &> /dev/null
	STATUS=$?
done
echo "[INFO] MySQL Server is up and running."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Creating users..."
docker exec xvgdb_model1 mysql \
	--user=root \
	--password=$ROOT_PASSWD \
	--execute "CREATE USER 'xvgdb_admin'@'%' IDENTIFIED BY '$ADMIN_PASSWD';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating user xvgdb_admin!"
	exit 1
fi
echo "[INFO] User created: xvgdb_admin"

docker exec xvgdb_model1 mysql \
	--user=root \
	--password=Master#4 \
	--execute "CREATE USER 'xvgdb_spring'@'%' IDENTIFIED BY '$SPRING_PASSWD';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating user xvgdb_spring!"
	exit 1
fi
echo "[INFO] User created: xvgdb_spring"

docker exec xvgdb_model1 mysql \
	--user=root \
	--password=Master#4 \
	--execute "CREATE USER 'xvgdb_flyway'@'%' IDENTIFIED BY '$FLYWAY_PASSWD';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while creating user xvgdb_flyway!"
	exit 1
fi
echo "[INFO] User created: xvgdb_flyway"

echo "[INFO] All users created."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Granting privileges to users..."

docker exec xvgdb_model1 mysql \
	--user=root \
	--password=$ROOT_PASSWD \
	--execute "GRANT ALL PRIVILEGES ON xvgdb_model.* TO 'xvgdb_admin'@'%';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while granting privileges to user xvgdb_admin!"
	exit 1
fi
echo "[INFO] Privileges granted to user xvgdb_admin."

docker exec xvgdb_model1 mysql \
	--user=root \
	--password=$ROOT_PASSWD \
	--execute "GRANT ALL PRIVILEGES ON xvgdb_model.* TO 'xvgdb_spring'@'%';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while granting privileges to user xvgdb_spring!"
	exit 1
fi
echo "[INFO] Privileges granted to user xvgdb_spring."

docker exec xvgdb_model1 mysql \
	--user=root \
	--password=$ROOT_PASSWD \
	--execute "GRANT ALL PRIVILEGES ON xvgdb_model.* TO 'xvgdb_flyway'@'%';" \
	&> /dev/null
if [ "$?" != "0" ]; then
	echo "[ERROR] Error while granting privileges to user xvgdb_flyway!"
	exit 1
fi
echo "[INFO] Privileges granted to user xvgdb_flyway."

echo "[INFO] Privileges granted."

echo "[INFO] ------------------------------------------------------------------------"

echo "[INFO] Dockerized database built."
