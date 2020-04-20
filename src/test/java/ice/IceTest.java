package ice;

import Ice.InitializationData;
import mecabInfo.JapineseMecabPrx;
import mecabInfo.JapineseMecabPrxHelper;
import org.junit.Test;

import java.util.Map;

public class IceTest {

    public void getIceResult(String context,String language){

        Ice.Communicator communicator = null;
        try {
            InitializationData initializationData = new InitializationData();
            initializationData.properties = Ice.Util.createProperties();
            initializationData.properties.setProperty("Ice.MessageSizeMax", "204800");
            //初始化ice通信器communicator,可以使用args传入一下ice初始化的参数如超时时间，线程池大小等
            communicator = Ice.Util.initialize(initializationData);
            // 传入远程服务单元的 ice对象标识符  协议默认tcp 主机 已经服务监听端口
            Ice.ObjectPrx op = communicator.stringToProxy(icrPort);
            // 检查通用客户端代理op 是不是queryServer对象标识符所关联的ice对象的代理
            JapineseMecabPrx japineseMecabPrx = JapineseMecabPrxHelper.checkedCast(op);
            if(japineseMecabPrx == null){
                throw new Exception("qp == null");
            }
            // 调用接口
            long start = System.currentTimeMillis();
            Map<String, String> pictureStr = japineseMecabPrx.getPictureStr(context, language);
            long end = System.currentTimeMillis();
            // 输出服务端返回结果
            System.out.println("文件名:"+context+"."+language+"用时:"+(end-start)+"毫秒!");
            for (String key:pictureStr.keySet()) {
                System.out.println(key+":"+pictureStr.get(key));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    String icrPort="JapineseMecabPrxServer:default -h 192.168.0.114 -p 20006";
    /**
     * 短句
     */
    @Test
    public void shortSentence(){
        String context="太郎は二郎にこの本を渡した.";
        String language="";
      getIceResult(context,language);
    }

    /**
     * 空句子
     */
    @Test
    public void nullSentence(){
        String context="";
        String language="";
        getIceResult(context,language);
    }

    /**
     * 空句子
     */
    @Test
    public void nullSentence2(){
        String context=null;
        String language="";
        getIceResult(context,language);
    }

    /**
     * 长句子
     */
    @Test
    public void longSentence(){
        String context="安康電話カードの浄化設備の安徽省は偶然にも投獄したので、喫茶店で黒板ふきを開催します。安徽快减肥哈克解放後に寝たことがあります。" +
                "v本文はflash飛行機のカラオケをたくさん出しました。皆さんの分歧カードを浪費しています。昔の無気力な社会人と相手の雷克沙さんは反関数の空間が混" +
                "ざっているのを見ました。";
        String language="";
        getIceResult(context,language);
    }

    /**
     * 数字
     */
    @Test
    public void number(){
        String context="123456,4654653,3894567,1092348";
        String language="";
        getIceResult(context,language);
    }

    /**
     * 符号
     */
    @Test
    public void symbol(){
        String context="❤❥웃유♋☮✌☏☢☠✔☑♚▲♪✈✞÷↑↓◆◇⊙■□△▽¿─│♥❣♂♀☿Ⓐ✍✉☣☤✘☒♛▼♫";
        String language="";
        getIceResult(context,language);
    }

    /**
     * 中文
     */
    @Test
    public void chinese(){
        String context="安康电话卡净化设备的安徽看啥抠脚大汉为偶然因为偶入狱在咖啡馆筹备召开黑板擦我安徽快速减肥哈克解放后里睡过觉欧文u哦i天涯爱好者客服中心," +
                "v本文首发了很多flash飞机卡拉浪费大家分厘卡的荒古苦无社工和对方雷克沙看见反函数的空间混合安排付阿皮u柔佛气温u日期[哦[七日坡区热普";
        String language="";
        getIceResult(context,language);
    }
}
