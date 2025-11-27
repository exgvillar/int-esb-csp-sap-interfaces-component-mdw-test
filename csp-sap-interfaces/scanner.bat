@echo off

set projectKey="int-esb-csp-sap-interfaces-component-mdw"
set dir_src="."
set dir_binaries="."
set sonar_url="http://10.129.40.56:9000"
set token_login="b1fea24d69864f2a9a968863e864111cb15fd40e"
set dir_libraries="${env.HOMEPATH}/.m2/repository/**/*.jar"
set branch = ""
set exclusions = "*"
set inclusions = "*.java"
sonar-scanner.bat -D"sonar.projectKey=%projectKey%" -D"sonar.sources=%dir_src%" -D"sonar.host.url=%sonar_url%" -D"sonar.login=%token_login%" -D"sonar.java.binaries=%dir_binaries%" -Dsonar.scm.provider=git -D"sonar.exclusions=%exclusions%" -D"sonar.inclusions=%inclusions%" -X