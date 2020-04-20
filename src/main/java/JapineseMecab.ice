module mecabInfo{


exception MecabException{string Message;};//自定义的异常

 dictionary<string, string> CustomMap;//自定义map

 interface JapineseMecab{

/**
 *对日文进行mecab分词
 **/
 CustomMap getPictureStr(string context,string language) throws MecabException;
 
 };
 
 
};