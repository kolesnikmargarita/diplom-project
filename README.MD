## Развернуть используя Docker:

```shell
docker run -d -p 127.0.0.1:8080:8080 diplom-project:0.0.1
```
```shell
docker compose up backend -d
```

## Развернуть используя Docker Compose:

```shell
docker compose up -d
```

## Остановить работу проекта:

```shell
docker compose down
```

## Собрать образ:

```shell
docker build -t diplom-project .
```