package jp.ac.uryukyu.ie.e205707;
/**
 * プレーヤーとコンピュータの敗北を決定する
 */
class GameResult{
    private boolean result = true;
    Judge ju = new Judge();

    /**
     * resultのゲッターメソッド
     * @return　　true or false
     */
    public boolean getResult(){
        return this.result;
    }

    /**
     * プレイヤーに入力、再入力をさせて負け、続行を判定する。
     * resultに負けか続行を代入する：true(続行) or false(負け)
     * @param befor　前の言葉
     * @return　答え
     */
    public String playerResult(String before){
        Player player = new Player();
        before = ju.getHiragana(before);
        String answer;
        String check;
        while(true){
            answer = player.input();
            check = ju.getHiragana(answer);
            if(ju.loseWordkousann(answer) || ju.loseWordkousann(check)){
                System.out.println("(★｀・ω・)ゞﾗｼﾞｬ　\n降参しました、あなたの負けです");
                check = "降参";
                break;
            }else if(!ju.hiragana(check)){
                System.out.println("(^O^) 全部平仮名かカタカナで入力してね");
                continue;
            }else if(!ju.wordConnect(before, check)){
                System.out.println("((；ﾟДﾟ))『"+ju.wordSet(before).charAt(before.length() - 1)+"』から始まる言葉だよ");
                continue;
            }else if(!ju.wordCount(check)){
                System.out.println("(｀・ω・´)　３文字の言葉だよ");
                continue;
            }else if(!ju.usedWord(check)){
                System.out.println("(｀∇´)　一度使われた言葉だよ");
                continue;
            }else{ break; }
        }
        if(ju.loseWordkousann(check)){
            result = false;
            return check;
        }else if(!ju.loseWord(check)){
            System.out.println("(^.^) 「ん」だよ〜　あなたの負け");
            result = false;
            return answer;
        }else{
            ju.addWord(check);
            result = true;
            return answer;
        }   
    }
    
    /**
     * コンピュータに出力させて負け、続行を判定する。
     * resultに負けか続行を代入する：true(続行) or false(負け)
     * @param before　前の言葉
     * @return　答え
     */
    public String computerResult(String before){
        Computer computer = new Computer();
        before = ju.getHiragana(before);
        String answer = computer.computerAnswer(before , ju);
        
        if(answer == null){
            System.out.println(">_<　ん〜思いつかない・・・参りました〜");
            result = false;
            return answer;
        }else{
            System.out.println(answer);
            ju.addWord(ju.getHiragana(answer));
            result = true;
            return answer;
        }
    }
    
}