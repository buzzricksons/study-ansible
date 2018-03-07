# 概要
## 課題のために実装したウェブアプリケーション
利用したフレームワークおよび言語

- Java 8
- Spring Boot
- MyBatis
- Maven
- Flyway(DBマイグレーション)

## DB
- H2(in memory)

## 環境構築およびリリース
- Ansible

## 構成
> https://hyungcheol_kim@bitbucket.org/hyungcheol_kim/exam.git

```
/home/ec2-user/exam/etc/exam
│
├── install-and-deploy ->ミドルウェアのインストールとアプリケーションのデプロイなどを行うAnsible
│   ├── roles
│   │   ├── apache2
│   │   ├── deploy
│   │   ├── oracle-jdk8
│   │   ├── postgresql
│   │   └── tomcat8
│   └── vars
├── src ->ウェブアプリケーションのメインソース(Java)
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── exam1
│   │   │           ├── exam2
│   │   │           ├── exam3
│   │   │           └── exam4
│   │   └── resources
│   │       └── db
│   │           └── migration ->DBを作成するsql文を配置
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── exam1 ->課題1のテストケース
└── target ->buildの成果物が作成される場所
```

# 作業ログ
## 環境構築
### インストール
- Ansible
- Apache
- Tomcat
- Maven
- JDK

### バージョン変更
- JDK7 -> JDK8

## 課題
gitのpush履歴に基づいています。

# その他
## リリース方法
1.開発したソースをgitにpushする。

2.ec2環境にて下記のディレクターに移動する
```Shell
cd ~/exam/etc/exam/install-and-deploy/
```

3.下記のコマンドを実行する
> ※PASSWORDを聞かれますがenterを押下してください。

```Shell
./auto-update.sh
```
4.下記の作業がAnsibleにより実行される
```
1. git pull
2. Mavenによるbuild
3. Tomcatの停止
4. 2番で生成された成果物をTomcatにデプロイする。
5. Tomcatの起動
```

## 実行例
```
[ec2-user@ip-172-31-12-73 install-and-deploy]$ ./auto-update.sh 
SUDO password: 

PLAY [foo] *********************************************************************

TASK [setup] *******************************************************************
ok: [54.250.154.166]

TASK [deploy/git-pull : git pull] **********************************************
changed: [54.250.154.166]

TASK [deploy/build-by-maven : Build by maven] **********************************
changed: [54.250.154.166]

TASK [deploy/tomcat-stop : Standby Stop tomcat] ********************************
changed: [54.250.154.166]

TASK [deploy/tomcat-stop : debug] **********************************************
ok: [54.250.154.166] => {
    "msg": []
}

TASK [deploy/tomcat-stop : debug] **********************************************
ok: [54.250.154.166] => {
    "standby_check": {
        "changed": true, 
        "cmd": [
            "./shutdown.sh"
        ], 
        "delta": "0:00:00.315423", 
        "end": "2017-12-05 11:43:18.948508", 
        "rc": 0, 
        "start": "2017-12-05 11:43:18.633085", 
        "stderr": "", 
        "stdout": "", 
        "stdout_lines": [], 
        "warnings": []
    }
}

TASK [deploy/tomcat-stop : Wait for tomcat Stop] *******************************
ok: [54.250.154.166]

TASK [deploy/tomcat-stop : Pause task 5 seconds] *******************************
Pausing for 5 seconds
(ctrl+C then 'C' = continue early, ctrl+C then 'A' = abort)
ok: [54.250.154.166]

TASK [deploy/deploy-war-to-tomcat : Delete current tomcat webapps directory] ***
changed: [54.250.154.166]
 [WARNING]: Consider using file module with state=absent rather than running rm


TASK [deploy/deploy-war-to-tomcat : Delete current tomcat work directory] ******
changed: [54.250.154.166]

TASK [deploy/deploy-war-to-tomcat : Copy new War file to tomcat webapps directory] ***
changed: [54.250.154.166]

TASK [deploy/tomcat-start : Standby tomcat Start] ******************************
changed: [54.250.154.166]

TASK [deploy/tomcat-start : debug] *********************************************
ok: [54.250.154.166] => {
    "msg": [
        "Tomcat started."
    ]
}

TASK [deploy/tomcat-start : Wait for tomcat to start] **************************
ok: [54.250.154.166]

TASK [deploy/common-tomcat-check : Tomcat Check] *******************************
changed: [54.250.154.166]

TASK [deploy/common-tomcat-check : debug] **************************************
ok: [54.250.154.166] => {
    "msg": [
        "ec2-user  1251     1 87 11:43 pts/1    00:00:15 /home/ec2-user/exam/jdk1.8.0_151/bin/java -Djava.util.logging.config.file=/home/ec2-user/exam/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.security.egd=file:/dev/./urandom -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/ec2-user/exam/tomcat/logs -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+PrintGCDetails -XX:+PrintGCDateStamps -verbose:gc -Xloggc:/home/ec2-user/exam/tomcat/logs/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=7 -XX:GCLogFileSize=10M -Djava.net.preferIPv4Stack=true -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -Djava.endorsed.dirs=/home/ec2-user/exam/tomcat/endorsed -classpath /home/ec2-user/exam/tomcat/bin/bootstrap.jar:/home/ec2-user/exam/tomcat/bin/tomcat-juli.jar -Dcatalina.base=/home/ec2-user/exam/tomcat -Dcatalina.home=/home/ec2-user/exam/tomcat -Djava.io.tmpdir=/home/ec2-user/exam/tomcat/temp org.apache.catalina.startup.Bootstrap start", 
        "ec2-user  1422  1420  0 11:43 pts/1    00:00:00 /bin/sh -c ps -ef | grep tomcat", 
        "ec2-user  1424  1422  0 11:43 pts/1    00:00:00 grep tomcat"
    ]
}

PLAY RECAP *********************************************************************
54.250.154.166             : ok=16   changed=8    unreachable=0    failed=0   

[ec2-user@ip-172-31-12-73 install-and-deploy]$ 
```

---
Created by HyungCheol Kim

[Visit my WiKi site!](https://sites.google.com/site/hcgoon/)