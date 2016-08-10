package com.cc.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("127.0.0.1");
	      jedis.auth("123456");
	      System.out.println("Connection to server sucessfully");
	      //查看服务是否运行
	      System.out.println("Server is running: "+jedis.ping());
	      
	      //字符串测试
	      jedis.set("cc", "testing");
	      System.out.println("Stored string in redis: "+ jedis.get("cc"));
	      
	      //存储进数据列表
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	      List<String> list = jedis.lrange("tutorial-list", 0 ,5);
	      for (int i = 0; i < list.size(); i++) {
	    	  System.out.println("Stored string in redis:: "+list.get(i));
	      }
	      //Redis Java Keys 实例
	      Set<String> list2 = jedis.keys("*");
	      Iterator<String> it = list2.iterator();  
	      while (it.hasNext()) {  
	        String str = it.next();  
	        System.out.println("List of stored keys:: "+str);
	      }
	      
	      jedis.save();
	 }
}
