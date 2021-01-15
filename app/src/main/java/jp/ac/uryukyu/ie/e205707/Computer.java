package jp.ac.uryukyu.ie.e205707;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * コンピュータの出力を行う。
 * テキストファイルを読み込み、その中の言葉を使ってしりとりを行う。
 */
public class Computer {
    /**
     * コンピュータのしりとりの出力。
     * dictionary.txtというテキストファイルを読み込んで
     * その中から前の言葉に続く言葉を探している。存在しないときはnullを返す。コンピュータの出力
     * @param befor 前の言葉
     * @param judg 後の言葉
     * @return  コンピュータの出力
     */
    public String computerAnswer(String befor , Judge judg){
        String answer = null;
        try{
            File file = new File("dictionary.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);   
            while((answer = bufferedReader.readLine()) != null){
                String check = judg.getHiragana(answer);
                if(judg.wordConnect(befor, check)){
                    if(judg.usedWord(check)){
                    break;
                    }
                }
            }
            bufferedReader.close();
        }catch(FileNotFoundException e){
            System.out.println("dictionary.txtが見つかりません。");
        }catch(Exception e){
            System.out.println(e);
        }
        return answer;    
    }


}