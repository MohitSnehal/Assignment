import service.ProbabilityGenerator;
import service.impl.ProbabilityGeneratorImpl;
import utils.FileUtils;

public class Main {

    public static void main(String args[]) throws Exception{

        ProbabilityGenerator gen = new ProbabilityGeneratorImpl("probabilities.txt");

        StringBuffer outputStringBuffer = new StringBuffer();
        for(int i=0; i<1200; i++) {
            String nextStr = gen.getNextString();
            outputStringBuffer.append(nextStr + "\n");
        }
        try{
            FileUtils.createAndWriteToOutputFile("output.txt" , outputStringBuffer.toString());
        } catch (Exception ex) {
            System.out.println("Error while writing to output.txt. Error is as follows : \n");
            ex.printStackTrace();
        }
    }
}
