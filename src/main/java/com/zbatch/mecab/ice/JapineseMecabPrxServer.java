package com.zbatch.mecab.ice;

import Ice.InitializationData;

public class JapineseMecabPrxServer {
    public static void main(String[] args) {
        int state = 0;
        Ice.Communicator communicator = null;
        try {
            //初使化
            InitializationData initializationData = new InitializationData();
            initializationData.properties = Ice.Util.createProperties();
            initializationData.properties.setProperty("Ice.MessageSizeMax", "204800");
            //初始化ice通信器communicator,可以使用args传入一下ice初始化的参数如超时时间，线程池大小等
            communicator = Ice.Util.initialize(initializationData);
            //创建一个名为queryEmployeeAdapter的适配器并且默认使用tcp协议  服务部署在10.4.30.81机器上 服务开启10006监听端口
            Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("JapineseMecabPrxServer","default -p 20006");
            // 创建服务端代码实现servant
            JapineseMecabPrx servant = new JapineseMecabPrx();
            // 将servant与ice对象标识符建立映射关系，并添加到ice对象适配器中
            adapter.add(servant, Ice.Util.stringToIdentity("JapineseMecabPrxServer"));
            // 激活对象适配器
            adapter.activate();
            System.out.println("PictureProcessPrxServer adapter activate");
            // 服务在退出之前一直保持监听状态
            communicator.waitForShutdown();
        } catch (Exception e) {
            // TODO: handle exception
            state = 1;
            System.out.println(e);
        }
        System.out.println("state: "+ state);
    }
}
