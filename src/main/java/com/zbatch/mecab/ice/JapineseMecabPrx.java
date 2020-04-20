package com.zbatch.mecab.ice;

import Ice.Current;
import com.zbatch.mecab.IJapineseMecab;
import com.zbatch.mecab.impl.JapineseMecab;
import mecabInfo.MecabException;
import mecabInfo._JapineseMecabDisp;

import java.util.Map;

public class JapineseMecabPrx extends _JapineseMecabDisp {
    @Override
    public Map<String, String> getPictureStr(String context, String language, Current __current) throws MecabException {
        IJapineseMecab iJapineseMecab=new JapineseMecab();
//        Map<String, String> stringStringMap;
//        while (true){
//          stringStringMap = iJapineseMecab.japinesePartic(context);
//            for (String key:stringStringMap.keySet()) {
//                System.out.println(key+":"+stringStringMap.get(key));
//            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        Map<String, String> stringStringMap=null;

        stringStringMap = iJapineseMecab.japinesePartic(context);

        return stringStringMap;
    }
}
