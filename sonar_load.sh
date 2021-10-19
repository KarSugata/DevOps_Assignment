# SonarQube dir path (including OS)
cd ../sonarqube-9.1.0.47736/bin/macosx-universal-64

# Server start
./sonar.sh console

# Scan maven project
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=DevopsDemo \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=859be3e146906bee231e139f86f9ee51453dcad5