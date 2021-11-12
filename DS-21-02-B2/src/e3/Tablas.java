package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tablas implements NetworkManager{
 private List<User> usersList=new ArrayList<>();

 @Override
 public void addUser(String user, List<TopicOfInterest> topicsOfInterest){
  User u = new User(user, topicsOfInterest);
  usersList.add(u);
 }
 @Override
 public void removeUser(String user){
  usersList.removeIf(users -> Objects.equals(users.getName(), user));
 }
 @Override
 public void addInterest(String user, TopicOfInterest topicOfInterest){//Listas en c?
  for (User users : usersList) {
   if (Objects.equals(users.getName(), user)) {
    users.addInterests(topicOfInterest);
   }
  }
 }

 @Override
 public void removeInterest(String user, TopicOfInterest topicOfInterest){
  for (User users : usersList){
   if (Objects.equals(users.getName(), user)){
    users.removeInterests(topicOfInterest);
   }
  }
 }
 @Override
 public List<String> getUsers(){
  List<String> l = new ArrayList<>();
  for (User users : usersList){
   l.add(users.getName());
  }
  return l;
 }
 @Override
 public List<TopicOfInterest> getInterests(){
  List<TopicOfInterest> t = new ArrayList<>();
  for (User users : usersList) {
   for (TopicOfInterest topic:users.getInterests()) {
    if (!t.contains(topic)) { t.add(topic);}
   }
  }
  return t;}

 @Override
 public List<TopicOfInterest> getInterestsUser(String user){
  List<TopicOfInterest> L = new ArrayList<>();
  for (User users : usersList){
   if(Objects.equals(users.getName(), user)){
    L.addAll(users.getInterests());
   }
  }
  return L;}


}

