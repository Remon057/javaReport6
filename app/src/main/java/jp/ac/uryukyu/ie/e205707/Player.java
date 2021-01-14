package jp.ac.uryukyu.ie.e205707;
import java.util.Scanner;
/**
 * プレイヤーの入力を行う。
 */
public class Player{
    Scanner scan = new Scanner(System.in);
    /**
     * プレイヤーに入力をさせる。
     * @return 入力した文字
     */
    public String input(){ 
        String str = scan.next();
        return str; 
    }
       
}