package com.suportedisciplinado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

    @Test
    public void testAgedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void testBackstagePassesIncrease() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(22, items[1].quality);
        assertEquals(23, items[2].quality);
        assertEquals(0, items[3].quality);
    }

    @Test
    public void testNormalItemDegrades() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    public void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void testQualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality);
    }
}
