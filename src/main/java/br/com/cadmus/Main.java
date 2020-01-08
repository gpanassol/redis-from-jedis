package br.com.cadmus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Main {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis();
		
		//Strings
		jedis.set("events/city/rome", "32,15,223,828");
		String cachedResponse = jedis.get("events/city/rome");
		System.out.println(cachedResponse);
		
		//Listas
		jedis.lpush("queue#tasks", "firstTask");
		jedis.lpush("queue#tasks", "secondTask");
		
		List<String> queueTasks = jedis.lrange("queue#tasks", 0, -1);
		System.out.println(queueTasks);
		
		//Conjuntos
		jedis.sadd("nicknames", "nickname#1");
		jedis.sadd("nicknames", "nickname#2");
		jedis.sadd("nicknames", "nickname#1");
		
		Set<String> nickenames = jedis.smembers("nicknames");
		boolean exists = jedis.sismember("nicknames", "nickname#1");
		System.out.println(exists);
		
		//Hashes
		jedis.hset("user#1", "name", "Peter");
		jedis.hset("user#1", "job", "politician");
		
		String name = jedis.hget("user#1", "name");
		Map<String, String> fields = jedis.hgetAll("user#1");
		System.out.println(fields);
		
		//Sets classificados
		Map<String, Double> scores = new HashMap();
		scores.put("PlayerOne", 3000.0);
		scores.put("PlayerTwo", 1500.0);
		scores.put("PlayerThree", 8200.0);
		
		scores.entrySet().forEach(playerScore -> {
		    jedis.zadd("ranking", playerScore.getValue(), playerScore.getKey());
		});
		
		String player = jedis.zrevrange("ranking", 0, 1).iterator().next();
		long rank = jedis.zrevrank("ranking", "PlayerOne");
		
		System.out.println(player);
		System.out.println(rank);
	}
}
