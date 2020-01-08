# Redis

Repositorio base para estudos usando biblioteca Jedis juntamente com o Redis

## Docker - Redis

O Docker deve esta devidamente configurado em seu ambiente. 

Para baixa a imagem:

```
$ docker pull redis
```

Link: <a href="https://hub.docker.com/_/redis/" target="_blank">Docker - Redis</a>

Para rodar:

```
$ docker run -d -p 6379:6379 -i -t redis
```

## Redis

Para entender melhor segue a <a href="https://redis.io/topics/data-types-intro" target="_blank">documentação</a>

## Jedis

Biblioteca Java que permite a interação entre Redis e aplicações Java. Para entender melhor segue a <a href="https://javadoc.io/doc/redis.clients/jedis/latest/index.html" target="_blank">documentação</a> e <a href="https://www.baeldung.com/jedis-java-redis-client-library" target="_blank">tutorial</a>

