package com.suportedisciplinado;

import java.util.HashMap;
import java.util.Map;

public class DefaultItemUpdaterFactory implements ItemUpdaterFactory {
    private final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    public DefaultItemUpdaterFactory() {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaterMap.put("Conjured", new ConjuredItemUpdater());
    }

    @Override
    public ItemUpdater getUpdaterFor(Item item) {
        return updaterMap.getOrDefault(item.name, new DefaultUpdater());
    }
}
