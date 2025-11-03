/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aulatries;

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

}
