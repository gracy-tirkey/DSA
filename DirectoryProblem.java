import java.util.Stack;

public class DirectoryProblem {
    public static void main(String[] args) {
        String directoryPath = "path/to//../your/directory"; 
        String res = simplifyPath(directoryPath);
        System.out.println("Simplified Path: " + res);
    }

    static String simplifyPath(String A){
        Stack<String> stack = new Stack<>();
        int n = A.length();

        for(int i = 0; i < n; i++){
            StringBuilder temp = new StringBuilder();
            while(i < n && A.charAt(i) != '/'){
                temp.append(A.charAt(i));
                i++;
            }
            String part = temp.toString();
            if(part.equals("") || part.equals(".")){
                continue;
            }
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(part);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, "/" + stack.pop());
        }
        return res.toString();
    }
}
