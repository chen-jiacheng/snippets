# snippets-redis

## RedisAutoConfiguration => Redis 自动配置类
1. 主要注入: RedisTemplate,StringRedisTemplate
2. 依赖于: RedisProperties
3. 注入: RedisConnectionConfiguration: LettuceConnectionConfiguration,JedisConnectionConfiguration
4. 依赖于: RedisConnectionFactory: LettuceConnectionFactory,JedisConnectionFactory

总体来说:
1. RedisProperties => 设置基本属性
2. JedisConnectionConfiguration => 设置JedisConnectionFactory
3. JedisConnectionFactory => 构造Factory
4. RedisTemplate

## TODO: common连接池
org.apache.commons.pool2.ObjectPool

##### 参考链接
1. redis文档: https://redis.io/docs/install/install-redis/install-redis-on-mac-os/
2. redis博客: https://blog.csdn.net/weixin_45630446/article/details/116764866
