package 栈;

import java.util.Scanner;
import java.util.Stack;

/**
 * 中缀表达式转后缀
 * @author 胡茂洋
 */
public class Express {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println(infixTranToSuffix(scanner.nextLine()));
    }
    private static int getSignGrade(char sign){
        if(sign=='*'||sign=='/'){
            return 2;
        }else if(sign == '+' || sign=='-'){
            return 1;
        }else {
            throw new RuntimeException("符号错误");
        }
    }
    public static String infixTranToSuffix(String s){
        Stack<Character> numStack=new Stack<>();
        Stack<Character> symbolStack=new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(Character.isDigit(c)){
                numStack.push(c);
            }else {
                if(')'==c){
                    while (!symbolStack.isEmpty()){
                        char symbol = symbolStack.pop();
                        if(symbol=='('){
                            break;
                        }else {
                            numStack.push(symbol);
                        }
                    }
                } else if('('==c||symbolStack.isEmpty()||symbolStack.peek()=='('||getSignGrade(c)>getSignGrade(symbolStack.peek())){
                    symbolStack.push(c);
                } else{
                    while (!symbolStack.empty()&&getSignGrade(symbolStack.peek())>=getSignGrade(c)){
                        numStack.push(symbolStack.pop());
                    }
                    symbolStack.push(c);
                }
            }
        }
        while (!symbolStack.isEmpty()){
            numStack.push(symbolStack.pop());
        }
        StringBuffer ans=new StringBuffer();
        while (!numStack.isEmpty()){
            ans.insert(0,numStack.pop());
        }
        return ans.toString();
    }
}
