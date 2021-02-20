package gabriel.medpel.lolmasterfinal.ui.champions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.models.champions.Champion;
import gabriel.medpel.lolmasterfinal.models.champions.ChampionDataSource;

public class ChampionsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Champion>> champ;

    public ChampionsViewModel() {
        champ = new MutableLiveData<>();
        ChampionDataSource ds = new ChampionDataSource();
        ds.readDemo(champ);
    }

    public LiveData<ArrayList<Champion>> getChamp() {
        return champ;
    }
}