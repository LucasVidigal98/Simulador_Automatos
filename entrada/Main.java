package entrada;

import java.nio.file.Path;
import java.nio.file.Paths;
import view.TelaPrincipal;

public class Main {

    public static void main(String[] args) {
        
        TelaPrincipal tela1 = null;
        
        if(tela1 == null){
            tela1 = new TelaPrincipal();
            tela1.setVisible(true);
        }else{
           tela1.setVisible(true);
        }
        //Arquivo arq = new Arquivo(path.toString());
        //arq.leituraArquivo();
    }

}
