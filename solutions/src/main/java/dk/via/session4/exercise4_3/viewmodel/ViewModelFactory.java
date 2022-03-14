package dk.via.session4.exercise4_3.viewmodel;

import dk.via.session4.exercise4_3.model.Model;

public class ViewModelFactory {
    private final CalculatorViewModel convertViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new CalculatorViewModel(model);
    }

    public CalculatorViewModel getConvertViewModel() {
        return convertViewModel;
    }
}
