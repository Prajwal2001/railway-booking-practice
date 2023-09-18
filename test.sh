docker compose run mygradle;
echo -e "\u001B[32mBuild Complete\u001B[0m"
sleep 3;
docker compose --profile backend up
