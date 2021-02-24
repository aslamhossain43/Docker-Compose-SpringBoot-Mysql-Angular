# Docker-Compose-SpringBoot-Mysql-Angular
1. Must initialize servlet (simply create app using spring initializer with mvn and war)
2. build to create war 'mvn clean install -DskipTests'
3. remove orphan 'docker-compose down --remove-orphans'
4. run 'docker-compose up --build -d'
5. if one container but multiple services arise then use localhost https://stackoverflow.com/questions/35565770/difference-between-service-and-container-in-docker-compose
6. 

