package NeuralNetwork_Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import InvestmentPredictor.NeuralNetwork.BasicNeuralNetwork;
import InvestmentPredictor.NeuralNetwork.INeuron;
import InvestmentPredictor.NeuralNetwork.IWeight;
import InvestmentPredictor.NeuralNetwork.Neuron;
import InvestmentPredictor.NeuralNetwork.Weight;

public class BasicNeuralNetwork_Test 
{

	@Test
	public void testGetResult() 
	{
		
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
		BasicNeuralNetwork network = new BasicNeuralNetwork(fund, neuronList);
		ArrayList<IWeight> weightList = new ArrayList<IWeight>();
		Weight oneWeight = new Weight(fund, -5, 1.1);
		Weight twoWeight = new Weight(fund, 10, 0.9);
		Neuron oneNeuron = new Neuron(fund, 1, new Date(), weightList);
		Neuron twoNeuron = new Neuron(fund, 1, new Date(), weightList);
	}

	@Test
	public void testEvolveNetwork() 
	{
		
	}

	@Test
	public void testDeleteNeuron() 
	{
		
	}

}
