package Bioinf;

import java.util.ArrayList;

public class Edge implements Comparable<Edge>{
	
	int weight = 0;
	Node start;
	Node end ;
	String commonSeq;	
	int maxOverlap;
	Sequence s = new Sequence();
	
	
	public Edge(Node n){
		this.start = n;
		this.end = null;
		this.weight = 0;
	}
	
	
	//n1 = Startknoten, n2 = Endknoten --> gerichtete Kante
	public Edge(Node n1, Node n2) {
		this.start = n1;
		this.end = n2;	
	}
	//n1 = Startknoten, n2 = Endknoten --> gerichtete Kante mit Gewichtung
	public Edge(Node n1, Node n2, int weight) {
	this.start = n1;
	this.end = n2;		
	this.weight = weight;
	}
	
	
	int getMaxOverlapCount() {		
		return maxOverlap = s.maxOverlapCount(start.getSequence(),end.getSequence());
	}
	
	String mergeNodes(){	
		if (this.end == null || this.end.getSequence().length() == 0) {
			return this.start.getSequence();
		}
		String newSequence;
		int startLen = this.start.getSequence().length();
		int endLen = this.end.getSequence().length();
		String nodeStartCut = this.start.getSequence().substring(0, startLen - getMaxOverlapCount());		
		newSequence = nodeStartCut + this.end.getSequence();					
		return newSequence;
	}
	
		void setWeight(int gew) {
		this.weight=  gew;
		}

	int getWeight() {
		return this.weight;
	}
	
	Node getFirstNode() {
		return start;
	}
	
	Node getEndNode() {
		return end;
	}
	
	String getCommonStringSequence() {
		s = new Sequence(start.getSequence());
		return commonSeq = s.overlap(end.getSequence());		
	}
	
		
	boolean hasWeight() {
		if (this.weight > 0) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public String toString() {
		if (end == null) { 
			return start.toString(); 
			}
		return start.toString()+ "--->" + end.toString() + "==>(" +getCommonStringSequence() + ")" + "[" + getWeight() + "]";
	}
	
	String toGraphViz() {
		return "   "+start.toString()+ " -> " + end.toString() + " [label=\"" + getCommonStringSequence() + getWeight() +"\"]";
	}

	@Override
	public int compareTo(Edge other) {
		if (this.getWeight() > other.getWeight()) { return 1;}
		if (this.getWeight() == other.getWeight()) { return 0;}
		if (this.getWeight() < other.getWeight()) { return -1;}
		return 0;
	}
	
	
}
