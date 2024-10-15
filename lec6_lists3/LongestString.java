/** Return the longest string in SLList. */
public class LongestString {
    public static String LongestStringInSLList(SLList<String> slList){
        int i = 0;
        int listSize = slList.size();
        String longest = slList.getFirst();
        while (listSize != 0) {
            listSize -= 1;
            String curString = slList.get(i);
            if (curString.length() > longest.length()) {
                longest = curString;
            }
            i += 1;
        }
        return longest;
    }

    
}
