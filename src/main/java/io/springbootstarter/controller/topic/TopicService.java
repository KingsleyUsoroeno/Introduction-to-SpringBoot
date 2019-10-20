package io.springbootstarter.controller.topic;

import io.springbootstarter.controller.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * in spring the concept of business service are usually Singletons when the application starts up
 * Spring creates an instance of these service and keeps it in memory which allows us to inject these
 * service into our classes for each use without creating an instance of it
 */
@Service
public class TopicService {

    @Autowired // injects the courses repository into our Service Class
    private TopicRepository topicRepository;

    public List<Topic> getTopics() {
        List<Topic> allTopics = new ArrayList<>();
        topicRepository.findAll().forEach(allTopics::add);
        return allTopics;
    }

    public Topic getTopic(String id) {
        if (topicRepository.findById(id).isPresent()) {
            return topicRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }

}
