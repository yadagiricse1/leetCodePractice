package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ChangeDirectory {
    public  static String fullPath( String cmd, String input) {
        Stack<String> stack;
        if (!input.contains(".")) {

            return !input.contains("/") ? "/" + input : input;
        } else {
            String[] paths = (cmd + "/" + input).split("/");
            stack = new Stack<>();
            for (int i = 0; i < paths.length; i++) {
                if (paths[i].equals("..")){
                    if (!stack.isEmpty())
                        stack.pop();

                }
                if (paths[i].equals(".")||paths[i].isBlank()) {
                    System.out.println();

                } else {
                    stack.push(paths[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pop());
        }

        return !sb.isEmpty() ? sb.toString() : "/";

    }


    public static String changeDirectory(String currentDir, String path) {
        if (path.startsWith("/")) {
            return handleAbsolutePath(path);
        } else {
            return handleRelativePath(currentDir, path);
        }
    }

    private static String handleAbsolutePath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        Arrays.stream(path.split("/")).filter(part -> !part.isEmpty() && !part.equals(".")).forEach(part -> {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(part);
            }
        });

        return "/" + String.join("/", stack);
    }


    private static String handleRelativePath(String currentDir, String path) {
        LinkedList<String> stack;
        if(currentDir.equals("/")) {
            stack = new LinkedList<>();
        } else {
            stack = new LinkedList<>(Arrays.asList(currentDir.split("/")));
        }
        Arrays.stream(path.split("/")).filter(part -> !part.isEmpty() && !part.equals(".")).forEach(part -> {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(part);
            }
        });
        if (stack.isEmpty())
            return "/";
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(changeDirectory("/home/user", "documents/reports")); // Output: /home/user/documents/reports
        System.out.println(changeDirectory("/home/user/documents", "../..")); // Output: /home
        System.out.println(changeDirectory("/","home/user")); // /home/user
        System.out.println(changeDirectory("/home/user", "/etc/")); // /etc
        System.out.println(changeDirectory("/home/user", "/")); // /
        System.out.println("Che ck below results");
        System.out.println(changeDirectory("/", "foo")); // /
        System.out.println(changeDirectory("/baz", "/bar")); // /
        System.out.println(changeDirectory("/x/y", "../p/../q")); // /
        System.out.println(changeDirectory("/baz/abc", "/bar")); // /
        System.out.println(changeDirectory("/x/y", "../p/../q ")); // /
        System.out.println(changeDirectory("/", "../p/../q ")); // /

        System.out.println("Che ck below results");
     //   System.out.println(fullPath("/", "foo")); // /
     //   System.out.println(fullPath("/baz", "/bar")); // /
        System.out.println(fullPath("/x/y", "../p/../q")); // /
        //System.out.println(fullPath("/baz/abc", "/bar")); // /
        System.out.println(fullPath("/x/y", "../p/../q ")); // /
        System.out.println(fullPath("/", "../p/../q ")); // /

/*
        | cwd      | cd (arg)       | output
                | -------- | -------------- | ------
                | /        | foo            | /foo
                | /baz     | /bar           | /bar
                | /x/y     | ../p/../q      | /x/q
                | /baz/abc     | /bar       | /bar
                | /x/y     | ../p/../q      | /x/q
                | /        | ../p/../q      | /q*/
    }
}