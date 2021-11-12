package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {
    @Test
    void test() {
        NetworkManager o;
        for (int i = 0; i < 2; i++) {
            if (i==0){
                o = new Mapas();
            }else {
                o = new Tablas();
            }

            Network equipo = new Network(o);
            TopicOfInterest baloncesto=new TopicOfInterest("Baloncesto");
            equipo.addUser("Lamelo",baloncesto , new TopicOfInterest("Rugby"), new TopicOfInterest("Golf"));
            equipo.addUser("Carmelo", baloncesto, new TopicOfInterest("Waterpolo"));
            equipo.addUser("LeBron", baloncesto, new TopicOfInterest("Cine"), new TopicOfInterest("Golf"));
            equipo.addUser("Christopher", new TopicOfInterest("Cine"));
            equipo.addUser("Ben");
            if (i == 0) {
                assertEquals("""
                    Users:
                    Christopher[Cine]
                    LeBron[Baloncesto, Cine, Golf]
                    Lamelo[Baloncesto, Rugby, Golf]
                    Ben[]
                    Carmelo[Baloncesto, Waterpolo]
                    """, equipo.infoNetwork());
            }else{
                assertEquals("""
                    Users:
                    Lamelo[Baloncesto, Rugby, Golf]
                    Carmelo[Baloncesto, Waterpolo]
                    LeBron[Baloncesto, Cine, Golf]
                    Christopher[Cine]
                    Ben[]
                    """, equipo.infoNetwork());
            }

            assertEquals("[Baloncesto, Waterpolo]", equipo.userTopics("Carmelo").toString());

            assertEquals("[Baloncesto, Cine, Golf, Rugby, Waterpolo]", equipo.allTopics().toString());

            assertEquals("[Baloncesto]", equipo.sameTopics("Lamelo", "Carmelo").toString());
            assertEquals("[Baloncesto, Golf]", equipo.sameTopics("Lamelo", "LeBron").toString());
            assertEquals("[]", equipo.sameTopics("Christopher", "Ben").toString());

            assertEquals("[Carmelo, Lamelo, LeBron]",(equipo.interestUsers(baloncesto)).toString());

            equipo.removeUser("Christopher");
            equipo.removeUser("LeBron");

            assertEquals("[Carmelo, Lamelo]",(equipo.interestUsers(baloncesto)).toString());

            equipo.addUserTopic("Lamelo", new TopicOfInterest("Cine"));

            equipo.removeUserTopic("Lamelo", new TopicOfInterest("Baloncesto"));
            assertEquals("[]", equipo.sameTopics("Lamelo", "Carmelo").toString());

            assertThrows(IllegalArgumentException.class, ()->equipo.addUser("Carmelo", new TopicOfInterest("Baloncesto")));
            assertThrows(IllegalArgumentException.class, ()->equipo.addUser("", new TopicOfInterest("Baloncesto")));
            assertThrows(IllegalArgumentException.class, ()->equipo.removeUser("LeBron"));

            assertThrows(IllegalArgumentException.class, ()->equipo.addUserTopic("Carmelo", new TopicOfInterest("Baloncesto")));
            assertThrows(IllegalArgumentException.class, ()->equipo.removeUserTopic("Lamelo", new TopicOfInterest("Baloncesto")));

            assertThrows(IllegalArgumentException.class, ()->equipo.sameTopics("Paco", "Juan"));
            assertThrows(IllegalArgumentException.class, () -> equipo.sameTopics("Lamelo", "Christopher"));
        }
    }
}