#!/bin/sh

MASTER_START=`date +%s`

echo "[INFO] ************************************************************************"
echo "[INFO] **                                                                    **"
echo "[INFO] **                     Xeus Video Games Database                      **"
echo "[INFO] **                                                                    **"
echo "[INFO] **                Project build and deployment script                 **"
echo "[INFO] **                                                                    **"
echo "[INFO] ************************************************************************"
echo "[INFO]"

cd ./model
sh build_and_deploy.sh
echo "[INFO]"

cd ../backend

MIG_START=`date +%s`

echo "[INFO] ========================================================================"
echo "[INFO] Migrating database schema..."
echo "[INFO] ========================================================================"
echo "[INFO]"

mvn flyway:migrate
if [ "$?" != 0 ]; then
	echo "[ERROR] Error while migrating the database schema!"
	exit 1
fi
MIG_END=`date +%s`
MIG_DURATION=$((MIG_END-MIG_START))

echo "[INFO] Database schema migrated in $MIG_DURATION seconds."
echo "[INFO]"

sh build_and_deploy.sh
echo "[INFO]"

MASTER_END=`date +%s`
MASTER_DURATION=$((MASTER_END-MASTER_START))

echo "[INFO] ************************************************************************"
echo "[INFO] Project built and dockerized in $MASTER_DURATION seconds."
