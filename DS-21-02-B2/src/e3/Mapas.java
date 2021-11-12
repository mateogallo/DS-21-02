package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapas implements NetworkManager{

    private Map<String,List<TopicOfInterest>> mapUsers = new HashMap<>();
    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        mapUsers.put(user,topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        mapUsers.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        mapUsers.get(user).add(topicOfInterest);

    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        mapUsers.get(user).remove(topicOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return new ArrayList<>(mapUsers.keySet());
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topicList = new ArrayList<>();
        for (String key: mapUsers.keySet()) {
            for (TopicOfInterest topic:mapUsers.get(key)){
                if (!topicList.contains(topic)){
                    topicList.add(topic);
                }
            }
        }
        return topicList;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return mapUsers.get(user);
    }
}
