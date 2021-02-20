package gabriel.medpel.lolmasterfinal.ui.runes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.models.runes.RuneClass;
import gabriel.medpel.lolmasterfinal.models.runes.RunesDataSource;

public class RunesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<RuneClass>> runeClasses;

    public RunesViewModel() {
        runeClasses = new MutableLiveData<>();

        RunesDataSource ds = new RunesDataSource();
        ds.readDemo(runeClasses);

    }

    public LiveData<ArrayList<RuneClass>> getRuneClasses() {
        return runeClasses;
    }
}