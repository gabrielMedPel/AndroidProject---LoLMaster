package gabriel.medpel.lolmasterfinal.ui.spells;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.models.spells.Spell;
import gabriel.medpel.lolmasterfinal.models.spells.SpellDataSource;

public class SpellsViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Spell>> spell;

    public SpellsViewModel() {
        spell = new MutableLiveData<>();
        SpellDataSource ds = new SpellDataSource();
        ds.readDemo(spell);

    }

    public LiveData<ArrayList<Spell>> getSpell() {
        return spell;
    }
}