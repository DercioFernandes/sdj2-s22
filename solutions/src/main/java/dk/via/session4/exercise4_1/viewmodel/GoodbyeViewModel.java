package dk.via.session4.exercise4_1.viewmodel;

import dk.via.session4.exercise4_1.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GoodbyeViewModel {
    private final UserModel model;
    private final StringProperty userCount;

    public GoodbyeViewModel(UserModel model) {
        this.model = model;
        this.userCount = new SimpleStringProperty();
    }

    public void reset() {
        userCount.set(String.format("Created %d users", model.getUserCount()));
    }

    public void bindUserCount(StringProperty property) {
        property.bind(userCount);
    }
}
