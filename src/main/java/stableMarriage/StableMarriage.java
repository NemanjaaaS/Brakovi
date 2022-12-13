package stableMarriage;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StableMarriage {

    private static Map<String,String> match(List<String> guys, Map<String,List<String>> guysRang,
                                            Map<String,List<String>> girlsRang){
        Map<String, String> engagedTo = new TreeMap<String, String>();
        List<String> freeGuys = new LinkedList<String>();
        freeGuys.addAll(guys);

        while(!freeGuys.isEmpty()){
            String thisGuy = freeGuys.remove(0); //get a load of THIS guy
            List<String> thisGuyPrefers = guysRang.get(thisGuy);
            for(String girl:thisGuyPrefers){
                if(engagedTo.get(girl) == null){//girl is free
                    engagedTo.put(girl, thisGuy); //awww
                    break;
                }else{
                    String otherGuy = engagedTo.get(girl);
                    List<String> thisGirlPrefers = girlsRang.get(girl);
                    if(thisGirlPrefers.indexOf(thisGuy) <
                            thisGirlPrefers.indexOf(otherGuy)){
                        //this girl prefers this guy to the guy she's engaged to
                        engagedTo.put(girl, thisGuy);
                        freeGuys.add(otherGuy);
                        break;
                    }//else no change...keep looking for this guy
                }
            }
        }
        return engagedTo;
    }


    private static boolean checkMatches(List<String> guys, List<String> girls,
                                        Map<String, String> matches, Map<String, List<String>> guyPrefers,
                                        Map<String, List<String>> girlPrefers) {
        if(!matches.keySet().containsAll(girls)){
            return false;
        }

        if(!matches.values().containsAll(guys)){
            return false;
        }

        Map<String, String> invertedMatches = new TreeMap<String, String>();
        for(Map.Entry<String, String> couple:matches.entrySet()){
            invertedMatches.put(couple.getValue(), couple.getKey());
        }

        for(Map.Entry<String, String> couple:matches.entrySet()){
            List<String> shePrefers = girlPrefers.get(couple.getKey());
            List<String> sheLikesBetter = new LinkedList<String>();
            sheLikesBetter.addAll(shePrefers.subList(0, shePrefers.indexOf(couple.getValue())));
            List<String> hePrefers = guyPrefers.get(couple.getValue());
            List<String> heLikesBetter = new LinkedList<String>();
            heLikesBetter.addAll(hePrefers.subList(0, hePrefers.indexOf(couple.getKey())));

            for(String guy : sheLikesBetter){
                String guysFinace = invertedMatches.get(guy);
                List<String> thisGuyPrefers = guyPrefers.get(guy);
                if(thisGuyPrefers.indexOf(guysFinace) >
                        thisGuyPrefers.indexOf(couple.getKey())){
                    System.out.printf("%s likes %s better than %s and %s"
                                    + " likes %s better than their current partner\n",
                            couple.getKey(), guy, couple.getValue(),
                            guy, couple.getKey());
                    return false;
                }
            }

            for(String girl : heLikesBetter){
                String girlsFinace = matches.get(girl);
                List<String> thisGirlPrefers = girlPrefers.get(girl);
                if(thisGirlPrefers.indexOf(girlsFinace) >
                        thisGirlPrefers.indexOf(couple.getValue())){
                    System.out.printf("%s likes %s better than %s and %s"
                                    + " likes %s better than their current partner\n",
                            couple.getValue(), girl, couple.getKey(),
                            girl, couple.getValue());
                    return false;
                }
            }
        }
        return true;
    }

}
