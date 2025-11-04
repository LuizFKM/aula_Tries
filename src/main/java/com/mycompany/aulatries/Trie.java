/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aulatries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizfkm
 */
public class Trie {
    private NoTrie raiz;
    
    public Trie(){
    raiz = new NoTrie();
        
    }
    
    public void inserir(String palavra){
        NoTrie  atual = raiz;
        for(int i = 0; i < palavra.length(); i++){
            char caractere = palavra.charAt(i);
            
            //Mapeando o indice pelo caractere
            //a = , b = 1 e assim por diante
            
            //faz a conta pelo UNICODE
            int indice = caractere - 'a';
            
            if(atual.filhos[indice] == null){
                atual.filhos[indice] = new NoTrie();
            }
            //passando para o proximo caractere
            atual = atual.filhos[indice];
        }
        atual.fimPalavra = true;
    }
    
    public boolean buscar(String palavra){
        NoTrie atual = raiz;
        
        for(int i = 0; i < palavra.length(); i++){
            char caractere = palavra.charAt(i);
            int indice = caractere - 'a';
            
            if(atual.filhos[indice] == null){
                //se antes de terminar de percorrer a palavra encontrarmos um null, retorna falso, quer dizer que a palavra
                //nao esta na trie
                return false;
            }
            atual = atual.filhos[indice];
        }
        return true; //se percorrer a apalvra toda ate a flag, ela existe.
    }
    
    public List<String> autoComplete(String prefix){
        List<String> resultados = new ArrayList<>();
        NoTrie atual = raiz;
        
        //Vamos ate o no final do prefixo
        for (int i = 0; i < prefix.length(); i++){
            char caractere = prefix.charAt(i);
            int indice = caractere - 'a';
            if(atual.filhos[indice] == null){
                return resultados;
            }
            atual = atual.filhos[indice];
        }
        
        //Agora que estamos no final do prefixo procuramos as ramificacoes
        
        buscarPalavras(atual, prefix, resultados);
        return resultados;
    }

    private void buscarPalavras(NoTrie atual, String palavra, List<String> resultados) {
        if(atual.fimPalavra){
            resultados.add(palavra);
        }
        for (int i = 0; i < 26; i++){
            if(atual.filhos[i] != null){
                char proximaLetra = (char)('a'+i);
                buscarPalavras(atual.filhos[i], palavra+proximaLetra, resultados);//metodo rescursivo, chama ele mesmo ate encontrar fim da palavra
                
            }
        }
    }

}
