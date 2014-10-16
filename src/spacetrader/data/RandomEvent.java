/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;
import java.util.List;

import spacetrader.models.Player;
import spacetrader.models.Ship;

/**
 * A random event that can happen during space travel.
 * 
 * @author Justin
 */
public abstract class RandomEvent {
    
    private double probabilityMultiplier;
    private String name;

    protected RandomEvent(double probabilityMultiplier, String name) {
        this.probabilityMultiplier = probabilityMultiplier;
        this.name = name;
    }

    /**
     * String representation of the RadicalEvent
     */
    @Override
    public String toString() {
        return this.name;
    }
    
    /**
     * Gets the probability multiplier
     * @return A value representing how likely this event is to happen
     */
    public double getProbabilityMultiplier() {
        return this.probabilityMultiplier;
    }
    
    /**
     * Applies the random event to the given universe and returns a description
     * of what happened.
     * @param player The player the event happened to
     * @return A description of what happened
     */
    public abstract String apply(Player player);
    
    
}