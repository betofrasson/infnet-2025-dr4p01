package com.suportedisciplinado;

/**
 * A classe GildedRose segue o Princípio Aberto-Fechado (OCP) ao delegar a lógica de atualização
 * de cada item para uma implementação da interface ItemUpdater, obtida através de uma factory.
 *
 * Essa arquitetura permite adicionar novos tipos de item sem modificar a lógica da GildedRose.
 * A responsabilidade de selecionar o atualizador adequado é movida para a ItemUpdaterFactory,
 * promovendo extensibilidade e desacoplamento.
 *
 * Cada ItemUpdater também respeita o Princípio da Responsabilidade Única (SRP),
 * ao isolar a regra de atualização de um único tipo de item por classe.
 *
 * A substituição por instâncias de ItemUpdater segue o Princípio de Substituição de Liskov (LSP),
 * pois qualquer implementador da interface pode ser usado sem alterar o comportamento esperado.
 */

class GildedRose {
    private final Item[] items;
    private final ItemUpdaterFactory updaterFactory;

    public GildedRose(Item[] items) {
        this(items, new DefaultItemUpdaterFactory());
    }

    public GildedRose(Item[] items, ItemUpdaterFactory factory) {
        this.items = items;
        this.updaterFactory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = updaterFactory.getUpdaterFor(item);
            updater.update(item);
        }
    }
}