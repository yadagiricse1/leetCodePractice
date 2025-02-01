package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlternateKilling {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(); //treat this list as a circular linked list using modulo operator
        int n = 10;
        for(int i=1; i<=n; i++){
            ll.add(i);
        }

        int i=0;
        while(ll.size()>1){
            i = (i+1)%n; // iterate to got to the next in a cicrular fashion so use modulo
            ll.remove(i); //kill the next person and remove them from linkedlist
            n--;
        }
        System.out.println(ll.get(0)); //winner remains
    }


    }


