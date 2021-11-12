package e3;

import java.util.Objects;

public class TopicOfInterest implements Comparable<TopicOfInterest>{
    private String topic;

    public TopicOfInterest(String topic) {
        this.topic = topic;
    }

    public String getTopic() {return topic;}
    public void setTopic(String topic) {this.topic = topic;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicOfInterest topic1 = (TopicOfInterest) o;
        return Objects.equals(topic, topic1.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }

    @Override
    public String toString() {
        return this.topic;
    }

    @Override
    public int compareTo(TopicOfInterest o) {
        return String.CASE_INSENSITIVE_ORDER.compare(topic,o.topic);
    }
}
