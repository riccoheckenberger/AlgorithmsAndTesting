package de.hska.iwi.ads.solution.generics;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.hska.iwi.ads.generics.AbstractDeliveryService;
import de.hska.iwi.ads.generics.Address;
import de.hska.iwi.ads.generics.Box;

public class Delivery<T> extends AbstractDeliveryService<T> {
	
	public Delivery() {}

	@Override
	public Map<Box<T>, Address> getFoodBoxes() {
		return this.stackOfFoodBoxes;
	}

	@Override
	public Set<Box<T>> deliver(Address address) {
		Set<Box<T>> returnSet = new HashSet<>();
		Set<java.util.Map.Entry<Box<T>, Address>> removeSet = new HashSet<>();
		
		for (java.util.Map.Entry<Box<T>, Address> entry : this.stackOfFoodBoxes.entrySet()) {
			if (entry.getValue().equals(address)) {
				 returnSet.add(entry.getKey());
				 removeSet.add(entry);
			}
		}
		
		this.stackOfFoodBoxes.entrySet().removeAll(removeSet);
		return returnSet;
	}
	

}
