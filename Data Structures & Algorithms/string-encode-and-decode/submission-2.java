class Solution {

    public String encode(List<String> strs) {
        String output = "";
        for (String str : strs) {
            output += str + "\n";
        }
        return output;
    }

    public List<String> decode(String str) {

        System.out.println(str);
        List<String> output = new ArrayList<>();
        while (str.length() > 0) {
            output.add(str.substring(0, str.indexOf("\n")));
            str = str.substring(str.indexOf("\n") + 1);
        }
        return output;
    }
}
