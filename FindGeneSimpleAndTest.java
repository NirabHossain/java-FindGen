package FindGen;


/**
 * Write a description of FindGeneSimple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest {
    
    
    
    public String findGeneSimple(String dna){
        String result="";
        int startIndex=dna.indexOf("ATG");
        int currIndex=dna.indexOf("TAA",startIndex+3);
        if(startIndex==-1) return result;
        
        while(currIndex!=-1){
            if((currIndex-startIndex)%3==0) return dna.substring(startIndex,currIndex+3);
            else currIndex=dna.indexOf("TAA",currIndex+1);
        }
        return "Gene not found";
    }
    public void testFindGeneSimple(){
        String dna="AATGCGTAATAGCT";
        System.out.println(dna);
        String gene= findGeneSimple(dna);
        System.out.println(gene);
        
        dna="AATGCTAGGGTAATATGGT";
        System.out.println(dna);
        gene= findGeneSimple(dna);
        System.out.println(gene);
        
        dna="ATCCTAATGCTTCGGCTGCTCTAATATGGT";
        System.out.println(dna);
        gene= findGeneSimple(dna);
        System.out.println(gene);
        
        dna="ATTAA";
        System.out.println(dna);
        gene= findGeneSimple(dna);
        System.out.println("Gene: "+gene);
        
    }
}
