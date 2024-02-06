# snippets-redis

RedisAutoConfiguration = Redis 自动配置类
主要注入: RedisTemplate,StringRedisTemplate
依赖于: RedisProperties
并且引入: LettuceConnectionConfiguration,JedisConnectionConfiguration

注入: RedisConnectionConfiguration: LettuceConnectionConfiguration,JedisConnectionConfiguration
依赖于: RedisConnectionFactory: LettuceConnectionFactory,JedisConnectionFactory

总体来说:
RedisProperties => 设置基本属性
JedisConnectionConfiguration => 设置JedisConnectionFactory
JedisConnectionFactory =>
RedisTemplate

org.apache.commons.pool2.ObjectPool