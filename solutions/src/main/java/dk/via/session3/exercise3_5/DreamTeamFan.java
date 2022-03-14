package dk.via.session3.exercise3_5;

public class DreamTeamFan {
    public DreamTeamFan(SoccerMatch match) {
        match.addPropertyChangeListener("DreamTeamScore", (e)-> System.out.println("Dream Team fan: GOOOOOOOOOOAL!"));
        match.addPropertyChangeListener("OldBoysScore", (e)-> System.out.println("Dream Team fan: Booooo"));
    }
}
