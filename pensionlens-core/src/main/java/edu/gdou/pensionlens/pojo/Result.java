package edu.gdou.pensionlens.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {           /*封装结果类*/
    private Integer code;
    private String message;
    private Object data;

    /*方法是静态的，但是整个对象和对应的数据不是静态的，都是可以根据需要随时创建使用的*/
    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public static Result success(){
        return new Result(200,"success",null);
    }

    public static Result success(Object data){
        return new Result(200,"success",data);
    }

    public static Result error(String msg){
        return new Result(500,msg,null);
    }

    public static Result success(Integer code, String msg){
        return new Result(code,msg,null);
    }

    public static Result error(Integer code, String msg){
        return new Result(code,msg,null);
    }


}
