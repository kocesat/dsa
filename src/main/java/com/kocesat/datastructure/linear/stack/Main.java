package com.kocesat.datastructure.linear.stack;

import com.kocesat.datastructure.linear.stack.impl.TwoStacks;

public class Main {
    public static void main(String[] args) {
//        String str = "([1] + <2>)";
//        System.out.println(new Expression(str).isBalanced());
//        var reverser = new StringReverser();
//        System.out.println(reverser.reverse(str));

//        Stack stack = new Stack();
//        stack.push(10);
//        stack.push(11);
//        stack.push(80);
//        stack.push(1);
//        System.out.println(stack.getMinimum());
//        stack.pop();
//        System.out.println(stack.getMinimum());
//        stack.print();

        TwoStacks stacks = new TwoStacks();
        stacks.push1(10);
        stacks.push1(14);
        stacks.push1(16);
        stacks.push2(20);
        stacks.push2(22);
        stacks.push2(25);
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
    }
}
