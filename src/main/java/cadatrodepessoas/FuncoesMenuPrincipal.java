/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadatrodepessoas;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose Teixeira
 */
public class FuncoesMenuPrincipal {
    private Cadastro[] cadastro=new Cadastro[100];
    private int cont=0, aux=-1;
    
    public int tratamentoCodigo(int codigo){
        int codigo2=0;
        while(codigo2==0){
            try{
                codigo2=Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo (números):"));     
            }catch(NumberFormatException caracters){
                JOptionPane.showMessageDialog(null,"O codigo informado é invalido, digite um codigo apenas com numeros!");
            }
        }
        return codigo2;
    }
    
    public void cadastrarPessoa(){
        int codigo=0;
        if(cont<cadastro.length){
            codigo=this.tratamentoCodigo(codigo);
            if(cont>0){
                while(verificarCodigoExiste(codigo)){
                    JOptionPane.showMessageDialog(null,"O codigo informado ja existe, digite um codigo diferente!");
                    codigo=this.tratamentoCodigo(codigo);
                }
            }
            cadastro[cont]=new Cadastro(codigo, JOptionPane.showInputDialog("Informe o nome:"),
                                                JOptionPane.showInputDialog("Informe o telefone:"));
            cont++;
        }else{
            JOptionPane.showMessageDialog(null,"Infelismente não podemos "
                        + "cadastrar novas pessoas por falta de espaço!");
        }
    }
    
    public void listarPessoa(){
        if(this.classificarCodigo()){
        JOptionPane.showMessageDialog(null,"Dados da pessoa procurada:"
                                + "\nCodigo: "+cadastro[aux].getCodigo()
                                + "\nNome: "+cadastro[aux].getNome()
                                + "\nTelefone: "+cadastro[aux].getTelefone());
        }
    }
    
    public void alterarPessoa(){
        if(this.classificarCodigo()){
            int opcoesDeEdicao=0;
            do{
                try{
                    opcoesDeEdicao=Integer.parseInt(JOptionPane.showInputDialog("Opções:"
                                        + "\n1. Editar Codigo."
                                        + "\n2. Editar Nome."
                                        + "\n3. Editar Telefone"
                                        + "\n4. Retornar ao Menu Principal."));
                }catch(NumberFormatException opcoesValidas2){
                    
                }
                
                switch(opcoesDeEdicao){
                    case 1:
                        int novoCodigo=0;
                        novoCodigo=this.tratamentoCodigo(novoCodigo);
                        if(cont>0){
                            while(verificarCodigoExiste(novoCodigo)){
                            JOptionPane.showMessageDialog(null,"O codigo informado ja existe, digite um codigo diferente!");
                            novoCodigo=this.tratamentoCodigo(novoCodigo);
                        }
        }
                        cadastro[aux].setCodigo(novoCodigo);
                        JOptionPane.showMessageDialog(null,"Alteração realizada com scesso!");
                    break;
                    case 2:
                        cadastro[aux].setNome(JOptionPane.showInputDialog("Informe o novo nome:",cadastro[aux].getNome()));
                        JOptionPane.showMessageDialog(null,"Alteração realizada com scesso!");
                    break;
                    case 3:
                        cadastro[aux].setTelefone(JOptionPane.showInputDialog("Informe o novo telefone:", cadastro[aux].getTelefone()));
                        JOptionPane.showMessageDialog(null,"Alteração realizada com scesso!");
                    break;
                    case 4:
                        
                    break;
                    default: JOptionPane.showMessageDialog(null,"Opção invalida!");
                }
            }while(opcoesDeEdicao!=4);
        }
    }
    
    public void excluirPessoa(){
        if(this.classificarCodigo()){
            if(aux<(cont-1)){
                Cadastro cadastroAux=new Cadastro();
                for(int i=aux;i<(cont-1);i++){
                    cadastroAux=new Cadastro(cadastro[i+1].getCodigo(),
                                             cadastro[i+1].getNome(),
                                             cadastro[i+1].getTelefone());
                    cadastro[i]=cadastroAux;
                }
            
            }
            cont--;
            cadastro[cadastro.length-1]=null;
            JOptionPane.showMessageDialog(null,"Cadastro excluido com scesso!");
        }
    }
    
    public boolean classificarCodigo(){
        boolean bool=false;
        if(cont==0){
            JOptionPane.showMessageDialog(null,"Ainda nõ existe pessoas cadastradas!");
        }else{
            
            int codigo=0;
            aux=-1;
            try{
                codigo=Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo da pessoa:"));
            }catch(NumberFormatException a){
                
            }
            
            if(verificarCodigoExiste(codigo)){
                bool=true;
            }
            if(aux==-1){
                JOptionPane.showMessageDialog(null,"Cadastro não encontrada!");
            }
        }
        return bool;
    }
    
    public boolean verificarCodigoExiste(int codigo){
        boolean bool=false;
            for(int i=0;i<cont;i++){
                if(cadastro[i].getCodigo()==codigo){
                    aux=i;
                    bool=true;
                }
            }

        return bool;
    }
}
