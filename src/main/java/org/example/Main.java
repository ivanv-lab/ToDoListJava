package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> todo=new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
    String scan="";
    while (scan!="quite") {
        scan=sc.nextLine();
        if(scan.indexOf("add",0)==0 && scan.contains("<") && scan.contains(">")){
            String op=scan.substring(scan.indexOf("<")+1,scan.indexOf(">"));
            add(op);
        }
        else if(scan.equals("print")){
            print("");
        }
        else if(scan.equals("print [all]")){
            print("all");
        }
        else if(scan.indexOf("toggle",0)==0 && scan.contains("<") && scan.contains(">")){
            try {
                String op = scan.substring(scan.indexOf("<") + 1, scan.indexOf(">"));
                toggle(Integer.parseInt(op));
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("delete",0)==0 && scan.contains("<") && scan.contains(">")){
            try {
                String op = scan.substring(scan.indexOf("<") + 1, scan.indexOf(">"));
                delete(Integer.parseInt(op));
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("edit",0)==0 && scan.contains("<") && scan.contains(">")){
            try {
                int p1 = 0, p2 = 0;
                for (int i = 0; i < scan.length(); i++) {
                    if (scan.toCharArray()[i] == '<') p1++;
                    if (scan.toCharArray()[i] == '>') p2++;
                }
                if (p1 == 2 && p2 == 2) {
                    String op = scan.substring(scan.indexOf("<") + 1, scan.indexOf(">"));
                    int p = scan.indexOf(">");
                    scan = scan.substring(p + 1, scan.length());
                    String op1 = scan.substring(scan.indexOf("<") + 1, scan.indexOf(">"));
                    edit(Integer.parseInt(op), op1);
                }
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.indexOf("search",0)==0 && scan.contains("<") && scan.contains(">")){
            try {
                String op = scan.substring(scan.indexOf("<") + 1, scan.indexOf(">"));
                search(op);
            }
            catch (Exception e){
                System.out.println("Введите корректные данные");
            }
        }
        else if(scan.equals("quite"))
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
    static void quite(){
        return;
    }
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
                todo.set(i - 1, "[] " + n);
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

