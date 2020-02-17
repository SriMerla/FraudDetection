package com.example.demotopics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private  TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>((Arrays.asList(
            new Topic("spring", "spring framework", "spring framework description"),
            new Topic("java", "core java", "core java description"),
            new Topic("javascript", "javascript", "javascript description")
    )));

    public List<Topic> getAllTopics() {
        List<Topic> topic = new ArrayList<>();
        topicRepository.findAll();
        topics.forEach(topic::add);
        return topic;
    }


    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
      topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i = 0; i< topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id));
    }
}
