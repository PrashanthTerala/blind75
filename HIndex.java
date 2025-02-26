import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int maxCitations = hIndex(citations);
        System.out.println(maxCitations);
    }

    // 1 1 3
    private static int hIndex(int[] citations) {
        int n  = citations.length;
        Arrays.sort(citations);
        int hindex=0;
        for(int i=0;i<n;i++){
            int h =  n-i;
            if(citations[i]>=h){
                hindex = h;
                break;
            }
        }
        return hindex;
    }
}
