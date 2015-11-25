package de.uni_mannheim.informatik.wdi.identityresolution.similarity.string;

import com.wcohen.ss.Jaro;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.SimilarityMeasure;
/**
 * Created by Daniel on 25/11/15.
 */
public class JaroSimilarity extends SimilarityMeasure<String> {

	@Override
	public double calculate(String first, String second) {
		if(first==null || second==null) {
			return 0.0;
		} else {
			Jaro j = new Jaro();		
			double score = j.score(first, second);			
			return score;
		}
	}
	

}
