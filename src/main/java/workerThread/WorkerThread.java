package workerThread;
import rwFiles.ReadFromFile;
import stableMarriage.StableMarriage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import static stableMarriage.StableMarriage.checkMatches;
public class WorkerThread implements Runnable {
    private String guPath;
    private String giPath;
    private String parovi;
    private String result;
    public WorkerThread(String guysPath,String girlsPath,String paroviPath,String result){
        this.guPath = guysPath;
        this.giPath = girlsPath;
        this.parovi = paroviPath;
        this.result = result;
    }
    @Override
    public void run() {
        ReadFromFile rf = new ReadFromFile();
        try {
            rf.readFromFile(guPath,giPath,parovi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StableMarriage st = new StableMarriage();
        BufferedWriter bw;

        try {

            bw = new BufferedWriter(new FileWriter(result,true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, String> matches = st.match(rf.getGuys(), rf.getGuysRang(), rf.getGirlsRang());
        for(Map.Entry<String, String> couple:matches.entrySet()){
            System.out.println(
                    couple.getKey() + " is engaged to " + couple.getValue());
            System.out.println(couple);
            try {
                bw.write(""+couple.getValue()+","+couple.getKey()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(checkMatches(rf.getGuys(), rf.getGirls(), matches, rf.getGuysRang(),rf.getGirlsRang())){
            try {
                bw.write("Marriages are stable\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                bw.write("Marriages are unstable\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
