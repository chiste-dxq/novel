package com.chiste.novel.common.enums;

public enum BusinessType {
    /**
     * 其它
     */
    OTHER("other"),

    /**
     * 新增
     */
    INSERT("insert"),

    /**
     * 修改
     */
    UPDATE("update"),

    /**
     * 删除
     */
    DELETE("delete"),

    /**
     * 授权
     */
    GRANT("grant"),

    /**
     * 导出
     */
    EXPORT("export"),

    /**
     * 导入
     */
    IMPORT("import"),

    /**
     * 强退
     */
    FORCE("force"),

    /**
     * 生成代码
     */
    GENCODE("gencode"),

    /**
     * 清空
     */
    CLEAN("clean");

    private String type;

    BusinessType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
