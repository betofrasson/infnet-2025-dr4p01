package com.suportedisciplinado;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = Math.min(item.quality + 3, 50);
        } else if (item.sellIn <= 10) {
            item.quality = Math.min(item.quality + 2, 50);
        } else {
            item.quality = Math.min(item.quality + 1, 50);
        }

        item.sellIn--;
    }
}
