package dk.via.session3.exercise3_5;

public class Medic {
    public Medic(SoccerMatch match) {
        match.addPropertyChangeListener("DreamTeamRoughTackles", evt -> System.out.println("Patching up an Old Boys player"));
        match.addPropertyChangeListener("OldBoysRoughTackles", evt -> System.out.println("Patching up an Dream Team player"));
    }
}
