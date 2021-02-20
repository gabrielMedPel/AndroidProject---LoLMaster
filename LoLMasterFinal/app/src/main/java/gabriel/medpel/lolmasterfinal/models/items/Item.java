package gabriel.medpel.lolmasterfinal.models.items;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.MainScreenActivity;

public class Item {
    private String itemName;
    private String itmUrlImg;
    private String description;
    private String plainText;
    private String goldBuy;
    private String goldSell;
    private ArrayList<String> tags;


    public Item(String itemName, String itmUrlImg, String description, String plainText, String goldBuy, String goldSell, ArrayList<String> tags) {
        this.itemName = itemName;
        this.itmUrlImg = itmUrlImg;
        this.description = description;
        this.plainText = plainText;
        this.goldBuy = goldBuy;
        this.goldSell = goldSell;
        this.tags = tags;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItmUrlImg() {
        return "https://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/img/item/"+itmUrlImg;
    }
    public String getDescription() {
        return description;
    }
    public String getPlainText() {
        return plainText;
    }
    public String getGoldBuy() {
        return goldBuy;
    }
    public String getGoldSell() {
        return goldSell;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
