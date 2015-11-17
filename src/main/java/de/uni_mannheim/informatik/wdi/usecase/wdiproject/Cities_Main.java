package de.uni_mannheim.informatik.wdi.usecase.wdiproject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import de.uni_mannheim.informatik.wdi.DataSet;
import de.uni_mannheim.informatik.wdi.identityresolution.blocking.Blocker;
import de.uni_mannheim.informatik.wdi.identityresolution.blocking.PartitioningBlocker;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.Correspondence;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.LinearCombinationMatchingRule;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.MatchingEngine;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.CityLocationComparator;

/**
 * Created by Mats on 15/11/15.
 */
public class Cities_Main {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {

		// define the matching rule
		LinearCombinationMatchingRule<City> rule = new LinearCombinationMatchingRule<>(1, 1);
//		rule.addComparator(new CityNameComparator(), 2);
		rule.addComparator(new CityLocationComparator(), 2);

		// create the matching engine
		Blocker<City> blocker = new PartitioningBlocker<>(new CityBlockingFunction());
		MatchingEngine<City> engine = new MatchingEngine<>(rule, blocker);

		// load the data sets
		DataSet<City> geonames = new DataSet<>();
		DataSet<City> maxmind = new DataSet<>();
		DataSet<City> dbpCity = new DataSet<>();

		geonames.loadFromXML(new File("usecase/wdiproject/input/geonames_sample.xml"), new CityFactory(), "/cities/city");
		maxmind.loadFromXML(new File("usecase/wdiproject/input/maxmind_sample.xml"), new CityFactory(), "/cities/city");

		// dbpCity.loadFromXML(
		// new File("usecase/wdiproject/input/cities.xml"),
		// new CityFactory(), "/cities/city");

		// run the matching
		List<Correspondence<City>> correspondences = engine.runMatching(geonames, maxmind);

		// write the correspondences to the output file
		engine.writeCorrespondences(correspondences,new File("usecase/wdiproject/output/Geonames_2_Maxmind_correspondences.csv"));

//		printCorrespondences(correspondences);
		
//		// load the gold standard (training set)
//		GoldStandard gsTraining = new GoldStandard();
//		gsTraining.loadFromCSVFile(new File(
//				"usecase/movie/goldstandard/gs_academy_awards_2_actors.csv"));
//
//		// create the data set for learning a matching rule (use this file in RapidMiner)
//		DataSet<DefaultRecord> features = engine
//				.generateTrainingDataForLearning(ds1, ds2, gsTraining);
//		features.writeCSV(
//				new File(
//						"usecase/movie/output/optimisation/academy_awards_2_actors_features.csv"),
//				new DefaultRecordCSVFormatter());
//		
//		// load the gold standard (test set)
//		GoldStandard gsTest = new GoldStandard();
//		gsTest.loadFromCSVFile(new File(
//				"usecase/movie/goldstandard/gs_academy_awards_2_actors_test.csv"));
//
//		// evaluate the result
//		MatchingEvaluator<Movie> evaluator = new MatchingEvaluator<>(true);
//		Performance perfTest = evaluator.evaluateMatching(correspondences, gsTest);
//		
//		// print the evaluation result
//		System.out.println(String.format(
//				"Precision: %.4f\nRecall: %.4f\nF1: %.4f", perfTest.getPrecision(),
//				perfTest.getRecall(), perfTest.getF1()));

	}

	private static void printCorrespondences(List<Correspondence<City>> correspondences) {
		// sort the correspondences
//		Collections.sort(correspondences, new Comparator<Correspondence<City>>() {
//
//			@Override
//			public int compare(Correspondence<City> o1, Correspondence<City> o2) {
//				int score = Double.compare(o1.getSimilarityScore(), o2.getSimilarityScore());
//				int title = o1.getFirstRecord().getTitle().compareTo(o2.getFirstRecord().getTitle());
//
//				if (score != 0) {
//					return -score;
//				} else {
//					return title;
//				}
//			}
//
//		});
//
//		// print the correspondences
//		for (Correspondence<City> correspondence : correspondences) {
//			if (correspondence.getSimilarityScore() < 1.0) {
//				System.out.println(String.format("%s,%s,|\t\t%.2f\t[%s] %s (%s) <--> [%s] %s (%s)",
//						correspondence.getFirstRecord().getIdentifier(),
//						correspondence.getSecondRecord().getIdentifier(), correspondence.getSimilarityScore(),
//						correspondence.getFirstRecord().getIdentifier(), correspondence.getFirstRecord().getTitle(),
//						correspondence.getFirstRecord().getDate().toString("YYYY-MM-DD"),
//						correspondence.getSecondRecord().getIdentifier(), correspondence.getSecondRecord().getTitle(),
//						correspondence.getSecondRecord().getDate().toString("YYYY-MM-DD")));
//			}
//		}
	}

}
