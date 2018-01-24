package com.springboot.demo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.topic.dto.Topic;
import com.springboot.demo.topic.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	TopicService service;
	
	@RequestMapping(method=RequestMethod.GET, path="/topics")
	public List<Topic> getAllTopics() {
		return service.getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/topics/{topicId}") // NOT recommended to have different name than what is present in parameters of method
	public Topic getTopic(@PathVariable("topicId") String id) {
		return service.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/topics")
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/topics/{topicId}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("topicId") String id) {
		topic.setId(id);
		service.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/topics/{topicId}")
	public void deleteTopic(@PathVariable("topicId") String id) {
		service.deleteTopic(id);;
	}

}
