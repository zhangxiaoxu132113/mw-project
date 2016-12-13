package com.water.tools;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Created by zhangmiaojie on 2016/12/13.
 */
public class RedisUtil {

    @Resource
    private ShardedJedisPool shardedJedisPool; //从节点读取数据

    @Resource
    private JedisPool jedisPool; //主节点写入数据

    public String getKey(String key) {
        ShardedJedis sjedis = shardedJedisPool.getResource();
        String value = sjedis.get(key);
        shardedJedisPool.returnResource(sjedis);
        return value;
    }

    public Object getObject(String key) {
        ShardedJedis sjedis = shardedJedisPool.getResource();
        byte[] value = sjedis.get(key.getBytes());
        Object obj = null;
        try {
            obj = value == null ? null : SerializeUtil.unserialize(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}
