package com.zbatch.mecab.impl;

import com.zbatch.mecab.IJapineseMecab;
import mecabInfo.MecabException;
import org.chasen.mecab.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class JapineseMecab implements IJapineseMecab {
    static {
        try {
            System.loadLibrary("MeCab");
            System.out.println(MeCab.VERSION);
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
            System.exit(1);
        }
    }

    @Override
    public Map<String, String> japinesePartic(String context) throws MecabException {
        if (null==context||"".equals(context)){
            throw  new MecabException("输入文本异常:"+context);
        }
        Tagger tagger = new Tagger("-l2 -a -F\"%m %f[0]\\n\" ");
        tagger.parse(context);
        Node node = tagger.parseToNode(context);
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (;node != null; node = node.getNext()) {
            try {
                String surface = node.getSurface();
                String feature = node.getFeature();
                feature=feature.substring(0,feature.indexOf(","));
                String oldFeature = linkedHashMap.get(surface);
                if(surface!=null&&!"".equals(surface)){
                    if (oldFeature !=null&&!oldFeature.contains(feature)){
                        linkedHashMap.put(surface,oldFeature+","+feature);
                    }else {
                        linkedHashMap.put(surface,feature);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        for (String key:linkedHashMap.keySet()) {
            System.out.println(key+":"+linkedHashMap.get(key));
        }
        return linkedHashMap;
    }
}
