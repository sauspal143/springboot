package com.springboot.demo.topic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Service;

import com.springboot.demo.topic.dto.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("spring","Spring cource","Spring course description"),
					new Topic("java","Java cource","Java course description"),
					new Topic("javascript","Javascript cource","Javascript course description")));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics = Stream.concat(topics.stream(), Stream.of(topic)).collect(toList());
	}
	
	public void updateTopic(Topic topic) {
		String topicId = topic.getId();
		//int index = topics.get(index);
		//new ArrayList<Topic>(topics).stream().forEach(topic -> topics.add(getTopic(id), topic));
		for (int i = 0; i < topics.size(); i++) {
			if (topicId.equals(topics.get(i).getId())) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		Topic topic = getTopic(id);
		// new ArrayList<Topic>(topics).stream().filter(t -> topics.remove(topic));
		// https://stackoverflow.com/questions/30778017/modifying-objects-within-stream-in-java8-while-iterating
		topics.remove(topic);
	}
}
