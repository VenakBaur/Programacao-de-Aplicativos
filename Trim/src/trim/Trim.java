package trim;

import javax.swing.JOptionPane;

public class Trim {

    public static void main(String[] args) {
        
        String fraseDoDia = JOptionPane.showInputDialog("Digite a frase do dia: ");
        
        JOptionPane.showMessageDialog(null, "Frase do dia sem trim: " + fraseDoDia);
        
        JOptionPane.showMessageDialog(null, "Frase do dia com trim: " + fraseDoDia.trim());
        
        String frase = JOptionPane.showInputDialog("Informe uma frase");
        
        JOptionPane.showMessageDialog(null, "tirando os espaços vazios da palavra: " 
                + "\n" + frase + "\n" + frase.replace(" ",""));
        
        int tamanhoString = frase.length();
        
        JOptionPane.showMessageDialog(null, "Tamanho da frase: " + tamanhoString);
        
    }
    
}
