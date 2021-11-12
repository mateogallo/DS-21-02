package e3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Network {
    private NetworkManager red;

   public Network(NetworkManager o) {
        red=o;
    }

   public void addUser(String user,TopicOfInterest... topics) {
       if (red.getUsers().contains(user)) {
           throw new IllegalArgumentException();
       }
       if (user.equals("")) {
           throw new IllegalArgumentException();
       }
       red.addUser(user, new ArrayList<>(Arrays.asList(topics)));

   }
   public void removeUser(String user){
       if (!red.getUsers().contains(user)){
           throw  new IllegalArgumentException();
       }
        red.removeUser(user);
   }

   public void addUserTopic(String user, TopicOfInterest topic){
       if(red.getInterestsUser(user).contains(topic)){
           throw new IllegalArgumentException();
       }
        red.addInterest(user,topic);
   }
   public void removeUserTopic(String user, TopicOfInterest topic){

       if(!red.getInterestsUser(user).contains(topic)){
           throw new IllegalArgumentException();
       }
       red.removeInterest(user,topic);
    }

   public List<TopicOfInterest> userTopics(String user){//Devuelve los temas de un usuario
       Collections.sort(red.getInterestsUser(user));
       return red.getInterestsUser(user);
   }

   public List<String> interestUsers(TopicOfInterest topic) {//Delvuelve todos los usuarios con un mismo tema
        List<String> topicUsers = new ArrayList<>();

        for (String users: red.getUsers()) {
            for (TopicOfInterest topic1 : red.getInterestsUser(users)) {
                if (topic1==topic){
                    topicUsers.add(users);
                    break;
                }
            }
        }
        Collections.sort(topicUsers);
        return topicUsers;
   }

   public List<TopicOfInterest> sameTopics(String name1,String name2) {//Devuelve los temas que dos usuarios tienen en común
        List<TopicOfInterest> sameTopics = new ArrayList<>();

        if(red.getUsers().contains(name1) && red.getUsers().contains(name2)) {
            for (TopicOfInterest topic : red.getInterestsUser(name1)) {
                if (red.getInterestsUser(name2).contains(topic)) {
                    sameTopics.add(topic);
                }
            }
            Collections.sort(sameTopics);
            return sameTopics;
        }
        throw new IllegalArgumentException();
   }

    public List<TopicOfInterest> allTopics(){
       List<TopicOfInterest> allTopics=red.getInterests();
       Collections.sort(allTopics);
        return allTopics;
    }

    public String infoNetwork(){

        String s1="Users:\n";
        for (String users:red.getUsers()) {
            s1=s1.concat(users+red.getInterestsUser(users).toString()+"\n");
        }
        return s1;
    }
}
