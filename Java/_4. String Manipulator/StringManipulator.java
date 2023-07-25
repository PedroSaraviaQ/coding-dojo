public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim() + str2.trim();
    }

    public int getIndexOrNull(String str, char letter) {
        return str.indexOf(letter);
    }

    public int getIndexOrNull(String str, String subStr) {
        return str.indexOf(subStr);
    }

    public String concatSubstring(String str1, int start, int end, String str2) {
        return str1.substring(start, end) + str2;
    }
}
