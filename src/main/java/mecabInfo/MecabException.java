// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `MecabException.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package mecabInfo;

public class MecabException extends Ice.UserException
{
    public MecabException()
    {
    }

    public MecabException(Throwable cause)
    {
        super(cause);
    }

    public MecabException(String Message)
    {
        this.Message = Message;
    }

    public MecabException(String Message, Throwable cause)
    {
        super(cause);
        this.Message = Message;
    }

    public String
    ice_name()
    {
        return "mecabInfo::MecabException";
    }

    public String Message;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString("::mecabInfo::MecabException");
        __os.startWriteSlice();
        __os.writeString(Message);
        __os.endWriteSlice();
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readString();
        }
        __is.startReadSlice();
        Message = __is.readString();
        __is.endReadSlice();
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception mecabInfo::MecabException was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception mecabInfo::MecabException was not generated with stream support";
        throw ex;
    }
}
