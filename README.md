# CommandOwner

```text
依頼者: あか-AK 様
使用言語: Kotlin
形態: Bukkit (Paper) 1.20.x ~
```

## 仕様
プラグインで、コンフィグファイルを作成し、その中に以下のようなYaml (config.yml) がかけるようにする。
```yaml
command:
  cmd1:
    - give <player> apple
    - command args <player>
  cmd2:
    - give <player> apple
    - command args <player>
```
のようにし、セクション名 "command" の中にあるリストの中にあるコマンドを、サーバーにいるすべてのプレイヤーに実行させるプラグインとなっています。<br>
```コマンド```: /ownercommand ここにコマンド名<br>
```例```: /ownercommand cmd1

> このコマンドはOP権限を持っている人のみ実行可能です。


## License

---

**MIT License.**

You may fork and use my project without notification, provided you adhere to the following conditions.

- Add a link to [this repository](https://github.com/hideko-dev/CommandOwner)

> Check out [LICENSE](./LICENSE) for more detail.