package NeuralNetwork_Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import InvestmentPredictor.NeuralNetwork.BasicNeuralNetwork;
import InvestmentPredictor.NeuralNetwork.INeuron;
import InvestmentPredictor.NeuralNetwork.IResult;
import InvestmentPredictor.NeuralNetwork.IWeight;
import InvestmentPredictor.NeuralNetwork.Neuron;
import InvestmentPredictor.NeuralNetwork.Weight;

public class BasicNeuralNetwork_Test 
{

	@Test
	public void testGetResult() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		ArrayList<IWeight> weightList = new ArrayList<IWeight>();
		ArrayList<IWeight> weightList2 = new ArrayList<IWeight>();
		
		Weight oneWeight = new Weight("QQQ_INDEX", 10, 1.5);
		Weight twoWeight = new Weight("QQQ_Commondity", 5, 0.75);
		Weight oneWeight2 = new Weight("QQQ_INDEX", 10, 1.4);
		Weight twoWeight2 = new Weight("QQQ_Commondity", 5, 0.70);
		
		weightList.add(oneWeight);
		weightList.add(twoWeight);
		weightList2.add(oneWeight2);
		weightList2.add(twoWeight2);
		
		Neuron oneNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron twoNeuron = new Neuron(fund, 1, new Date(), weightList2);
		Neuron threeNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron fourNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron fiveNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron sixNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron sevenNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron eightNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron nineNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron tenNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron elevenNeuron = new Neuron(fund, 1, new Date(), weightList);
		
		oneNeuron.SetRating(2);
		twoNeuron.SetNeuronId(1);
		threeNeuron.SetRating(3);
		fourNeuron.SetRating(4);
		fiveNeuron.SetRating(5);
		sixNeuron.SetRating(6);
		sevenNeuron.SetRating(7);
		eightNeuron.SetNeuronId(8);
		nineNeuron.SetRating(9);
		tenNeuron.SetRating(10);
		elevenNeuron.SetRating(11);
		
		neuronList.add(oneNeuron);
		neuronList.add(twoNeuron);
		neuronList.add(threeNeuron);
		neuronList.add(fourNeuron);
		neuronList.add(fiveNeuron);
		neuronList.add(sixNeuron);
		neuronList.add(sevenNeuron);
		neuronList.add(eightNeuron);
		neuronList.add(nineNeuron);
		neuronList.add(tenNeuron);
		neuronList.add(elevenNeuron);
		
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		IResult result = network.GetResult(new BigDecimal(100));
		
		assertEquals(new GregorianCalendar().getTime(), result.GetEstimationDate().getTime());
		assertEquals(fund, result.GetFundID());
		assertEquals(118.125, result.GetEstimation(), 0.01);
	}

	@Test
	public void testGetFundTicker() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		
		assertEquals(fund, network.GetFundTicker());
	}

	@Test
	public void testSetFundTicker() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		network.SetFundTicker("GOOG");
		
		assertEquals("GOOG", network.GetFundTicker());	
	}

	@Test
	public void testEvaluateNeurons() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		ArrayList<IWeight> weightList = new ArrayList<IWeight>();
		
		Neuron oneNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron twoNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron threeNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron fourNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron fiveNeuron = new Neuron(fund, 1, new Date(), weightList);
		
		oneNeuron.SetRating(2);
		twoNeuron.SetNeuronId(1);
		threeNeuron.SetRating(5);
		fourNeuron.SetRating(4);
		fiveNeuron.SetRating(3);
		
		neuronList.add(oneNeuron);
		neuronList.add(twoNeuron);
		neuronList.add(threeNeuron);
		neuronList.add(fourNeuron);
		neuronList.add(fiveNeuron);
		
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		network.EvaluateNeurons();
		
		assertEquals(oneNeuron.GetNeuronId(), network.GetNeuronList().get(0).GetNeuronId());
		assertEquals(twoNeuron.GetNeuronId(), network.GetNeuronList().get(1).GetNeuronId());
		assertEquals(threeNeuron.GetNeuronId(), network.GetNeuronList().get(2).GetNeuronId());
		assertEquals(fourNeuron.GetNeuronId(), network.GetNeuronList().get(3).GetNeuronId());
		assertEquals(fiveNeuron.GetNeuronId(), network.GetNeuronList().get(4).GetNeuronId());
	}

	@Test
	public void testEvolveNetwork() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		ArrayList<IWeight> weightList = new ArrayList<IWeight>();
		ArrayList<IWeight> weightList2 = new ArrayList<IWeight>();
		
		Weight oneWeight = new Weight("QQQ_INDEX", 10, 1.5);
		Weight twoWeight = new Weight("QQQ_Commondity", 5, 0.75);
		Weight oneWeight2 = new Weight("QQQ_INDEX", 10, 1.4);
		Weight twoWeight2 = new Weight("QQQ_Commondity", 5, 0.70);
		
		weightList.add(oneWeight);
		weightList.add(twoWeight);
		weightList2.add(oneWeight2);
		weightList2.add(twoWeight2);
		
		Neuron oneNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron twoNeuron = new Neuron(fund, 2, new Date(), weightList2);
		Neuron threeNeuron = new Neuron(fund, 3, new Date(), weightList);
		Neuron fourNeuron = new Neuron(fund, 4, new Date(), weightList);
		Neuron fiveNeuron = new Neuron(fund, 5, new Date(), weightList);
		Neuron sixNeuron = new Neuron(fund, 6, new Date(), weightList);
		Neuron sevenNeuron = new Neuron(fund, 8, new Date(), weightList);
		Neuron eightNeuron = new Neuron(fund, 9, new Date(), weightList);
		Neuron nineNeuron = new Neuron(fund, 10, new Date(), weightList);
		Neuron tenNeuron = new Neuron(fund, 11, new Date(), weightList);
		Neuron elevenNeuron = new Neuron(fund, 7, new Date(), weightList);
		
		oneNeuron.SetRating(2);
		twoNeuron.SetNeuronId(1);
		threeNeuron.SetRating(3);
		fourNeuron.SetRating(4);
		fiveNeuron.SetRating(5);
		sixNeuron.SetRating(6);
		sevenNeuron.SetRating(7);
		eightNeuron.SetNeuronId(8);
		nineNeuron.SetRating(9);
		tenNeuron.SetRating(10);
		elevenNeuron.SetRating(11);
		
		neuronList.add(oneNeuron);
		neuronList.add(twoNeuron);
		neuronList.add(threeNeuron);
		neuronList.add(fourNeuron);
		neuronList.add(fiveNeuron);
		neuronList.add(sixNeuron);
		neuronList.add(sevenNeuron);
		neuronList.add(eightNeuron);
		neuronList.add(nineNeuron);
		neuronList.add(tenNeuron);
		neuronList.add(elevenNeuron);
		
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		network.EvolveNetwork();
		INeuron newNeuron = network.GetNeuronList().get(10);
		
		assertEquals(11, network.GetNeuronList().size());
		assertEquals(fund, newNeuron.GetFundTicker());
		assertEquals(new GregorianCalendar(), newNeuron.GetBirthDate());
		assertEquals(7, newNeuron.GetNeuronId());
		assertFalse(elevenNeuron.equals(newNeuron));
	}

	@Test
	public void testDeleteNeuron() 
	{
		String fund = "QQQ";
		ArrayList<INeuron> neuronList = new ArrayList<INeuron>();
		ArrayList<IWeight> weightList = new ArrayList<IWeight>();		
		Neuron oneNeuron = new Neuron(fund, 1, new Date(), weightList);
		oneNeuron.SetRating(1);
		neuronList.add(oneNeuron);
		
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		
		network.DeleteNeuron(oneNeuron);
		
		assertEquals(0, network.GetNeuronList().size());
	}

}
