class Solution {
    public String simplifyPath(String path) {
        String simplepath = "";

        String[] dirs = path.split("/");

        for (String dir : dirs) {
            switch(dir) {
                case "":
                case ".":
                    break;
                case "..":
                    if (simplepath.lastIndexOf("/") == -1) {
                        break;
                    }
                    simplepath = simplepath.substring(0, simplepath.lastIndexOf("/"));
                    break;
                default:
                    simplepath += "/" + dir;
                    break;
            }
        }

        if(simplepath.length() == 0) {
            simplepath = "/";
        }

        return simplepath;
    }
}