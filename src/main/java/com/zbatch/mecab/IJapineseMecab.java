package com.zbatch.mecab;


import mecabInfo.MecabException;

import java.util.Map;

public interface IJapineseMecab {

    /**
     *
     * @param context 需要进行分词的日文
     * @return
     */
    Map<String,String> japinesePartic(String context) throws MecabException;
}
