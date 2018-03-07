

Middleware Install and Deploy
===============
playbookグループ

* foo
  - Oracle JDK 8と ApacheとTomcatをインストールする。
* postgresql
  - postgresql をインストールする。
* deploy
  - デプロイを行う
   
# Requirements
* 実行サーバ: ansibleが動作する環境
* 対象サーバのユーザがsudo登録されていること。

# JDK 8, Apache, Tomcatインストールplaybookの実行

### playbook tags
* oracle-jdk8
* apache
* tomcat

### playbookの設定
```
hosts
vars/foo
```

上記のファイルらを適切に設定する。

### ansible-playbook 実行
```shell
$ cd cloneしたフォルダー
$ ./build-foo.sh
```

パスワードを問われたら対象サーバのユーザのパスワードを入力する。

### 自己証明書作成(おれおれ)

```shell
$ openssl genrsa -des3 -out server.key -passout pass:password 2048

$ openssl req -new -key server.key > server.csr

$ openssl x509 -in server.csr -days 365 -req -signkey server.key -out server.crt -passin pass:password
```

自己証明書を作成し、各apache/confに格納する。

### fooインストール

該当warを該当tomcat/webappsに格納し、インストール操作を行う。

# postgresqlのインストール

```
hosts
vars/postgresql
```

ファイルらを適切に設定する。

### ansible-playbook 実行
```shell
$ cd cloneしたフォルダー
$ ./build-postgresql.sh
```

パスワードを問われたら対象サーバのユーザのパスワードを入力する。

### postgres createuserの生成

対象サーバでpostgres用userを生成する。

```bash
$ createuser -S -R -D -i -l -P {{ db_username }}
```

# 番外

## opensshのインストール

```bash
# yum install -y openssh
# yum install -y openssh-clients
```

## opensslのインストール

```bash
# yum install -y openssl
```

## sshdのインストールと起動

```bash
# yum -y install openssh-server
# systemctl start sshd.service
```

## sudoのインストール

```bash
# yum -y install sudo
```

`visudo`にて下記を追加。

```bash
# visudo
```

下記のようにuserアカウントを追加する。

```bash
foo    ALL=(ALL)    ALL
```

## エラー対応
エラー[Jinja was looking for the following tags]がでたときの対処
http://qiita.com/takahirono7/items/0a198da4645bab6517f5

## 「-bash: ./build-foo.sh: /bin/bash^M: 誤ったインタプリタです: そのようなファイルやディレクトリはありません」のエラー対応
sed -i -e 's/\r$//' script.sh
