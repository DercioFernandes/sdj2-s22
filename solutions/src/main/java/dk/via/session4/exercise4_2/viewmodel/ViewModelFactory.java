package dk.via.session4.exercise4_2.viewmodel;

import dk.via.session4.exercise4_2.model.Model;

public class ViewModelFactory {
    private final ConvertViewModel convertViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new ConvertViewModel(model);
    }

    public ConvertViewModel getConvertViewModel() {
        return convertViewModel;
    }
}
