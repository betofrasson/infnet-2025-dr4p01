package com.suportedisciplinado;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    updateSulfuras(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                default:
                    updateRegularItem(item);
                    break;
            }
        }
    }

    private void updateAgedBrie(Item item) {
        decreaseSellIn(item);

        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    private void updateSulfuras(Item item) {

    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn < 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }

    private void updateRegularItem(Item item) {
        decreaseSellIn(item);

        if (item.quality > 0) {
            item.quality--;
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(item.quality + amount, 50);
    }
}