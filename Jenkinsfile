pipeline {
    agent any

    tools {
        maven 'M3'
    }

    environment {
        MAVEN_SETTINGS = '/var/jenkins_home/.m2/settings.xml'
    }

    stages {
        stage('Aviso de Pull Request') {
            when { expression { env.CHANGE_ID != null } }
            steps {
                script {
                    def target = env.CHANGE_TARGET ?: ''
                    def source = env.CHANGE_BRANCH ?: ''
                    def autor = env.CHANGE_AUTHOR ?: 'desconocido'

                    if (target == 'develop' || target == 'release' || target.startsWith('project_release')) {
                        echo "🚀 Pull Request hacia ${target} desde ${source} por ${autor}"
                    } else {
                        echo "ℹ️ PR detectado, pero no hacia develop/release/project_release → sin aviso."
                    }
                }
            }
        }

        stage('Compilación y Deploy Maven') {
            when {
                anyOf {
                    expression { env.CHANGE_ID != null }
                    branch 'develop'
                    branch 'release'
                    expression { env.BRANCH_NAME?.startsWith('project_release') }
                }
            }
            steps {
                script {
                    echo "🏗️ Compilando rama ${env.BRANCH_NAME ?: env.CHANGE_TARGET}..."
                    dir('csp-sap-interfaces') {
                        def target = env.BRANCH_NAME ?: env.CHANGE_TARGET ?: ''
                        def profile = target == 'develop' ? 'develop' : target == 'release' ? 'release' : 'project_release'
                        sh """
                            echo "🧩 Ejecutando build con perfil ${profile}"
                            mvn -s $MAVEN_SETTINGS clean package install deploy -U -P${profile} -DskipTests -DretryFailedDeploymentCount=5
                        """
                    }
                }
            }
        }

        stage('Análisis SonarQube') {
            when {
                anyOf {
                    branch 'develop'
                    branch 'release'
                    expression { env.BRANCH_NAME?.startsWith('project_release') }
                }
            }
            steps {
                script {
                    echo "🔍 Análisis SonarQube en rama ${env.BRANCH_NAME}..."
                    dir('icbs-interface') {
                    dir('csp-sap-interfaces') {
                        withSonarQubeEnv('SonarQube') {
                            sh """
                                echo "🚦 Ejecutando análisis con SonarScanner..."
                                ${tool 'SonarScanner'}/bin/sonar-scanner \
                                    -Dsonar.projectKey=csp-sap-interfaces \
                                    -Dsonar.projectName="CSP SAP Interface" \
                                    -Dsonar.projectName="CSP SAP INTERFACES" \
                                    -Dsonar.sources=src \
                                    -Dsonar.java.binaries=target/classes \
                                    -Dsonar.host.url=http://sonarqube:9000 \
                                    -Dsonar.login=${env.SONAR_AUTH_TOKEN}
                            """
                        }
                    }
                }
            }
        }
    }

    post {
        success { echo "✅ Pipeline finalizado correctamente para ${env.BRANCH_NAME ?: env.CHANGE_ID}" }
        failure { echo "❌ Error durante la ejecución del pipeline." }
    }
}
