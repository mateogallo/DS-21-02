package e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private List<TopicOfInterest> interestsList;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<TopicOfInterest> getInterests() {return interestsList;}

    public void addInterests(TopicOfInterest topic){
        if (this.interestsList.contains(topic)){
            return;
        }
        this.interestsList.add(topic);
    }
    public void removeInterests(TopicOfInterest topic){this.interestsList.remove(topic);}

    public User(String name, List<TopicOfInterest> topicsOfInterest) {
        this.name = name;
        interestsList = new ArrayList<>();
        interestsList.addAll(topicsOfInterest);
    }
}
