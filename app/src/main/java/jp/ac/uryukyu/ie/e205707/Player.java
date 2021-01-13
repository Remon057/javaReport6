package jp.ac.uryukyu.ie.e205707;
import java.util.Scanner;
/**
 * プレーヤーの入力を行う。
 */
public class Player{
    Scanner scan = new Scanner(System.in);
    /**
     * プレーヤーに入力をさせる。
     * @param befor 前の言葉
     * @return 入力した文字
     */
    public String input(String befor){ 
        String str = scan.nextLine();
        return str; 
    }
       
}