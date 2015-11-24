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
import de.uni_mannheim.informatik.wdi.identityresolution.evaluation.GoldStandard;
import de.uni_mannheim.informatik.wdi.identityresolution.evaluation.MatchingEvaluator;
import de.uni_mannheim.informatik.wdi.identityresolution.evaluation.Performance;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.Correspondence;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.LinearCombinationMatchingRule;
import de.uni_mannheim.informatik.wdi.identityresolution.matching.MatchingEngine;
import de.uni_mannheim.informatik.wdi.identityresolution.model.DefaultRecord;
import de.uni_mannheim.informatik.wdi.identityresolution.model.DefaultRecordCSVFormatter;
import de.uni_mannheim.informatik.wdi.usecase.movies.Movie;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.CityLocationComparator;
<<<<<<< HEAD
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.CityNameComparator;
=======
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.CityNameComparatorLevenshtein;
import de.uni_mannheim.informatik.wdi.usecase.wdiproject.comparators.CityPopulationComparator;
>>>>>>> 2de1e6869c5ab37b826a520c3d5fd43aa4fe2f13

/**
 * Created by Mats on 15/11/15.
 */
public class Cities_Main {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {

		// define the matching rule
<<<<<<< HEAD
		LinearCombinationMatchingRule<City> rule = new LinearCombinationMatchingRule<>(1, 1);
		rule.addComparator(new CityNameComparator(), 1);
		rule.addComparator(new CityLocationComparator(), 0.1);
		// rule.addComparator(new CityPopulationComparator(), 1);
=======
		LinearCombinationMatchingRule<City> rule = new LinearCombinationMatchingRule<>(0, 1);
		rule.addComparator(new CityNameComparatorLevenshtein(), 0.9);
		rule.addComparator(new CityLocationComparator(), 0.2);
		rule.addComparator(new CityPopulationComparator(), 0.2);
>>>>>>> 2de1e6869c5ab37b826a520c3d5fd43aa4fe2f13

		// create the matching engine
		Blocker<City> blocker = new PartitioningBlocker<>(new CityBlockingFunction());
		MatchingEngine<City> engine = new MatchingEngine<>(rule, blocker);

		// load the data sets
		DataSet<City> geonames = new DataSet<>();
		DataSet<City> maxmind = new DataSet<>();
		DataSet<City> dbpCity = new DataSet<>();

<<<<<<< HEAD
		geonames.loadFromXML(new File("usecase/wdiproject/input/geonames.xml"), new CityFactory(),
				"/cities/city");
=======
		geonames.loadFromXML(new File("usecase/wdiproject/input/geonames.xml"), new CityFactory(), "/cities/city");
>>>>>>> 2de1e6869c5ab37b826a520c3d5fd43aa4fe2f13
		maxmind.loadFromXML(new File("usecase/wdiproject/input/maxmind.xml"), new CityFactory(), "/cities/city");

		// dbpCity.loadFromXML(
		// new File("usecase/wdiproject/input/cities.xml"),
		// new CityFactory(), "/cities/city");

		// run the matching
		List<Correspondence<City>> correspondences = engine.runMatching(geonames, maxmind);

		// write the correspondences to the output file
		engine.writeCorrespondences(correspondences,
				new File("usecase/wdiproject/output/Geonames_2_Maxmind_correspondences.csv"));

		printCorrespondences(correspondences);

		// load the gold standard (training set)
		GoldStandard gsTraining = new GoldStandard();
		gsTraining.loadFromCSVFile(new File("usecase/wdiproject/goldstandard/gs_geonames2maxmind.csv"));

		// create the data set for learning a matching rule (use this file in
		// RapidMiner)
		DataSet<DefaultRecord> features = engine.generateTrainingDataForLearning(geonames, maxmind, gsTraining);
		features.writeCSV(new File("usecase/wdiproject/output/optimisation/geonames2maxmind.csv"),
				new DefaultRecordCSVFormatter());

		// load the gold standard (test set)
		GoldStandard gsTest = new GoldStandard();
		gsTest.loadFromCSVFile(new File("usecase/wdiproject/goldstandard/Geonames_2_Maxmind_correspondences.csv"));

		// evaluate the result
		MatchingEvaluator<City> evaluator = new MatchingEvaluator<>(true);
		Performance perfTest = evaluator.evaluateMatching(correspondences, gsTest);

		// print the evaluation result
		System.out.println(String.format("Precision: %.4f\nRecall: %.4f\nF1: %.4f", perfTest.getPrecision(),
				perfTest.getRecall(), perfTest.getF1()));

	}

	private static void printCorrespondences(List<Correspondence<City>> correspondences) {
		// sort the correspondences

		// Collections.sort(correspondences, new
		// Comparator<Correspondence<City>>() {
		//
		// @Override
		// public int compare(Correspondence<City> o1, Correspondence<City> o2)
		// {
		// int score = Double.compare(o1.getSimilarityScore(),
		// o2.getSimilarityScore());
		// int name =
		// o1.getFirstRecord().getName().compareTo(o2.getFirstRecord().getName());
		//
		// if(score!=0) {
		// return -score;
		// } else {
		// return name;
		// }
		// }
		//
		// });

		// print the correspondences
		for (Correspondence<City> correspondence : correspondences) {
			if (correspondence.getSimilarityScore() > 1.0) {
<<<<<<< HEAD
				System.out
						.println(
								String.format("%s,%s,|\t\t%.2f\t[%s] %s (%s) <--> [%s] %s (%s)",
										correspondence.getFirstRecord().getIdentifier(),
										correspondence.getSecondRecord().getIdentifier(), correspondence
												.getSimilarityScore(),
										correspondence.getFirstRecord().getIdentifier(),
										correspondence.getFirstRecord().getName(),
										correspondence.getFirstRecord().getPopulation(),
										correspondence.getSecondRecord().getIdentifier(),
										correspondence.getSecondRecord().getName(),
										correspondence.getSecondRecord().getPopulation()));
=======
				System.out.println(String.format("%s,%s,|\t\t%.2f\t[%s] %s (%s, %s, %s) <--> [%s] %s (%s, %s, %s)",
						correspondence.getFirstRecord().getIdentifier(),
						correspondence.getSecondRecord().getIdentifier(), correspondence.getSimilarityScore(),
						correspondence.getFirstRecord().getIdentifier(), correspondence.getFirstRecord().getName(),
						correspondence.getFirstRecord().getPopulation(),
						correspondence.getFirstRecord().getLat(),
						correspondence.getFirstRecord().getLon(),
						correspondence.getSecondRecord().getIdentifier(), correspondence.getSecondRecord().getName(),
						correspondence.getSecondRecord().getPopulation(),
						correspondence.getSecondRecord().getLat(),
						correspondence.getSecondRecord().getLon()
						));
>>>>>>> 2de1e6869c5ab37b826a520c3d5fd43aa4fe2f13
			}
		}
	}

}
