package com.hyf.mybatis.typehandler;

/**
 * 自定义枚举
 */
public enum UserStatusEnum {

    BORN(10, "出生"),
    EAT(20, "吃"),
    PLAY(30, "玩"),
    WORK(40, "工作"),
    DIED(50, "死亡");

    private int code;
    private String msg;

    UserStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 通过枚举的状态码获取对应枚举对象
     *
     * @param code
     * @return
     */
    static UserStatusEnum getUserStatusEnum(int code) {
        switch (code) {
            case 10:
                return BORN;
            case 20:
                return EAT;
            case 30:
                return PLAY;
            case 40:
                return WORK;
            case 50:
                return DIED;
            // 默认设置为 BORN 状态
            default:
                return BORN;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
