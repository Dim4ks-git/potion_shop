package com.potionshop;

import com.potionshop.models.Potion;

public interface PotionShopBusinessMethods {
    /**
     * Finds a potion in the stock by its id.
     *
     * @param potionId The ID of the potion to search for.
     * @return The Potion object if found, or null if not found.
     */
    Potion findPotion(String potionId);

    /**
     * Finds a potion in the stock by its id and specified quantity.
     *
     * @param potionId The ID of the potion to search for.
     * @param quantity The quantity to search for.
     * @return The Potion object if found, or null if not found.
     */
    Potion findPotion(String potionId, int quantity);
}
