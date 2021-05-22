package FindGen;

public class Allcodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex=dnaStr.indexOf(stopCodon,startIndex);
        while(currIndex!=-1){
            if((currIndex-startIndex)%3==0) return currIndex;
            else currIndex=dnaStr.indexOf(stopCodon,currIndex+1);
        }
        return Integer.MAX_VALUE;
    }
    
    
    public String findGene(String dna, int where){
        String result="";
        int startIndex=dna.indexOf("ATG",where);
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        if(startIndex==-1) return result;
        
        int idx=Math.min(Math.min(taaIndex,tagIndex),tgaIndex);
        if(idx==Integer.MAX_VALUE)return "";
        return dna.substring(startIndex,idx+3);
    }
    
    public void printAllGenes(String dna){
        int startIndex=0;
        while(true){
            String genes=findGene(dna,startIndex);
            if(genes.isEmpty())break;
            System.out.println(genes);
            startIndex=dna.indexOf(genes,startIndex)+genes.length();
        }
    }
    
    public void test(){
        //          0123456789012345678901234567
        String dna="ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }
}
