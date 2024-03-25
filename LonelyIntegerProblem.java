import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

   public static int lonelyinteger(List<Integer> a) {
    Collections.sort(a);
    List<Integer> checked = new ArrayList<Integer>();
    
    for(int i=0;i<a.size();i++) {
        int num =a.get(i);
        if(!checked.contains(num)) {
            
            boolean isFound=false;
            
            for(int j=i+1;j<a.size();j++) {
                if(num==(a.get(j))) {
                    isFound=true;
                    break;
                }
            }
                if(isFound==false) {
                    return num;
                 }else{
                checked.add(num);
                }
             }
            
        }
         return -1;
       
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
