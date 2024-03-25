package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> todo=new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
    String scan="";
    while (scan!="quit") {
        scan=sc.nextLine();
        if(scan.indexOf("add",0)==0 ){
            String op=scan.substring(4,scan.length());
            add(op);
        }
        else if(scan.equals("print")){
            print("");
        }
        else if(scan.equals("print all")){
            print("all");
        }
        else if(scan.indexOf("toggle",0)==0){
            try {
                String op = scan.substring(7, scan.length());
                toggle(Integer.parseInt(op));
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("delete",0)==0){
            try {
                String op = scan.substring(7, scan.length());
                delete(Integer.parseInt(op));
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("edit",0)==0){
            try {
                scan=scan.trim();
                int i1=scan.indexOf(' ');
                int i2=scan.lastIndexOf(' ');
                String op=scan.substring(i1+1,i2);
                String op1=scan.substring(i2+1,scan.length());
                edit(Integer.parseInt(op), op1);
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("search",0)==0){
            try {
                String op = scan.substring(7, scan.length());
                search(op);
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.equals("quit"))
            return;
        else{
            System.out.println("Неверная команда");
        }
        }
    }

   static void add(String ex){
        todo.add("[ ] "+ex);
    }
    static void print(String all){
        if(all==""){
            for(int i=0;i<todo.size();i++){
                if(!todo.get(i).contains("[X]")){
                    System.out.println(i+1+". "+todo.get(i));
                }
            }
        }
        else if (all=="all"){
            for(int i=0;i<todo.size();i++){
                System.out.println(i+1+". "+todo.get(i));
            }
        }
    }
    static void toggle(int i){
            String tod;
            i--;
            if (i<todo.size()) {
                if (todo.get(i).contains("[X]")) {
                    tod = todo.get(i).replace("[X]", "[ ]");
                } else {
                    tod = todo.get(i).replace("[ ]", "[X]");
                }
                todo.set(i, tod);
            }
            else {
                System.out.println("Неверный номер задачи");
                return;
            }
    }
//    static void quit(){
//        return;
//    }
    static void delete(int i) {
            if(i-1<todo.size()) {
                todo.remove(i - 1);
            }
            else {
                System.out.println("Неверный номер задачи");
                return;
            }
    }
    static void edit(int i, String n){
            if(i-1<todo.size()) {
                todo.set(i - 1, "[ ] " + n);
            }
            else{
                System.out.println("Неверный номер задачи");
                return;
            }
    }
    static void search(String sub){
    for(String s:todo){
        if (s.contains(sub))
            System.out.println(s);
        }
    }
}

