package 栈;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private static int getSignGrade(char sign){
        if(sign=='*'||sign=='/'){
            return 2;
        }else if(sign == '+' || sign=='-'){
            return 1;
        }else {
            throw new RuntimeException("符号错误");
        }
    }
    private static int twoNumCalculation(int num1,int num2,char sign){
        switch (sign){
            case '+': return num1+num2;
            case '-': return num1-num2;
            case '*': return num1*num2;
            case '/': return num1/num2;
            default:throw new RuntimeException("符号错误");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(calculation(s));
    }
    public static int calculation(String s){
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> signStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp=0;
            while (i<chars.length&&Character.isDigit(chars[i])){
                temp=temp*10+(chars[i]-'0');
                i++;
            }
            numStack.push(temp);
            if(i>=chars.length){
                break;
            }
            if(!signStack.isEmpty()&&getSignGrade(signStack.peek())>=getSignGrade(chars[i])){
                int num2=numStack.pop();
                int num1=numStack.pop();
                numStack.push(twoNumCalculation(num1,num2,signStack.pop()));
            }
            signStack.push(chars[i]);
        }
        while (!numStack.empty()&&!signStack.empty()){
            int num2=numStack.pop();
            int num1=numStack.pop();
            numStack.push(twoNumCalculation(num1,num2,signStack.pop()));
        }
        return numStack.pop();
    }
}
