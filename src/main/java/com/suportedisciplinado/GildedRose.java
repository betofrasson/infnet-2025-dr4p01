package com.suportedisciplinado;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = getUpdaterFor(item);
            updater.update(item);
        }
    }

    private ItemUpdater getUpdaterFor(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieUpdater();
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdater();
            default -> new DefaultUpdater();
        };
    }
}