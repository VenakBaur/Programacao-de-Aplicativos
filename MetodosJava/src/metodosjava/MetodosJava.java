package metodosjava;

import javax.swing.JOptionPane;

public class MetodosJava {
    
    public static void imprimir() {
        
        System.out.println("Aprendendo linguagem Java");
        
    }
    
    public static void imprimirTexto(String texto) {
        
        System.out.println(texto);
        
    }
    
    public static void somar(int a, int b) {
        
        System.out.println("Somar:" + (a + b));
        
    }
    
    public static void quadrado(int a) {
        
        System.out.println(Math.pow(a,2));
        
    }
    
    public static void maior(int a, int b, int c) {
        
        System.out.println(Math.max(a,Math.max(b,c)));
        
    }
    
    public static void sexo (char c) {
        
        String teste = "";
        
        teste = JOptionPane.showInputDialog("M para Masculino\n"
                + "F para Feminino");
        
        c = teste.charAt(0);
        
        c = Character.toUpperCase(c);
        
        switch (c) {
            
            case 'F' ->
                System.out.println("Feminino");
            case 'M' ->
                System.out.println("Masculino");
            default ->
                System.out.println("Desconhecido");
            
        }
        
    }
    
}
