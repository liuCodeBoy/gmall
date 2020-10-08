package com.lxq.gmall.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    //创建连接池
    private JedisPool jedisPool;

    //初始化连接池
    public void initJedisPool(String host,int port,int database){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置连接池的最大数
        jedisPoolConfig.setMaxTotal(200);
        //设置等待时间
        jedisPoolConfig.setMaxWaitMillis(10*1000);
        //设置最少剩余数
        jedisPoolConfig.setMinIdle(10);
        //开启获取连接缓冲池
        jedisPoolConfig.setBlockWhenExhausted(true);
        //当用户获取到一个连接池后，自检是否可以使用
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(jedisPoolConfig,host,port,20*1000);
    }

    //获取jedis
    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
