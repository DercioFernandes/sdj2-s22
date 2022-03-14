package dk.via.session3.exercise3_5;

public class Referee {
    public Referee(SoccerMatch match) {
        match.addPropertyChangeListener("OldBoysRoughTackles", evt -> System.out.println("Old Boys yellow card"));
        match.addPropertyChangeListener("DreamTeamRoughTackles", evt -> System.out.println("Dream Team yellow card"));
    }
}
