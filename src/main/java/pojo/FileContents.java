package pojo;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class FileContents {

    private Map<Pair,String> stringProbabiltyMap = new HashMap<Pair, String>();
    private int lastCumulativeProbability = 0; //out of 100
    private int maxProbability = 0;
    private String maxProbableString = null;

    public void build(String line) {
        int lastIndexOfComma = line.lastIndexOf(",");
        String string = line.substring(0,lastIndexOfComma);
        double probability = Double.parseDouble(line.substring(lastIndexOfComma + 1));
        int probabilityRange = (int) (probability * 100);
        Pair rangePair = new Pair(lastCumulativeProbability , lastCumulativeProbability += probabilityRange);
        stringProbabiltyMap.put(rangePair,string);

        if(maxProbability < probabilityRange){
            maxProbability = probabilityRange;
            maxProbableString = string;
        }
    }

    public Map<Pair,String> getStringProbabiltyMap() {
        return stringProbabiltyMap;
    }

    public void setStringProbabiltyMap(Map<Pair,String> stringProbabiltyMap) {
        this.stringProbabiltyMap = stringProbabiltyMap;
    }

    public String getStringForNumber(int randomNumber) {
        for(Pair currRange : stringProbabiltyMap.keySet()){
            if(randomNumber >= currRange.getStart() && randomNumber <= currRange.getEnd()){
                return stringProbabiltyMap.get(currRange);
            }
        }
        return maxProbableString;
    }
}
