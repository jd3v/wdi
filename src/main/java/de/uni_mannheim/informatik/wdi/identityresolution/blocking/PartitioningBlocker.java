package de.uni_mannheim.informatik.wdi.identityresolution.blocking;

import de.uni_mannheim.informatik.wdi.DataSet;
import de.uni_mannheim.informatik.wdi.Matchable;
import de.uni_mannheim.informatik.wdi.identityresolution.model.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of a simple blocking strategy based on blocking keys.
 * @author Oliver
 *
 * @param <RecordType>
 */
public class PartitioningBlocker<RecordType extends Matchable> extends Blocker<RecordType> {

	private BlockingFunction<RecordType> blockingFunction;
	
	public PartitioningBlocker(BlockingFunction<RecordType> blockingFunction) {
		this.blockingFunction = blockingFunction;
	}

	@Override
	public List<Pair<RecordType, RecordType>> generatePairs(DataSet<RecordType> dataset1,
			DataSet<RecordType> dataset2) {
		List<Pair<RecordType, RecordType>> result = new LinkedList<>();
		
//		//sort dataset1
//		int m1 = 1;
//		TreeMap<Double, RecordType> treemap1 = new TreeMap<Double, RecordType>();
//		TreeMap<Double, RecordType> treemapBoth = new TreeMap<Double, RecordType>();
//
//
//		for(RecordType r1 : dataset1.getRecords()) {
//			String key1 = blockingFunction.getBlockingKey(r1);
//			String keyEx1 = String.valueOf(m1);
//			key1 = key1 + keyEx1;
//			double intKey1 = Double.parseDouble(key1);
//			treemap1.put(intKey1, r1);
//			treemapBoth.put(intKey1, r1);
//			m1++;
//		}
//
//
//		//sort dataset2
////		int m2 = 1;
//		TreeMap<Double, RecordType> treemap2 = new TreeMap<Double, RecordType>();
//		for(RecordType r2 : dataset2.getRecords()) {
//			String key2 = blockingFunction.getBlockingKey(r2);
//			String keyEx2 = String.valueOf(m1);
//			key2 = key2 + keyEx2;
//			double intKey2 = Double.parseDouble(key2);
//			treemap2.put(intKey2, r2);
//			treemapBoth.put(intKey2, r2);
//			m1++;
//		}
////		TreeSet<Double> treeSet1 = new TreeSet<Double>(treemap1.keySet());
//		//TreeSet<Double> treeSet2 = new TreeSet<Double>(treemap2.keySet());
//		TreeSet<Double> treeSetBoth = new TreeSet<Double>(treemapBoth.keySet());
//
//		//check pairs
//		int arrayIndex = 0;
//		int halfWindowSize = 40;
//		int sameDatasetCounter = 0;
//		ArrayList<Double> treeSetArray = new ArrayList<Double>(treeSetBoth);
//
//		//forward direction
//		for (Double key1 : treeSetArray) {
//			sameDatasetCounter = 0;
//			if(treemap1.containsKey(key1)) {
//			RecordType r1 = treemap1.get(key1);
//			arrayIndex = treeSetArray.indexOf(key1);
//
//			   for (int j = arrayIndex; j < arrayIndex + halfWindowSize + sameDatasetCounter; j++) {
//				   if (j<treeSetArray.size()) {
//					   Double key2 = treeSetArray.get(j);
//
//						if(treemap2.containsKey(key2)) {
//						   RecordType r2 = treemap2.get(key2);
//						   result.add(new Pair<RecordType, RecordType>(r1, r2));
//						   } else {
//							   sameDatasetCounter++;
//						   }
//				   }
//			   }
//			}
//		}
//		//backward direction
//		for (Double key1 : treeSetArray) {
//			sameDatasetCounter = 0;
//			if(treemap1.containsKey(key1)) {
//			RecordType r1 = treemap1.get(key1);
//			arrayIndex = treeSetArray.indexOf(key1);
//
//			   for (int j = arrayIndex; j > arrayIndex - halfWindowSize - sameDatasetCounter; j--) {
//				   if (j>0) {
//					   Double key2 = treeSetArray.get(j);
//
//						if(treemap2.containsKey(key2)) {
//						   RecordType r2 = treemap2.get(key2);
//						   result.add(new Pair<RecordType, RecordType>(r1, r2));
//						   } else {
//							   sameDatasetCounter--;
//						   }
//				   }
//			   }
//			}
//		}
		
		for(RecordType r1 : dataset1.getRecords()) {
			String key1 = blockingFunction.getBlockingKey(r1);
			for(RecordType r2 : dataset2.getRecords()) {
				String key2 = blockingFunction.getBlockingKey(r2);
				if(r1!=r2 && key1.equals(key2)) {
					result.add(new Pair<RecordType, RecordType>(r1, r2));
				}
			}
		}
		
		calculatePerformance(dataset1, dataset2, result);
		
		return result;
	}
	
}
