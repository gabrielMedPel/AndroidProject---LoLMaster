package gabriel.medpel.lolmasterfinal.ui.items;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.models.items.Item;
import gabriel.medpel.lolmasterfinal.models.items.ItemsDataSource;

public class ItemsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Item>> items;

    public ItemsViewModel() {
        items = new MutableLiveData<>();
        ItemsDataSource ds = new ItemsDataSource();
        ds.readDemo(items);

    }

    public LiveData<ArrayList<Item>> getItem() {
        return items;
    }
}