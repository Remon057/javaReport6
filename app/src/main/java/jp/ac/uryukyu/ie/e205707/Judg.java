package jp.ac.uryukyu.ie.e205707;

import java.util.concurrent.ArrayBlockingQueue;



import java.util.ArrayList;
import java.util.List;
/**
 * 再入力、負けを判定する。
 */
public class Judg{
    //一度使った文字を保存するリストを作成。
    List<String> usedWordList = new ArrayList<String>();

    /**
     * 入力が平仮名とーであるかの判定。
     * @param word　入力された文字列
     * @return　true(◯) or false(×)
     */
    public boolean hiragana(String word){
        if(word == null || !word.matches("^[\\u3040-\\u309F\\ー]+$")){
            return false;
        }else{ return true; }
    }

    /**
     * 入力が３文字であるかの判定。
     * @param word　入力された文字列
     * @return　true(◯) or false(×)
     */
    public boolean wordCount(String word){
        if(word.length() == 3){
            return true;
        }else{ return false; }
    }

    /**
     * しりとりの文字が繋がっているかの判定。
     * 「ー」を省き、小文字を大文字に変換した文字列で考える。
     * @param befor　前の言葉
     * @param after　後の言葉
     * @return　true(◯) or false(×)
     */
    public boolean wordConnect(String  befor, String after){
        //befor = wordSet(befor);
        if(befor.charAt(befor.length() - 1 ) == after.charAt(0) ){
            return true;
        }else{ return false; }
    }

    /**
     * 最後の文字が『ん』であるかを判定する。
     * @param word　入力された文字
     * @return　true(ん以外) or false(ん)
     */
    public boolean loseWord(String word){
        if(word.substring(word.length()-1).equals("ん")){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 使った言葉をリストに入れる。
     * @param word　入力された文字
     */
    public void addWord(String word){
        usedWordList.add(word);
    }

    /**
     * 一度使われた言葉かを判断する。
     * @param word　入力された文字
     * @return　true(使われてない) or false(使われた)
     */
    public boolean usedWord(String word){
        return !usedWordList.contains(word);
    }

}