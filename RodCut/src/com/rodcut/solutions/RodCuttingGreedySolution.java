package com.rodcut.solutions;

import java.util.ArrayList;
import java.util.List;

import com.rodcut.model.Rod;
import com.rodcut.model.RodCuttingStrategy;

public class RodCuttingGreedySolution implements RodCuttingStrategy {

	public List<Rod> getMaximumRevenueRods(int totalLength, List<Rod> rodList) {

		// sort rods by price length ratio
		rodList = RodCuttingCommon.getInstance().sortByPriceLengthRatio(rodList);

		// greedy add rods until sum of selected rods length not > total length
		int currentLength = 0;
		int index = 0;
		List<Rod> selectedRods = new ArrayList<Rod>();
		while (currentLength <= totalLength) {
			Rod rod = rodList.get(index);
			if (rod.getLength() <= currentLength) {
				Rod selectedRod = new Rod();
				selectedRod.setIndex(rod.getIndex());
				selectedRod.setLength(rod.getLength());
				selectedRod.setPrice(rod.getPrice());
				selectedRod.setPriceRatio(rod.getPriceRatio());
				selectedRods.add(selectedRod);
				currentLength += rod.getLength();
			} 
			else {
				index++;
			}
		}
		return selectedRods;
	}

	public double getMaximumRevenue(int totalLength, List<Rod> rodList) {
		List<Rod> maximumRevenueRods = getMaximumRevenueRods(totalLength, rodList);
		double sum = 0;
		for(Rod rod : maximumRevenueRods) {
			sum += rod.getPrice();
		}
		return sum;
	}

}
