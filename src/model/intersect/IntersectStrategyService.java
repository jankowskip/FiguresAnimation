package model.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FigureType;
import model.figures.Figure;

public class IntersectStrategyService {

	private Map<List<FigureType>, IntersectStrategy> strategies = new HashMap<List<FigureType>, IntersectStrategy>();

	public void addStrategy(FigureType a, FigureType b, IntersectStrategy strategy) {
		List<FigureType> key = Arrays.asList(a, b);
		strategies.put(key, strategy);
	}

	public boolean intersect(Figure a, Figure b) {
		for (List<FigureType> key : strategies.keySet()) {
			if (isMatching(key, Arrays.asList(a.getType(), b.getType()))) {
				return strategies.get(key).intersect(a, b);
			}
		}
		return false;
	}

	private boolean isMatching(List<FigureType> key, Collection<FigureType> collection) {
		List<FigureType> copy = new ArrayList<FigureType>(key);
		for (FigureType figureType : collection) {
			copy.remove(figureType);
		}
		return copy.isEmpty();
	}

}
