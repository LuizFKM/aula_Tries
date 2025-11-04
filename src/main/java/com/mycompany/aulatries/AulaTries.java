/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aulatries;

/**
 *
 * @author luizfkm
 */
public class AulaTries {

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.inserir("casa");
        trie.inserir("carro");
        trie.inserir("computador");
        trie.inserir("cachorro");
        trie.inserir("palmeiras");
        trie.inserir("palavra");
        trie.inserir("palatavel");
        trie.inserir("patrulha");
        trie.inserir("pato");
        
        System.out.println("A palavra casa existe no Trie? " + trie.buscar("casa"));
        System.out.println("A palavra brasil existe no Trie? " + trie.buscar("brasil"));
        System.out.println("A palavra cachorro existe no Trie? " + trie.buscar("cachorro"));
        
        System.out.println("Quais palavras comecam com pa"+trie.autoComplete("pa"));
    }
}
