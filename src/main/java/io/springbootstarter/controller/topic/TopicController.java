package io.springbootstarter.controller.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controllers in spring-boot are just basically java classes that map api request to responses
 */
@RestController // tells Spring that these class is able to handle Api requests coming into our Application
public class TopicController {

    @Autowired // marks these field as being needed for dependency injection from spring
    private TopicService topicService;

    @RequestMapping("/topics") // what Api should respond to a request that comes to /topics
    public List<Topic> getAllTopics() {
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    // tells spring that these route requires an input param and we should map that input
    // param to our @PathVariable id variable
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "/topics")
    // maps these route to any /topics that's a POST request
    public void addTopic(@RequestBody Topic topic) {
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type courses
        topicService.addTopic(topic);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/topics/{id}")
    // maps these route to any /topics/id and then updates
    // that particular courses
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type courses
        topicService.updateTopic(topic);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = "/topics/{id}")
    // maps these route to any /topics that's a Delete
    // request and then deletes that courses based on its id
    public void deletTopic(@PathVariable String id) {
        // @RequestBody tells spring that we are expecting a requestBody from these Post request
        // of type courses
        topicService.deleteTopic(id);

    }


}
