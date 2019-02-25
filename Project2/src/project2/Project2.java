/*
Darryl Green 
CIS 2353
Baugh 
03/29/2018
Project 2
*/
import java.util.*;

public class Project2 
{
    public static void main(String args[]) 
    {
        char[] stack=new char[1000];
        int top=-1; // empty stack 
        
        Scanner Scn=new Scanner(System.in);
        String parenthesis=Scn.nextLine(); // takes user input
        
        boolean isWellformed=true; // by default, the parenthesis are assumed to be well formed unless an anomoly is encountered
        
        for(int i=0;i<parenthesis.length();i++)
        {
            if(parenthesis.charAt(i)=='(') // if the opening parenthesis are encountered, push it into the stack
                top=push(stack,'(',top);
            
            try 
            {
                if(parenthesis.charAt(i)==')') // if closing parenthesis are encountered, pop the last opening parenthesis from the stack
                    top=pop(stack,top);
            }
            catch(IllegalStateException e) // In the case, the pop returns IllegalStateException , that means the stack cannot be popped, and the parenthesis are not well formed.
            {
                isWellformed=false;
                top=-2;
                
                break;
            }
        }
        
        if(top==-1) // if the stack is empty, the parenthesis are balanced
        {
            isWellformed=true;
        }
        
        else // if the stack is not empty or the top is illegal with a -2 value, the parenthesis are not balanced
            isWellformed=false;
        
        if(!isWellformed)
            System.out.println("This is not the input you are looking for.");
        else
            System.out.println("Well whaddya know. This is the input you are looking for.");
    }

  

static int push(char[] stack,char ch,int top)
{
    top++; // increments the top, and then pushes the char onto the stack
    
    stack[top]=ch;
    return top;

  

}

  

static int pop(char[] stack,int top) throws IllegalStateException

{
    if(top>=0) // if the stack isn't empty, it only pops the last element

{
    top--;
    return top;
}
    
    throw new IllegalStateException(); // if the stack is empty, it cannot be popped anymore, return an exception 

}
} // end program